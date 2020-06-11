<template>
  <div class='Organizations'>
    <div class="button">
      <el-button @click="addVisible = true">新增机构</el-button>
    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="content">
      <Table :tableData="tableData">
        <el-table-column
          property="orgName"
          label="组织机构名称"
          width="">
        </el-table-column>
        <el-table-column
          property="superOrgName"
          label="上级组织机构"
          width="">
        </el-table-column>
        <el-table-column
          property="orgAddress"
          label="组织机构办公地址"
          show-overflow-tooltip
          width="200">
        </el-table-column>
        <el-table-column
          property="orgLeaderName"
          label="负责人"
          width="">
        </el-table-column>
        <el-table-column
          property="createTime"
          label="创建时间"
          :formatter="rowDateFormat"
          width="200">
        </el-table-column>
        <el-table-column
          property="userCount"
          label="员工数"
          width="">
        </el-table-column>
        <el-table-column
          property="operator"
          label="操作"
          width="200px">
          <template slot-scope="scope">
            <el-button @click="modify(scope.row.orgId)" type="text" size="small">修改</el-button>
            <el-button @click="del(scope.row.orgId)" type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </Table>
      <Pagination :total="pageInfo.totalItems"
                  @changePage="currentChange"
                  :currentPage="pageInfo.pageIndex"
                  :pageSize="pageInfo.pageSize"/>
    </div>

    <div class="dialog">
      <!--  新增 + 修改 模态框-->
      <Dialog :title="''"
              :show.sync="addVisible"
              @closedDialog="initFormData"
              @openDialog="openDialog"
      >
        <div>
          <div class="content">
            <el-form ref="addForm" :model="Form" size="mini" label-width="130px">
              <el-row>
                <el-col :span="24">
                  <el-form-item label="组织机构名称：" prop="orgName" :rules="$rules.NotEmpty">
                    <el-input v-model="Form.orgName"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="上级组织机构：" prop="superOrgId" :rules="$rules.NotEmpty">
                    <el-select v-model="Form.superOrgId" clearable filterable>
                      <el-option
                        v-for="item in orgAll"
                        :key="item.orgId"
                        :label="item.orgName"
                        :value="item.orgId">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="办公地址：" prop="orgAddress" :rules="$rules.NotEmpty">
                    <el-input v-model="Form.orgAddress"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="20">
                  <el-form-item label="负责人：" prop="orgLeaderName" :rules="$rules.NotEmpty">
                    <el-input v-model="Form.orgLeaderName" disabled></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="4">
                  <el-form-item label-width="10px">
                    <el-button size="mini" @click="orgLeaderVisible = true">选择...</el-button>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="人员：" prop="userInfoList">
                    <el-button type="primary" @click="addUserVisible = true">增加</el-button>
                    <el-button @click="deleteUser">删除</el-button>
                    <split></split>
                    <Table :tableData="Form.userInfoList" @handleChange="selectDel">
                      <el-table-column
                        type="selection"
                        width="55">
                      </el-table-column>
                      <el-table-column
                        property="userName"
                        label="姓名"
                        width="">
                      </el-table-column>
                      <el-table-column
                        property="orgName"
                        label="当前所属组织机构"
                        width="">
                      </el-table-column>
                      <el-table-column
                        property="userRoles"
                        label="当前角色"
                        width="">
                        <div slot-scope="scope">
                          {{getRoles(scope.row.userRoles)}}
                        </div>
                      </el-table-column>
                    </Table>
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

      <!--人员表--单选-->
      <Dialog
        :title="''"
        :show.sync="orgLeaderVisible"
        @openDialog="openOrgLeaderDialog"
      >
        <div class="textCenter">
          姓名:
          <el-input size="mini" style="width: 400px" v-model="userSearch.input" placeholder="请输入银行详细名称" clearable/>
          <el-button size="mini" @click="handleUserSearch(userSearch.input)">查询</el-button>
        </div>
        <Split></Split>
        <Table :tableData="userAll" :height="'400px'">
          <el-table-column
            label="选择"
            width="50">
            <template slot-scope="scope">
              <el-radio :label="scope.row.userId" v-model="Form.orgLeaderId"
                        @change="selectLeader(scope.$index,scope.row)">&nbsp;
              </el-radio>
            </template>
          </el-table-column>
          <el-table-column
            property="userName"
            label="姓名"
            width="">
          </el-table-column>
          <el-table-column
            property="orgName"
            label="当前所属组织机构"
            width="">
          </el-table-column>
        </Table>
        <Split></Split>
        <div class="textCenter">
          <el-button @click="addLeader">确定</el-button>
        </div>
      </Dialog>

      <!--人员表--多选-->
      <Dialog
        :title="''"
        :show.sync="addUserVisible"
        @openDialog="openOrgLeaderDialog"
      >
        <div class="textCenter">
          姓名:
          <el-input size="mini" style="width: 400px" v-model="userSearch.input" placeholder="请输入银行详细名称" clearable/>
          <el-button size="mini" @click="handleUserSearch(userSearch.input)">查询</el-button>
        </div>
        <Split></Split>
        <Table :tableData="userAll" :height="'400px'" @handleChange="selectUsers">
          <el-table-column
            type="selection"
            width="55">
          </el-table-column>
          <el-table-column
            property="userName"
            label="姓名"
            width="">
          </el-table-column>
          <el-table-column
            property="orgName"
            label="当前所属组织机构"
            width="">
          </el-table-column>
        </Table>
        <Split></Split>
        <div class="textCenter">
          <el-button @click='AddUsers'>确定</el-button>
        </div>
      </Dialog>

    </div>
  </div>
