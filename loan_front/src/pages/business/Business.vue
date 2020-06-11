<template>
  <div class='Business'>
    <div class="left">
      <el-menu
        ref="menu"
        :default-active="$route.path"
        class="el-menu-vertical-demo"
        router>
        <el-menu-item index="/business/company"
                      v-if="$util.StorageFn.checkPrivileges(['LFR01001'])">
          <span slot="title">公司业绩总览</span>
        </el-menu-item>
        <el-menu-item index="/business/department"
                      v-if="$util.StorageFn.checkPrivileges(['LFR01002'])">
          <span slot="title">部门业绩总览</span>
        </el-menu-item>
        <el-menu-item index="/business/person"
                      v-if="$util.StorageFn.checkPrivileges(['LFR01003'])">
          <span slot="title">个人业绩总览</span>
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
    name: "Business",
    data() {
      return {}
    },
    updated() {
      let vm = this;
      if (vm.$route.path === '/business') {
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
    methods: {}
  }
</script>

<style lang='scss' scoped>
  .Business {
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
