<template>
  <div class='Banks'>
    <div class="search">
      银行：
      <el-select v-model="search.bankId" clearable>
        <el-option
          v-for="item in $store.state.banksOptions"
          :key="item.bankId"
          :label="item.bankName"
          :value="item.bankId">
        </el-option>
      </el-select>
      <el-input style="width: 500px" v-model="search.input" placeholder="请输入银行详细名称" clearable/>
      <el-button @click="handleSearch(search.input,search.bankId)">查询</el-button>
    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="button">
      <el-button @click="addVisible = true">新增</el-button>
    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="content">
      <Table :tableData="tableData" style="width: 100%">
        <el-table-column
          property="bankName"
          label="银行"
          width="100">
        </el-table-column>
        <el-table-column
          property="branchName"
          label="银行详细名称"
          width="">
        </el-table-column>
        <el-table-column
          property="managerName"
          label="客户经理"
          width="">
        </el-table-column>
        <el-table-column
          property="managerPhone"
          label="客户经理电话"
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
            <el-button @click="modify(scope.row.branchId)" type="text" size="small">修改</el-button>
            <el-button @click="del(scope.row.branchId)" type="text" size="small">删除</el-button>
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
      >
        <div>
          <div class="content">
            <el-form ref="addForm" :model="Form" size="mini" label-width="140px">
              <el-row>
                <el-col :span="12">
                  <el-form-item label="贷款银行：" prop="bankId" :rules="$rules.NotEmpty">
                    <el-select v-model="Form.bankId" clearable placehodler="请选择银行">
                      <el-option
                        v-for="item in $store.state.banksOptions"
                        :key="item.bankId"
                        :label="item.bankName"
                        :value="item.bankId">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="审批银行：" prop="branchName" :rules="$rules.NotEmpty">
                    <el-input v-model="Form.branchName"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="12">
                  <el-form-item label="客户经理：" prop="managerName" :rules="$rules.NotEmpty">
                    <el-input v-model="Form.managerName"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="联系电话：" prop="managerPhone" :rules="$rules.NotEmpty">
                    <el-input v-model="Form.managerPhone"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="特殊情况描述：" prop="branchDesc">
                    <el-input type="textarea" v-model="Form.branchDesc"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </div>
          <hr style="border: 0.5px solid #D7D7D7">
          <div class="dialog-footer">
            <el-button @click="addVisible = false" size="mini">取消</el-button>
            <el-button @click="save('addForm')" size="mini">保存</el-button>
            <el-button @click="initFormData" size="mini">重置</el-button>
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

  export default {
    name: "Banks",
    data() {
      return {
        search: {
          input: '',
          bankId:''
        },
        searchKey: {
          input: '',
          bankId:''
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
        Form: this.formDemo(),
        //查看渠道
        seeVisible: false,
        //修改渠道
        modifyVisible: false
      }
    },
    components: {
      Table, Dialog, Pagination
    },
    mounted() {
      let vm = this;
      vm.getData();
    },
    methods: {
      initFormData() {
        let vm = this;
        vm.Form = vm.formDemo();
        vm.$refs.addForm.resetFields();
      },

      formDemo(){
        return {
          bankId: "",  //总行
          bankName: "",
          branchId: "",//银行
          branchName: "",
          managerName: "",
          managerPhone: "",
          caseCount: '',
          branchDesc:''
        }
      },
      //获取数据
      getData(currentPage = '1') {
        let vm = this;
        vm.pageInfo.pageIndex = currentPage;
        vm.$api.branchsList({
          bankId:vm.searchKey.bankId,
          branchName: vm.searchKey.input,
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
      handleSearch(input,bankId) {
        let vm = this;
        vm.searchKey.input = input;
        vm.searchKey.bankId = bankId;
        vm.getData();
      },
      //翻页
      currentChange(currentPage) {
        let vm = this;
        vm.getData(currentPage)
      },
      //新增 -- 保存
      save(formName) {
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          vm.$api.addOrUpdateSingleBranch(vm.Form).then(res => {
            vm.$message.success(res.msg);
            vm.addVisible = false;
            vm.getData(this.pageInfo.pageIndex);
          })
        }
      },
      see(branchId) {
        let vm = this;
        vm.$api.getSingleBranch({branchId}).then(res => {
          vm.Form = res.data;
          vm.seeVisible = true;
        })
      },
      modify(branchId) {
        let vm = this;
        vm.$api.getSingleBranch({branchId}).then(res => {
          vm.Form = res.data;
          vm.addVisible = true;
        })
      },
      del(branchId) {
        let vm = this;
        vm.$confirm('此操作将永久删除该条数据, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          vm.$api.deleteBranch({branchId}).then(res => {
            vm.$message.success(res.msg);
            vm.getData(this.pageInfo.pageIndex);
          });
        }).catch(() => {

        });
      },
    }
  }
</script>

<style lang='scss' scoped>
  .Banks {
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
  }
</style>
