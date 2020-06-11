<template>
  <div class='Developers'>
    <div class="search">
      开发商：
      <el-input style="width: 200px" v-model="search.developerName" placeholder="请输入开发商名称" clearable/>
      &nbsp;
      楼盘：
      <el-input style="width: 200px" v-model="search.estateName" placeholder="请输入楼盘名称" clearable/>
      <el-button @click="handleSearch(search.developerName,search.estateName)">查询</el-button>
    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="button">
      <el-button @click="addVisible = true;editFlag=true;">新增</el-button>
    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="content">
      <Table :tableData="tableData" style="width: 100%">
        <el-table-column
          property="developerName"
          label="开发商名称"
          show-overflow-tooltip
          width="100">
        </el-table-column>
        <el-table-column
          property="developerAddr"
          label="开发商地址"
          show-overflow-tooltip
          width="">
        </el-table-column>
        <el-table-column
          property="estateName"
          label="楼盘名称"
          show-overflow-tooltip
          width="">
        </el-table-column>
        <el-table-column
          property="estateAddr"
          label="楼盘地址"
          show-overflow-tooltip
          width="">
        </el-table-column>
        <el-table-column
          property="operator"
          label="操作"
          width="200px">
          <template slot-scope="scope">
            <el-button @click="see(scope.row.developerId)" type="text" size="small">查看</el-button>
            <el-button @click="modify(scope.row.developerId)" type="text" size="small">修改</el-button>
            <el-button @click="del(scope.row.estateId)" type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </Table>
      <Pagination :total="pageInfo.totalItems"
                  @changePage="currentChange"
                  :currentPage="pageInfo.pageIndex"
                  :pageSize="pageInfo.pageSize"/>
    </div>

    <div class="dialog">
      <!--  新增 + 修改-->
      <Dialog :title="''"
              :show.sync="addVisible"
              @closedDialog="initFormData"
              :width="'900px'"
      >
        <div>
          <div class="content">
            <el-form ref="addForm" :model="Form" size="mini" label-width="140px">
              <el-card class="box-card">
                <div slot="header" class="clearfix">
                  <span>开发商信息</span>
                </div>
                <div>
                  <el-row>
                    <el-col :span="8">
                      <el-form-item label="开发商：" prop="developerName" :rules="$rules.NotEmpty">
                        <span v-if="!editFlag">{{Form.developerName}}</span>
                        <el-input v-else v-model="Form.developerName"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="16">
                      <el-form-item label="开发商地址：" prop="developerAddr" :rules="$rules.NotEmpty">
                        <span v-if="!editFlag">{{Form.developerAddr}}</span>
                        <el-input v-else v-model="Form.developerAddr"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="8">
                      <el-form-item label="开发商电话：" prop="developerTel" :rules="$rules.NotEmpty">
                        <span v-if="!editFlag">{{Form.developerTel}}</span>
                        <el-input v-else v-model="Form.developerTel"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="8">
                      <el-form-item label="财务负责人：" prop="financeName" :rules="$rules.NotEmpty">
                        <span v-if="!editFlag">{{Form.financeName}}</span>
                        <el-input v-else v-model="Form.financeName"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="8">
                      <el-form-item label="财务负责人手机：" prop="financeTel" :rules="$rules.TelRule">
                        <span v-if="!editFlag">{{Form.financeTel}}</span>
                        <el-input v-else v-model="Form.financeTel"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="8">
                      <el-form-item label="监管账户：" prop="accountNo" :rules="$rules.NotEmpty">
                        <span v-if="!editFlag">{{Form.accountNo}}</span>
                        <el-input v-else v-model="Form.accountNo"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="16">
                      <el-form-item label="开户行：" prop="accountBank" :rules="$rules.NotEmpty">
                        <span v-if="!editFlag">{{Form.accountBank}}</span>
                        <el-input v-else v-model="Form.accountBank"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                </div>
              </el-card>
              <Split></Split>
              <el-card>
                <el-tabs type="card" :editable="editFlag" @edit="handleTabsEdit" v-model="editableTabsValue">
                  <el-tab-pane :label="'楼盘'+(index+1)" :name="index+1+''" v-for="(item,index) in Form.estateInfos" :key="index">
                    <el-row>
                      <el-col :span="8">
                        <el-form-item label="楼盘名称：" :prop="'estateInfos.'+index+'.estateName'" :rules="$rules.NotEmpty">
                          <span v-if="!editFlag">{{item.estateName}}</span>
                          <el-input v-else v-model="item.estateName"></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="16">
                        <el-form-item label="楼盘地址：" :prop="'estateInfos.'+index+'.estateAddr'" :rules="$rules.NotEmpty">
                          <span v-if="!editFlag">{{item.estateAddr}}</span>
                          <el-input v-else v-model="item.estateAddr"></el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="8">
                        <el-form-item label="楼盘电话：":prop="'estateInfos.'+index+'.estateTel'" :rules="$rules.NotEmpty">
                          <span v-if="!editFlag">{{item.estateTel}}</span>
                          <el-input v-else v-model="item.estateTel"></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="8">
                        <el-form-item label="楼盘负责人：" :prop="'estateInfos.'+index+'.managerName'" :rules="$rules.NotEmpty">
                          <span v-if="!editFlag">{{item.managerName}}</span>
                          <el-input v-else v-model="item.managerName"></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="8">
                        <el-form-item label="楼盘负责人手机：" :prop="'estateInfos.'+index+'.managerTel'" :rules="$rules.TelRule">
                          <span v-if="!editFlag">{{item.managerTel}}</span>
                          <el-input v-else v-model="item.managerTel"></el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-card class="box-card">
                        <div slot="header" class="clearfix">
                          <span>楼盘销售人员信息</span>
                          <el-button v-if="editFlag" style="float: right; padding: 3px 0" type="text" @click="addSalesman(index)">新增</el-button>
                        </div>
                        <div>
                          <Table :tableData="item.salesmanInfos" style="width: 100%">
                            <el-table-column
                              v-if="editFlag"
                              width="50">
                              <template slot-scope="scope">
                                <span>
                                  <i class="el-icon-remove" style="color: red;font-size: 20px" @click="delSalesman(index,scope.$index)"></i>
                                </span>
                              </template>
                            </el-table-column>
                            <el-table-column
                              property="salesmanName"
                              label="姓名"
                              show-overflow-tooltip
                              width="80">
                              <template slot-scope="scope">
                                <span v-if="!editFlag">{{ scope.row.salesmanName }}</span>
                                <span v-else>
                                    <el-input v-model="item.salesmanInfos[scope.$index].salesmanName"></el-input>
                                </span>
                              </template>
                            </el-table-column>
                            <el-table-column
                              property="salesmanTel"
                              label="手机"
                              show-overflow-tooltip
                              width="100">
                              <template slot-scope="scope">
                                <span v-if="!editFlag">{{ scope.row.salesmanTel }}</span>
                                <span v-else>
                                    <el-input v-model="item.salesmanInfos[scope.$index].salesmanTel"></el-input>
                                </span>
                              </template>
                            </el-table-column>
                            <el-table-column
                              property="officeTel"
                              label="办公电话"
                              show-overflow-tooltip
                              width="100">
                              <template slot-scope="scope">
                                <span v-if="!editFlag">{{ scope.row.officeTel }}</span>
                                <span v-else>
                                    <el-input v-model="item.salesmanInfos[scope.$index].officeTel"></el-input>
                                </span>
                              </template>
                            </el-table-column>
                            <el-table-column
                              property="accountName"
                              label="账户名"
                              show-overflow-tooltip
                              width="100">
                              <template slot-scope="scope">
                                <span v-if="!editFlag">{{ scope.row.accountName }}</span>
                                <span v-else>
                                    <el-input v-model="item.salesmanInfos[scope.$index].accountName"></el-input>
                                </span>
                              </template>
                            </el-table-column>
                            <el-table-column
                              property="accountBank"
                              label="开户行"
                              show-overflow-tooltip
                              width="">
                              <template slot-scope="scope">
                                <span v-if="!editFlag">{{ scope.row.accountBank }}</span>
                                <span v-else>
                                    <el-input v-model="item.salesmanInfos[scope.$index].accountBank"></el-input>
                                </span>
                              </template>
                            </el-table-column>
                            <el-table-column
                              property="accountNo"
                              label="账号"
                              width="150">
                              <template slot-scope="scope">
                                <span v-if="!editFlag">{{ scope.row.accountNo }}</span>
                                <span v-else>
                                    <el-input v-model="item.salesmanInfos[scope.$index].accountNo"></el-input>
                                </span>
                              </template>
                            </el-table-column>
                          </Table>
                        </div>
                      </el-card>
                    </el-row>
                  </el-tab-pane>
                </el-tabs>
              </el-card>
            </el-form>
          </div>
          <hr style="border: 0.5px solid #D7D7D7">
          <div class="dialog-footer" v-if="editFlag">
            <el-button @click="addVisible = false" size="mini">取消</el-button>
            <el-button @click="save('addForm')" size="mini">保存</el-button>
            <el-button @click="initFormData" size="mini">重置</el-button>
          </div>
          <div class="dialog-footer" v-else>
            <el-button @click="addVisible = false" size="mini">关闭</el-button>
          </div>
        </div>
      </Dialog>

    </div>

  </div>
