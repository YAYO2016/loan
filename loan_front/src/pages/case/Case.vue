<template>
  <div class='Case'>
    <div class="left">
      <el-menu
        ref="menu"
        default-active="/case/workbench"
        class="el-menu-vertical-demo"
        :default-active="$route.path"
        router>
        <el-menu-item index="/case/workbench">
          <span slot="title">工作台</span>
        </el-menu-item>
        <el-menu-item index="/case/historyCase"
                      v-if="$util.StorageFn.checkPrivileges(['LFR02003'])">
          <span slot="title">历史案子</span>
        </el-menu-item>
      </el-menu>
    </div>
    <div class="right">
      <!--UI滚动效果-->
      <el-scrollbar style="height: 100%">
        <router-view/>
      </el-scrollbar>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Case",
    data() {
      return {}
    },
    updated() {
      let vm = this;
      if (vm.$route.path === '/case') {
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
  }
</script>

<style lang='scss' scoped>
  .Case {
    height: 100%;
    display: flex;
    width: 100%;
    position: absolute;
    overflow: hidden;

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

      /deep/ .el-scrollbar__wrap {
        overflow-y: scroll;
        overflow-x: hidden;
      }
    }
  }
</style>
