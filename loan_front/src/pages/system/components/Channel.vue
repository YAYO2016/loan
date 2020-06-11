<template>
    <div class='Channel'>
      <div class="channel-search">
<!--        渠道名称：-->
        <el-select v-model="search.channelType" clearable placeholder="渠道类型">
          <el-option v-for="item in $store.state.channelTypeOptions" :label="item.desc" :value="item.code" :key="item.code">
          </el-option>
        </el-select>
        <el-input style="width: 500px" v-model="search.channelName" placeholder="请输入渠道名称" clearable/>
        <el-button @click="handleSearch(search.channelName,search.channelType)">查询</el-button>
      </div>
      <hr style="border: 0.5px solid #D7D7D7">
      <div class="button">
        <el-button @click="addChannelVisible=true;editFlag=true;">新增</el-button>
      </div>
      <hr style="border: 0.5px solid #D7D7D7">
      <div class="content">
        <Table :tableData="tableData">
          <el-table-column
            property="channelType"
            label="渠道类型"
            :formatter="channelTypeFormat"
            width="">
          </el-table-column>
          <el-table-column
            property="channelName"
            label="渠道名称"
            show-overflow-tooltip
            width="">
          </el-table-column>
          <el-table-column
            property="bossName"
            label="联系人"
            width="">
          </el-table-column>
          <el-table-column
            property="bossMphone"
            label="联系电话"
            width="">
          </el-table-column>
          <el-table-column
            property="caseCount"
            label="案子数"
            width="">
          </el-table-column>
          <el-table-column
            property="operator"
            label="操作"
            width="200px">
            <template slot-scope="scope">
              <el-button @click="seeChannel(scope.row.channelId)" type="text" size="small">查看</el-button>
              <el-button @click="modifyChannel(scope.row.channelId)" type="text" size="small">修改</el-button>
              <el-button @click="deleteChannel(scope.row.channelId)" type="text" size="small">删除</el-button>
            </template>
          </el-table-column>
        </Table>
        <Pagination :total="pageInfo.totalItems"
                    @changePage="currentChange"
                    :currentPage="pageInfo.pageIndex"
                    :pageSize="pageInfo.pageSize"/>
      </div>

      <div class="dialog">
        <Dialog :title="''"
                :show.sync="addChannelVisible"
                @closedDialog="initFormData"
                :width="'1000px'"
        >
          <div>
            <div class="content">

              <el-form ref="addChannelForm" :model="addChannelForm" size="mini" label-width="130px">
                <el-card>
                  <div slot="header" class="clearfix">
                    <span>渠道基本信息</span>
                  </div>
                  <div>
                    <el-row>
                      <el-col :span="24">
                        <el-form-item label="渠道名称：" prop="channelName" :rules="$rules.NotEmpty">
                          <span v-if="!editFlag">{{addChannelForm.channelName}}</span>
                          <el-input v-else v-model="addChannelForm.channelName"></el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="12">
                        <el-form-item label="渠道类型：" prop="channelType" :rules="$rules.NotEmpty">
                          <span v-if="!editFlag">{{channelTypeLowFormat(addChannelForm.channelType)}}</span>
                          <el-select  v-else v-model="addChannelForm.channelType" clearable>
                            <el-option v-for="item in $store.state.channelTypeOptions" :label="item.desc" :value="item.code" :key="item.code">
                            </el-option>
                          </el-select>
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item label="渠道地址：" prop="channelAddress" :rules="$rules.NotEmpty">
                          <span v-if="!editFlag">{{addChannelForm.channelAddress}}</span>
                          <el-input v-else v-model="addChannelForm.channelAddress"></el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="8">
                        <el-form-item label="渠道电话：" prop="channelPhone" :rules="$rules.NotEmpty">
                          <span v-if="!editFlag">{{addChannelForm.channelPhone}}</span>
                          <el-input v-else v-model="addChannelForm.channelPhone"></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="8">
                        <el-form-item label="渠道负责人：" prop="bossName" :rules="$rules.NotEmpty">
                          <span v-if="!editFlag">{{addChannelForm.bossName}}</span>
                          <el-input v-else v-model="addChannelForm.bossName"></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="8">
                        <el-form-item label="负责人手机：" prop="bossMphone" :rules="$rules.NotEmpty">
                          <span v-if="!editFlag">{{addChannelForm.bossMphone}}</span>
                          <el-input v-else v-model="addChannelForm.bossMphone"></el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="8">
                        <el-form-item label="结算人：" prop="accountName" :rules="$rules.NotEmpty">
                          <span v-if="!editFlag">{{addChannelForm.accountName}}</span>
                          <el-input v-else v-model="addChannelForm.accountName"></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="8">
                        <el-form-item label="结算卡开户行：" prop="accountBank" :rules="$rules.NotEmpty">
                          <span v-if="!editFlag">{{addChannelForm.accountBank}}</span>
                          <el-input v-else v-model="addChannelForm.accountBank"></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="8">
                        <el-form-item label="账号：" prop="accountNo" :rules="$rules.NotEmpty">
                          <span v-if="!editFlag">{{addChannelForm.accountNo}}</span>
                          <el-input v-else v-model="addChannelForm.accountNo"></el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                  </div>
                </el-card>
                <Split/>
                <el-card>
                  <div slot="header" class="clearfix">
                    <span>渠道对接人信息</span>
                    <el-button v-if="editFlag" style="float: right; padding: 3px 0" type="text"
                               @click="addPerson">新增
                    </el-button>
                  </div>
                  <div>
                    <Table :tableData="addChannelForm.staffInfos">
                      <el-table-column
                        v-if="editFlag"
                        width="50">
                        <template slot-scope="scope">
                          <span>
                            <i class="el-icon-remove" style="color: red;font-size: 20px"
                               @click="delPerson(scope.$index)"></i>
                          </span>
                        </template>
                      </el-table-column>
                      <el-table-column
                        property="staffName"
                        label="对接人姓名"
                        width="">
                        <template slot-scope="scope">
                          <span v-if="!editFlag">{{ scope.row.staffName }}</span>
                          <span v-else>
                            <el-input v-model="addChannelForm.staffInfos[scope.$index].staffName"></el-input>
                          </span>
                        </template>
                      </el-table-column>
                      <el-table-column
                        property="staffTel"
                        label="对接人电话"
                        width="">
                        <template slot-scope="scope">
                          <span v-if="!editFlag">{{ scope.row.staffTel }}</span>
                          <span v-else>
                            <el-input v-model="addChannelForm.staffInfos[scope.$index].staffTel"></el-input>
                          </span>
                        </template>
                      </el-table-column>
                      <el-table-column
                        property="staffDuty"
                        label="对接人职务"
                        width="">
                        <template slot-scope="scope">
                          <span v-if="!editFlag">{{$util.StorageFn.getEnumDesc($store.state.channelStaffDutyOptions,scope.row.staffDuty)}}</span>
                          <span v-else>
                            <el-select v-model="addChannelForm.staffInfos[scope.$index].staffDuty" clearable>
                              <el-option v-for="item in $store.state.channelStaffDutyOptions" :label="item.desc"
                                         :value="item.code" :key="item.code"></el-option>
                            </el-select>
                          </span>
                        </template>
                      </el-table-column>
                    </Table>
                  </div>
                </el-card>
              </el-form>
            </div>
            <hr style="border: 0.5px solid #D7D7D7">
            <div class="dialog-footer" v-if="editFlag">
              <el-button @click="addChannelVisible = false" size="mini">取消</el-button>
              <el-button @click="saveChannel('addChannelForm')" size="mini">保存</el-button>
              <el-button @click="initFormData" size="mini">重置</el-button>
            </div>
            <div class="dialog-footer" v-else>
              <el-button @click="addChannelVisible = false" size="mini">关闭</el-button>
            </div>
          </div>
        </Dialog>

      </div>
    </div>
