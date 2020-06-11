<template>
  <div class='System'>
    <div class="left">
      <el-menu
        class="el-menu-vertical-demo"
        :default-active="$route.path"
        ref="menu"
        router>
        <el-menu-item index="/system/banks"
                      v-if="$util.StorageFn.checkPrivileges(['LFR03001'])">
          <span slot="title">银行信息</span>
        </el-menu-item>
        <el-menu-item index="/system/channel"
                      v-if="$util.StorageFn.checkPrivileges(['LFR03002'])">
          <span slot="title">渠道管理</span>
        </el-menu-item>
        <el-menu-item index="/system/users"
                      v-if="$util.StorageFn.checkPrivileges(['LFR03003'])">
          <span slot="title">用户管理</span>
        </el-menu-item>
        <el-menu-item index="/system/organizations"
                      v-if="$util.StorageFn.checkPrivileges(['LFR03004'])">
          <span slot="title">组织机构</span>
        </el-menu-item>
        <el-menu-item index="/system/messageManege"
                      v-if="$util.StorageFn.checkPrivileges(['LFR03005'])">
          <span slot="title">通知管理</span>
        </el-menu-item>
        <el-menu-item index="/system/feels"
                      v-if="$util.StorageFn.checkPrivileges(['LFR03006'])">
          <span slot="title">费用科目</span>
        </el-menu-item>
        <el-menu-item index="/system/materials"
                      v-if="$util.StorageFn.checkPrivileges(['LFR03007'])">
          <span slot="title">材料管理</span>
        </el-menu-item>
        <el-menu-item index="/system/developers"
                      v-if="$util.StorageFn.checkPrivileges(['LFR03008'])">
          <span slot="title">开发商管理</span>
        </el-menu-item>
        <el-menu-item index="/system/roleManage"
                      v-if="$util.StorageFn.checkPrivileges(['LFR03009'])">
          <span slot="title">权限管理</span>
        </el-menu-item>
      </el-menu>
    </div>
    <div class="right">
      <router-view/>
    </div>
  </div>
</template>

<script>
  export default {
    name: "System",
    updated() {
      let vm = this;
      if (vm.$route.path === '/system') {
        vm.$nextTick(function () {
          vm.$router.push(vm.$refs.menu.$children[0].$props.index)
        })
      }
    },
    created() {
      let vm = this;
      //默认显示第一个菜单项
      vm.$nextTick(function () {
        vm.$router.push(vm.$refs.menu.$children[0].$props.index)
      })
    },
    data() {
      return {}
    },
  }
</script>

<style lang='scss' scoped>
  .System {
    height: 100%;
    width: 100%;
    display: flex;
    position: absolute;

    .left {
      min-width: 125px;
      /*width: 180px;*/
      /*flex: 1 1 180px;*/
      position: relative;

      /deep/ .el-menu {
        position: absolute;
        width: 100%;
        height: 100%;
      }
    }

    .right {
      flex: 1 1 auto;
    }
  }
</style>
