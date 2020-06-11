<template>
  <div class='BreadCrumb'>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/case/workbench' }">工作台</el-breadcrumb-item>
      <el-breadcrumb-item v-for="(item,index) in computedBreadcrumbInfo" :key="index">{{item}}</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
</template>

<script>

  export default {
    name: "BreadCrumb",
    computed:{
      computedBreadcrumbInfo(){
        let vm = this;
        switch (this.$route.query.caseSubType) {
          case 'SECOND_HAND_HOUSE': //二手房
            return vm.breadcrumbInfo = ['住房贷款', '新增', '二手房'];
            break;
          case 'NEW_HOUSE': //二手房
            return vm.breadcrumbInfo = ['住房贷款', '新增', '一手房'];
            break;
          default:
            return vm.breadcrumbInfo = ['住房贷款', '新增'];
            break;
        }
      }
    },
    data() {
      return {
        breadcrumbInfo: []
      }
    },
  }
</script>

<style lang='scss' scoped>
  .BreadCrumb {
    margin-top: 20px;
    margin-left: 20px;
    height: 30px;
  }
</style>