</template>

<script>
  import Split from '../../../components/split/Split';
  import Table from '../../../components/table/Table';
  import Dialog from '../../../components/dialog/Dialog';
  import Pagination from '../../../components/pagination/Pagination';

  export default {
    name: "Organizations",
    data() {
      return {
        search: {
          input: ''
        },
        searchKey: {
          input: ''
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
        Form: {
          orgId: "", // 组织机构ID
          orgName: "", // 组织机构名称
          superOrgId: "", // 上级组织机构ID
          superOrgName: "", // 上级组织机构名称
          orgAddress: "", // 办公地址
          orgLeaderId: "", // 负责人ID
          orgLeaderName: "", // 负责人名
          createTime: "", // 创建时间
          userCount: "",// 员工数
          userInfoList: [] // 人员
        },
        seeVisible: false,
        modifyVisible: false,
        orgAll: [],
        orgLeaderVisible: false,
        userAll: [],
        tempUser: [],
        userSearch: {
          input: ''
        },
        addUserVisible: false
      }
    },
    mounted() {
      let vm = this;
      vm.getData();

    },
    components: {
      Table, Dialog, Pagination, Split
    },
    methods: {
      initFormData() {
        let vm = this;
        vm.Form = vm.organizationForm();
        vm.$refs.addForm.resetFields();
      },
      organizationForm(){
        return {
          orgId: "", // 组织机构ID
          orgName: "", // 组织机构名称
          superOrgId: "", // 上级组织机构ID
          superOrgName: "", // 上级组织机构名称
          orgAddress: "", // 办公地址
          orgLeaderId: "", // 负责人ID
          orgLeaderName: "", // 负责人名
          createTime: "", // 创建时间
          userCount: "",// 员工数
          userInfoList: [] // 人员
        }
      },
      //获取数据--分页
      getData(currentPage = '1') {
        let vm = this;
        vm.pageInfo.pageIndex = currentPage;
        vm.$api.orgList({
          orgName: vm.searchKey.input,
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
      handleSearch(input) {
        let vm = this;
        vm.searchKey.input = input;
        vm.getData();
      },
      openDialog() {
        let vm = this;
        vm.$api.orgList({
          pageNum: '1',
          pageSize: '99999',
        }).then(res => {
          vm.orgAll = res.data;
        })
      },
      getUserList(input) {
        let vm = this;
        vm.$api.getUserList({
          userName: input,
          pageNum: '1',
          pageSize: '99999'
        }).then(res => {
          vm.userAll = res.data;
        })
      },
      openOrgLeaderDialog() {
        let vm = this;
        vm.userSearch.input = '';
        vm.getUserList(vm.userSearch.input)
      },
      handleUserSearch(input) {
        let vm = this;
        vm.getUserList(input);
      },
      selectLeader(index, row) {
        let vm = this;
        vm.tempUser = [];
        vm.tempUser = row;
      },
      addLeader() {
        let vm = this;
        vm.orgLeaderVisible = false;
        vm.Form.orgLeaderId = vm.tempUser.userId;
        vm.Form.orgLeaderName = vm.tempUser.userName;
        vm.tempUser = [];
      },
      selectUsers(val) {
        let vm = this;
        vm.tempUser = [];
        vm.tempUser = val;
      },
      AddUsers() {
        let vm = this;
        vm.addUserVisible = false;
        vm.Form.userInfoList = [...vm.Form.userInfoList, ...vm.tempUser];
        vm.Form.userInfoList = vm.$util.ArrayFn.arrObjUnique(vm.Form.userInfoList, 'userId');
        vm.tempUser = [];
      },
      selectDel(val) {
        let vm = this;
        vm.tempUser = [];
        vm.tempUser = val;
      },
      deleteUser() {
        let vm = this;
        vm.Form.userInfoList = vm.$util.ArrayFn.arrObjDiff(vm.Form.userInfoList, vm.tempUser, 'userId');
      },


      //新增 -- 保存
      save(formName) {
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          vm.$api.addOrUpdateSingleOrganization(
            {
              ...vm.Form, userInfoList: vm.Form.userInfoList.map(userItem => {
                return {
                  userId: userItem.userId
                }
              })
            }
          ).then(res => {
            vm.$message.success(res.msg);
            vm.addVisible = false;
            vm.getData(this.pageInfo.pageIndex);
          })
        }
      },
      //翻页
      currentChange(currentPage) {
        let vm = this;
        vm.getData(currentPage)
      },

      modify(orgId) {
        let vm = this;
        vm.$api.getSingleOrganization({orgId}).then(res => {
          vm.Form = res.data;
          vm.addVisible = true;
        })
      },
      del(orgId) {
        let vm = this;
        vm.$confirm('此操作将永久删除该条数据, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          vm.$api.deleteOrganization({orgId}).then(res => {
            vm.$message.success(res.msg);
            vm.getData(this.pageInfo.pageIndex);
          });
        }).catch(() => {

        });
      },

      getRoles(userRoles) {
        let result = '';
        if (userRoles) {
          userRoles.map(role => {
            result += role.roleName + '、';
          });
        }
        if (result.length > 0)
          return result.substring(0, result.length - 1);
        return result;
      },
    }
  }
</script>

<style lang='scss' scoped>
  .Organizations {
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
