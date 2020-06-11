<template>
  <div class='AddCase'>
    <!-- 进度步骤条-->
    <el-steps :active="computedStepData.map(item=>item.name).indexOf($route.path.split('/')[3])+1" simple>
      <el-step class="step" v-for="item in computedStepData" :title="item.title" :name="item.name" :key="item.name" @click.native="goStep(item.name)"></el-step>
    </el-steps>
    <!-- 面包屑-->
    <BreadCrumb></BreadCrumb>

    <div>
      <router-view></router-view>
    </div>




  </div>
</template>

<script>
  import BreadCrumb from '../../../components/breadcrumb/BreadCrumb';
  import BasicInformation from './caseDetailComponents/BasicInformation';

  export default {
    name: "CaseDetail",
    components: {BreadCrumb,BasicInformation},
    data() {
      return {
        active:0,
        stepData:[]
      }
    },
    computed:{
      computedStepData(){
        let vm = this;
        switch (this.$route.query.caseSubType) {
          case 'SECOND_HAND_HOUSE': //二手房
            return vm.stepData = [
              {title: '基本信息', name: 'basicInformation'},
              {title: '贷款信息', name: 'loanInformation'},
              {title: '抵押物信息', name: 'collateralInformation'},
              {title: '贷款人信息', name: 'principalLenderInformation'},
              {title: '出售方信息', name: 'sellerInformation'},
              {title: '渠道方信息', name: 'channelInformation'},
              {title: '所缺材料信息', name: 'materialInformation'},
              {title: '费用结算', name: 'feelInformation'},
            ];
          case 'NEW_HOUSE': //一手房
            return vm.stepData = [
              {title: '基本信息', name: 'basicInformation'},
              {title: '贷款信息', name: 'loanInformation'},
              {title: '抵押物信息', name: 'collateralInformation'},
              {title: '贷款人信息', name: 'principalLenderInformation'},
              {title: '开发商信息', name: 'developerInformation'},
              {title: '所缺材料信息', name: 'materialInformation'},
              {title: '费用结算', name: 'feelInformation'},
            ];
          default:
            return  vm.stepData = [{title: '基本信息', name: 'basicInformation'},];
        }
      },
    },
    mounted(){

    },
    methods:{
      goStep(stepName){
        let vm = this;
        this.$router.push(
          {
            path: `/case/caseDetail/${stepName}/${this.$route.params.caseId}`,
            query: {
              caseSubType: vm.$route.query.caseSubType  //判断是一手房还是二手房
            }
          }
        );
      }
    },
    watch:{

    }
  }
</script>

<style lang='scss' scoped>
  .AddCase {
    /deep/ .el-step__head{
      display: none;
    }
    /deep/ .el-steps{
      padding: 10px 20px;
    }
    /deep/ .el-step__title{
      font-size: 12px;
    }
    /deep/ .is-process{
      color: #C0C4CC;
    }
    .step{
      cursor: pointer;
    }
  }
</style>
