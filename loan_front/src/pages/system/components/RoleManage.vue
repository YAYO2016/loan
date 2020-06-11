<template>
  <div class='RoleManage'>
    <div class="title">
      角色管理
    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="content">
      <Table :tableData="tableData" style="width:100%">
        <el-table-column
          property="roleId"
          label="角色编码"
          width="">
        </el-table-column>
        <el-table-column
          property="roleName"
          label="角色姓名"
          width="">
        </el-table-column>
        <el-table-column
          property="roleDesc"
          label="角色描述"
          width="">
        </el-table-column>
        <el-table-column
          property="operator"
          label="操作"
          width="200">
          <template slot-scope="scope">
            <el-button @click="openModifyRoleInfoDialog(scope.row.roleId)" type="text" size="small">修改</el-button>
            <el-button @click="openModifyRolePrivilegesDialog(scope.row.roleId)" type="text" size="small">权限管理
            </el-button>
          </template>
        </el-table-column>
      </Table>
    </div>

    <div class="dialog">
      <Dialog :title="'编辑角色信息'"
              :show.sync="roleInfo.dialogVisible">
        <div>
          <div class="content">
            <el-form ref="roleForm" :model="roleInfo.form" size="mini" label-width="120px">
              <el-row>
                <el-col :span="12">
                  <el-form-item label="角色编码：" prop="roleId">
                    <el-input v-model="roleInfo.form.roleId" disabled></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="角色名称：" prop="roleName" :rules="$rules.NotEmpty">
                    <el-input v-model="roleInfo.form.roleName"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="角色描述：" prop="roleDesc">
                    <el-input type="textarea" v-model="roleInfo.form.roleDesc"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </div>
          <hr style="border: 0.5px solid #D7D7D7">
          <div class="dialog-footer">
            <el-button @click="saveRoleInfo()" size="mini">保存</el-button>
            <el-button @click="roleInfo.dialogVisible = false" size="mini">返回</el-button>
          </div>
        </div>
      </Dialog>

      <Dialog :title="'编辑角色权限'"
              :show.sync="rolePrivilegesInfo.dialogVisible">
        <div>
          <div class="content">
            <el-tree
              ref="roleTree"
              :data="rolePrivilegesInfo.treeData"
              show-checkbox
              :props="rolePrivilegesInfo.props"
              node-key="code"
            >
            </el-tree>
          </div>
          <hr style="border: 0.5px solid #D7D7D7">
          <div class="dialog-footer">
            <el-button @click="savePrivilegesInfo()" size="mini">保存</el-button>
            <el-button @click="rolePrivilegesInfo.dialogVisible = false" size="mini">返回</el-button>
          </div>
        </div>
      </Dialog>
    </div>
  </div>
</template>

<script>
  import Table from '../../../components/table/Table';
  import Dialog from '../../../components/dialog/Dialog';

  export default {
    name: "RoleManage",
    data() {
      return {
        tableData: [],
        roleInfo: {
          form: {roleId: '', roleName: '', roleDesc: ''},
          dialogVisible: false
        },

        rolePrivilegesInfo: {
          treeData: [],
          privilegesInfo: {},
          props: {
            children: 'children',
            label: 'name'
          },
          dialogVisible: false
        }
      }
    },
    mounted() {
      let vm = this;
      vm.getAllRoles();
      vm.initPrivileges();
    },
    components: {Table, Dialog},
    methods: {
      initPrivileges() {
        let vm = this;
        vm.$api.getAllPrivileges().then(res => {
          if (200 === parseInt(res.status)) {
            vm.rolePrivilegesInfo.treeData = res.data;
          }
        });
      },

      getAllRoles() {
        let vm = this;
        vm.$api.roleList({}).then(res => {
          if (200 === parseInt(res.status)) {
            vm.tableData = res.data;
          }
        });
      },

      // 保存角色信息
      saveRoleInfo() {
        let vm = this;
        if (vm.validateRules('roleForm', vm)) {
          vm.$api.updateRoleInfo(vm.roleInfo.form).then(res => {
            vm.$message.success(res.msg);
            vm.roleInfo.dialogVisible = false;
            vm.getAllRoles();
          })
        }
      },

      openModifyRoleInfoDialog(roleId) {
        let vm = this;
        vm.$api.getRoleInfo({roleId}).then(res => {
          if (200 === parseInt(res.status)) {
            vm.roleInfo.form = res.data;
            vm.roleInfo.dialogVisible = true;
          }
        });
      },

      openModifyRolePrivilegesDialog(roleId) {
        let vm = this;
        vm.$api.getRolePrivileges({roleId}).then(res => {
          if (200 === parseInt(res.status)) {
            // 设置选中的角色权限
            vm.rolePrivilegesInfo.privilegesInfo = res.data;
            vm.rolePrivilegesInfo.dialogVisible = true;
            vm.$nextTick(() => {
              vm.$refs.roleTree.setCheckedKeys(res.data.checkedPrivileges);
            });
          }
        });
      },

      // 保存角色权限信息
      savePrivilegesInfo() {
        let vm = this;
        vm.rolePrivilegesInfo.privilegesInfo.checkedPrivileges = vm.$refs.roleTree.getCheckedNodes().filter(node => {
          return node.children.length <= 0 // 只保存子节点
        }).map(node => {
          return node.code
        });
        vm.$api.updateRolePrivileges(vm.rolePrivilegesInfo.privilegesInfo).then(res => {
          vm.$message.success(res.msg);
          vm.rolePrivilegesInfo.dialogVisible = false;
          vm.getAllRoles();
        })
      }

    }
  }
</script>

<style lang='scss' scoped>
  .RoleManage {
    .title {
      height: 60px;
      line-height: 60px;
      margin-left: 20px;
      font-size: 17px;
    }

    .content {
      padding: 20px;
    }
  }
</style>