</template>

<script>
  import Table from '../../../components/table/Table';
  import Split from '../../../components/split/Split';
  import Dialog from '../../../components/dialog/Dialog';
  import Pagination from '../../../components/pagination/Pagination';

  export default {
        name: "Channel",
        data() {
          return {
            editFlag: false,
            search: {
              channelName: '',
              channelType: ''
            },
            searchKey: {
              channelName: '',
              channelType: ''
            },
            pageInfo: {
              pageIndex: "1",
              pageSize: "10",
              totalItems: "0",
              totalPages: "0",
              offSet: "0"
            },
            tableData: [],
            addChannelVisible: false,
            addChannelForm: this.channelForm(),
            //查看渠道
            seeChannelVisible: false,
            //修改渠道
            modifyChannelVisible: false
          }
        },
    components: {
      Table, Dialog, Pagination, Split
    },
    mounted() {
      let vm = this;
      vm.getChannelData();
    },
    methods: {
      initFormData() {
        let vm = this;
        vm.addChannelForm = vm.channelForm();
        vm.$refs.addChannelForm.resetFields();
      },
      channelForm() {
        return {
          channelId: "",
          channelType: "",
          channelName: "",
          channelPhone: "",
          channelAddress: "",
          bossName: "",
          bossMphone: "",
          accountName: "",
          accountBank: "",
          accountNo: "",
          staffInfos: [
            {
              staffId: "",
              channelId: "",
              staffName: "",
              staffTel: "",
              staffDuty: "",
              createTime: ""
            }
          ]
        }
      },
      //获取数据
      getChannelData(currentPage = '1') {
        let vm = this;
        vm.pageInfo.pageIndex = currentPage;
        vm.$api.getChannelList({
          channelName: vm.searchKey.channelName,
          channelType: vm.searchKey.channelType,
          pageNum: vm.pageInfo.pageIndex,
          pageSize: vm.pageInfo.pageSize,
        }).then(res => {
          if(vm.pageInfo.pageIndex !=='1' && res.data === null && res.data === []){
            vm.getChannelData('1');
          }
          vm.tableData = res.data;
          vm.pageInfo = res.pageInfo;
        })
      },
      //搜索
      handleSearch(channelName, channelType) {
        let vm = this;
        vm.searchKey.channelName = channelName;
        vm.searchKey.channelType = channelType;
        vm.getChannelData();
      },
      //新增 -- 保存
      saveChannel(formName) {
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          // 对接人姓名不允许为空
          let allowSubmit = true;
          if (vm.addChannelForm.staffInfos) {
            vm.addChannelForm.staffInfos.map(staffInfo => {
              if (!staffInfo.staffName || vm.$util.StringFn.trim(staffInfo.staffName, 2) === '') {
                vm.$message.error('对接人姓名不允许为空！');
                allowSubmit = false;
              }
            });
          }
          if (allowSubmit)
            vm.$api.addChannel(vm.addChannelForm).then(res => {
              vm.$message.success(res.msg);
              vm.addChannelVisible = false;
              vm.getChannelData(this.pageInfo.pageIndex);
            })
        }
      },
      //新增--重置
      resetChannel(formName) {
        this.$refs[formName].resetFields();
      },
      //翻页
      currentChange(currentPage) {
        let vm = this;
        vm.getChannelData(currentPage)
      },
      seeChannel(channelId) {
        let vm = this;
        vm.$api.getSingleChannel({channelId}).then(res => {
          vm.addChannelForm = res.data;
          vm.addChannelVisible = true;
          vm.editFlag = false;
        })
      },
      modifyChannel(channelId) {
        let vm = this;
        vm.$api.getSingleChannel({channelId}).then(res => {
          vm.addChannelForm = res.data;
          vm.addChannelVisible = true;
          vm.editFlag = true;
        })
      },
      deleteChannel(channelId) {
        let vm = this;
        vm.$confirm('此操作将永久删除该条数据, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          vm.$api.deleteChannel({channelId}).then(res => {
            vm.$message.success(res.msg);
            vm.getChannelData(this.pageInfo.pageIndex);
          });
        }).catch(() => {
          // vm.$message({
          //   type: 'info',
          //   message: '已取消删除'
          // });
        });
      },
      addPerson() {
        let vm = this;
        vm.addChannelForm.staffInfos.push(
          {
            staffId: "",
            channelId: "",
            staffName: "",
            staffTel: "",
            staffDuty: "",
            createTime: ""
          }
        );
      },
      delPerson(rowIndex) {
        let vm = this;
        vm.addChannelForm.staffInfos.splice(rowIndex, 1);
      }

    }
  }
</script>

<style lang='scss' scoped>
    .Channel {
      .channel-search {
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
    }
</style>
