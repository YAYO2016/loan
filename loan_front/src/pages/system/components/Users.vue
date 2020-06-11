<template>
  <div class='Users'>
    <div class="search">
      用户名称：
      <el-input style="width: 500px" v-model="search.input" placeholder="请输入用户名称" clearable/>
      <el-button @click="handleSearch(search.input)">查询</el-button>
    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="button">
      <el-button @click="addVisible = true">新增用户</el-button>
    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="content">
      <Table :tableData="tableData" style="width: 100%">
        <el-table-column
          property="userName"
          label="用户名称"
          width="100">
        </el-table-column>
        <el-table-column
          property="userSex"
          label="性别"
          :formatter="rowSexFormat"
          width="60">
        </el-table-column>
        <el-table-column
          property="birthDay"
          label="出生日期"
          :formatter="rowDateFormat"
          width="100">
        </el-table-column>
        <el-table-column
          property="birthplace"
          label="籍贯"
          show-overflow-tooltip
          width="">
          <template slot-scope="scope">
            <div slot="reference">
              <span>{{$util.AreaFn.setArea(scope.row.birthplace)}}</span>
            </div>
          </template>
        </el-table-column>
        <el-table-column
          property="orgName"
          label="所属组织机构"
          width="100">
        </el-table-column>
        <el-table-column
          property="userRoles"
          label="归属角色"
          show-overflow-tooltip
          width="100">
          <template slot-scope="scope">
            <div slot="reference">
              <span>{{roleFormat(scope.row.userRoles)}}</span>
            </div>
          </template>
        </el-table-column>
        <el-table-column
          property="status"
          label="状态"
          :formatter="rowStatusFormat"
          width="60">
        </el-table-column>
        <el-table-column
          property="createUserName"
          label="创建人"
          width="100">
        </el-table-column>
        <el-table-column
          property="createTime"
          label="创建时间"
          :formatter="rowDateFormat"
          width="100">
        </el-table-column>
        <el-table-column
          property="operator"
          label="操作"
          width="200">
          <template slot-scope="scope">
            <el-button @click="see(scope.row.userId)" type="text" size="small">查看</el-button>
            <el-button @click="modify(scope.row.userId)" type="text" size="small">修改</el-button>
            <el-button @click="updateStatus(scope.row.userId,scope.row.status)" type="text" size="small">
              {{scope.row.status==='VALID'?'删除':'恢复'}}
            </el-button>
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
            <el-form ref="addForm" :model="Form" size="mini" label-width="130px">
              <el-row>
                <el-col :span="12">
                  <el-form-item label="用户姓名：" prop="userName" :rules="$rules.NotEmpty">
                    <el-input v-model="Form.userName"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="登陆账户：" prop="loginAccount" :rules="$rules.NotEmpty">
                    <el-input v-model="Form.loginAccount"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="12">
                  <el-form-item label="性别：" prop="userSex" :rules="$rules.NotEmpty">
                    <el-select v-model="Form.userSex" placeholder="请选择">
                      <el-option label="男" value="MALE"></el-option>
                      <el-option label="女" value="FEMALE"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="籍贯：" prop="birthplace" :rules="$rules.NotEmpty">
                    <el-cascader
                      :options="AreaOptions"
                      change-on-select
                      v-model="birthplaceArea"
                      @change="handleChange"
                    >
                    </el-cascader>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="12">
                  <el-form-item label="出生日期：" prop="birthDay" :rules="$rules.NotEmpty">
                    <el-date-picker
                      v-model="Form.birthDay"
                      type="date"
                      value-format="timestamp"
                      placeholder="选择日期">
                    </el-date-picker>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="用户密码：" prop="userPw">
                    <el-input type="password" v-model="Form.userPw"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="确认密码：" prop="confirmPwd">
                    <el-input type="password" v-model="Form.confirmPwd"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="12">
                  <el-form-item label="入司时间：" prop="joinDate" :rules="$rules.NotEmpty">
                    <el-date-picker
                      v-model="Form.joinDate"
                      type="date"
                      value-format="timestamp"
                      placeholder="选择日期">
                    </el-date-picker>
                  </el-form-item>
                </el-col>

              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="电话：" prop="phone" :rules="$rules.TelRule">
                    <el-input v-model="Form.phone"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="邮箱：" prop="emailAddress" :rules="$rules.EmailRule">
                    <el-input v-model="Form.emailAddress"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="所属机构名称：" prop="orgId" :rules="$rules.NotEmpty">
                    <el-select v-model="Form.orgId">
                      <el-option
                        v-for="item in organizationsOptions"
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
                  <el-form-item label="用户角色：" prop="roles" :rules="$rules.NotEmpty">
                    <el-select v-model="Form.roles" multiple filterable :multiple-limit="1">
                      <el-option
                        v-for="item in rolesOptions"
                        :key="item.roleId"
                        :label="item.roleName"
                        :value="item.roleId">
                      </el-option>
                    </el-select>
                    <!-- 2019年7月27日 当前只支持用户选择某一个角色 -->
                    <span style="color: red">&nbsp;每个用户只允许选择一个角色</span>
                  </el-form-item>
                </el-col>
              </el-row>

              <!--用户角色包含签单专员时，需要额外必填一个渠道专员-->
              <el-row v-if="Form.roles.indexOf('R0201') > -1">
                <el-col :span="24">
                  <el-form-item label="对应渠道：" prop="roles">
                    <el-select v-model="Form.businessUsers" multiple filterable>
                      <el-option
                        v-for="item in allBusinessUsers"
                        :key="item.userId"
                        :label="item.userName"
                        :value="item.userId">
                      </el-option>
                    </el-select>
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

      <!-- 查看 -->
      <Dialog :title="''"
              :show.sync="seeVisible"
              @closedDialog="initFormData"
      >
        <div>
          <div class="content">
            <el-form ref="seeForm" :model="Form" size="mini" label-width="120px">
              <el-row>
                <el-col :span="12">
                  <el-form-item label="用户姓名：" prop="userName">
                    <el-input v-model="Form.userName" disabled></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="登陆账户：" prop="loginAccount">
                    <el-input v-model="Form.loginAccount" disabled></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="12">
                  <el-form-item label="性别：" prop="userSex">
                    <el-select v-model="Form.userSex" placeholder="请选择" disabled>
                      <el-option label="男" value="MALE"></el-option>
                      <el-option label="女" value="FEMALE"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="籍贯：" prop="birthplace">
                    <el-cascader
                      style="width: 210px"
                      :options="AreaOptions"
                      change-on-select
                      v-model="birthplaceArea"
                      @change="handleChange"
                      disabled
                    >
                    </el-cascader>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="出生日期：">
                    {{dateFormat(Form.birthDay)}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="入司时间：">
                    {{dateFormat(Form.joinDate)}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="电话：" prop="phone">
                    <el-input v-model="Form.phone" disabled></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="邮箱：" prop="emailAddress">
                    <el-input v-model="Form.emailAddress" disabled></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="所属机构名称：" prop="orgId">
                    <el-select v-model="Form.orgId" disabled>
                      <el-option
                        v-for="item in organizationsOptions"
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
                  <el-form-item label="人物角色：" prop="roles">
                    <el-select v-model="Form.roles" multiple filterable disabled>
                      <el-option
                        v-for="item in rolesOptions"
                        :key="item.roleId"
                        :label="item.roleName"
                        :value="item.roleId">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>

            </el-form>
          </div>
          <hr style="border: 0.5px solid #D7D7D7">
          <div class="dialog-footer">
            <el-button @click="seeVisible = false" size="mini">返回</el-button>
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
    name: "Users",
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
        AreaOptions: [],
        organizationsOptions: [],
        rolesOptions: [],
        Form: {
          userId: "",
          userName: "",
          loginAccount: "",
          userSex: "",
          birthDay: "",
          userPw: "",
          confirmPwd: '',
          birthplace: "",
          orgId: "",
          status: "",
          createUserId: "",
          joinDate: "",
          phone: "",
          emailAddress: "",
          createTime: "",
          modifyTime: "",
          createUserName: "",
          orgName: "",
          roles: [],
          userRoles: [],
          businessUsers: [],
        },
        allBusinessUsers: [],
        //查看
        seeVisible: false,
        //修改
        modifyVisible: false
      }
    },
    mounted() {
      let vm = this;
      vm.AreaOptions = vm.$util.AreaFn.getAreaList();
      vm.$api.orgList({
        pageNum: 1,
        pageSize: 99999
      }).then(res => {
        vm.organizationsOptions = res.data;
      });
      vm.$api.roleList({}).then(res => {
        vm.rolesOptions = res.data;
      });
      vm.getData();
    },
    computed: {
      birthplaceArea() {
        let vm = this;
        return vm.$util.AreaFn.getArea(vm.Form.birthplace);
      }
    },
    components: {
      Table, Dialog, Pagination
    },
    methods: {
      initFormData() {
        let vm = this;
        vm.Form = vm.userForm();
        vm.$refs.addForm.resetFields();
      },
      userForm() {
        return {
          userId: "",
          userName: "",
          userSex: "",
          birthDay: "",
          userPw: "",
          confirmPwd: '',
          birthplace: "",
          orgId: "",
          status: "",
          createUserId: "",
          joinDate: "",
          phone: "",
          emailAddress: "",
          createTime: "",
          modifyTime: "",
          createUserName: "",
          orgName: "",
          roles: [],
          userRoles: [],
          businessUsers: [],
        }
      },
      //获取数据
      getData(currentPage = '1') {
        let vm = this;
        vm.pageInfo.pageIndex = currentPage;
        vm.$api.getUserList({
          userName: vm.searchKey.input,
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
      //新增 -- 保存
      save(formName) {
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          if (!vm.Form.userId) { //新增
            if (!vm.Form.userPw) {
              vm.$message.error('请设置密码');
              return;
            } else if (vm.Form.userPw !== vm.Form.confirmPwd) {
              vm.$message.error('密码输入不一致');
              return;
            }
          } else { //修改
            if (vm.Form.userPw && (vm.Form.userPw !== vm.Form.confirmPwd)) {
              vm.$message.error('密码输入不一致');
              return;
            }
          }
          vm.$api.addOrUpdateSingleUserInfo(vm.Form).then(res => {
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
      see(userId) {
        let vm = this;
        vm.$api.getSingleUserInfo({userId}).then(res => {
          vm.Form = res.data;
          vm.seeVisible = true;
        })
      },
      modify(userId) {
        let vm = this;
        // 找到所有的渠道专员
        vm.$api.getSingleUserInfo({userId}).then(res => {
          vm.Form = res.data;
          vm.$api.listRoleUser({roleDict: 'R0501'}).then(res2 => {
            vm.allBusinessUsers = res2.data.map(user => {
              return {userId: user.userId, userName: user.userName};
            });
          });
          vm.addVisible = true;
        })
      },
      updateStatus(userId, userStatus) {
        let vm = this;
        vm.$confirm('此操作将删除该用户, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          userStatus = userStatus === 'VALID' ? 'INVALID' : 'VALID';
          vm.$api.updateUserStatus({userId, userStatus}).then(res => {
            vm.$message.success(res.msg);
            vm.getData(this.pageInfo.pageIndex);
          });
        }).catch(() => {

        });
      },
      handleChange(value) {
        let vm = this;
        vm.Form.birthplace = vm.$util.AreaFn.selectArea(value);
      }

    }
  }
</script>

<style lang='scss' scoped>
  .Users {
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