</template>

<script>
  import Table from '../../../components/table/Table';
  import Dialog from '../../../components/dialog/Dialog';
  import Pagination from '../../../components/pagination/Pagination';
  import Split from 'components/split/Split';

  export default {
    name: "Developers",
    components: {
      Table, Dialog, Pagination, Split
    },
    data() {
      return {
        search: {
          developerName: '',
          estateName: ''
        },
        searchKey: {
          developerName: '',
          estateName: ''
        },
        pageInfo: {
          pageIndex: "1",
          pageSize: "10",
          totalItems: "0",
          totalPages: "0",
          offSet: "0"
        },
        tableData: [],

        addVisible: false,
        editFlag: false,
        Form: this.formDemo(),
        editableTabsValue: '1',
        //查看渠道
        seeVisible: false,
        //修改渠道
        modifyVisible: false,
        activeName: ''
      }
    },
    mounted() {
      let vm = this;
      vm.getData();
    },
    methods: {
      initFormData() {
        let vm = this;
        vm.Form=vm.formDemo()
        vm.$refs.addForm.resetFields();
      },
      formDemo() {
        return {
          developerId: "",
          developerName: "",
          developerAddr: "",
          developerTel: "",
          financeName: "",
          financeTel: "",
          accountNo: "",
          accountBank: "",
          estateInfos: [
            {
              estateId: "",
              developerId: "",
              estateName: "",
              estateTel: "",
              estateAddr: "",
              managerName: "",
              managerTel: "",
              salesmanInfos: [
                {
                  salesmanId: "",
                  estateId: "",
                  salesmanName: "",
                  salesmanTel: "",
                  officeTel: "",
                  accountName: "",
                  accountBank: "",
                  accountNo: ""
                }
              ]
            }
          ]
        }
      },
      getData(currentPage = '1') {
        let vm = this;
        vm.pageInfo.pageIndex = currentPage;
        vm.$api.developersList({
          developerName: vm.searchKey.developerName,
          estateName: vm.searchKey.estateName,
          pageNum: vm.pageInfo.pageIndex,
          pageSize: vm.pageInfo.pageSize,
        }).then(res => {
          if (vm.pageInfo.pageIndex !== '1' && res.data === null && res.data === []) {
            vm.getData('1');
          }
          vm.tableData = res.data;
          vm.pageInfo = res.pageInfo;
        })
      },
      //搜索
      handleSearch(developerName, estateName) {
        let vm = this;
        vm.searchKey.developerName = developerName;
        vm.searchKey.estateName = estateName;
        vm.getData();
      },
      //翻页
      currentChange(currentPage) {
        let vm = this;
        vm.getData(String(currentPage))
      },
      //新增 -- 保存
      save(formName) {
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          vm.$api.addOrUpdateDeveloperInfo(vm.Form).then(res => {
            vm.$message.success(res.msg);
            vm.addVisible = false;
            vm.getData(this.pageInfo.pageIndex);
          })
        }
      },
      see(developerId) {
        let vm = this;
        vm.$api.getDeveloperInfo({developerId}).then(res => {
          vm.Form = res.data;
          vm.addVisible = true;
          vm.editFlag = false;
        })
      },
      modify(developerId) {
        let vm = this;
        vm.$api.getDeveloperInfo({developerId}).then(res => {
          vm.Form = res.data;
          vm.addVisible = true;
          vm.editFlag = true;
        })
      },
      del(estateId) {
        let vm = this;
        vm.$confirm('此操作将永久删除该条数据, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          vm.$api.deleteEstateInfo({estateId}).then(res => {
            vm.$message.success(res.msg);
            vm.getData(this.pageInfo.pageIndex);
          });
        }).catch(() => {

        });
      },
      handleTabsEdit(targetName, action) {
        let vm = this;
        if (action === 'add') {
          let newTabName = ++this.tabIndex + '';
          this.Form.estateInfos.push({
            estateId: "",
            developerId: "",
            estateName: "",
            estateTel: "",
            estateAddr: "",
            managerName: "",
            managerTel: "",
            salesmanInfos: [
              {
                salesmanId: "",
                estateId: "",
                salesmanName: "",
                salesmanTel: "",
                officeTel: "",
                accountName: "",
                accountBank: "",
                accountNo: ""
              }
            ]
          });
        }
        if (action === 'remove') {
          this.Form.estateInfos.splice(parseInt(targetName) - 1, 1)
        }
      },
      addSalesman(index){
        let vm = this;
        vm.Form.estateInfos[index].salesmanInfos.push(
          {
            salesmanId: "",
            estateId: "",
            salesmanName: "",
            salesmanTel: "",
            officeTel: "",
            accountName: "",
            accountBank: "",
            accountNo: ""
          }
        );
      },
      delSalesman(tabIndex,rowIndex){
        let vm = this;
        vm.Form.estateInfos[tabIndex].salesmanInfos.splice(rowIndex,1);
      }
    }
  }
</script>

<style lang='scss' scoped>
  .Developers {
    .search {
      height: 60px;
      line-height: 60px;
      margin-left: 20px;
    }

    .button {
      height: 60px;
      line-height: 60px;
      margin-left: 20px;
    }

    .content {
      padding: 20px;
    }

    /deep/ .el-tabs__new-tab {
      background: #169BD5;
    }
  }
</style>
