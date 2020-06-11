<template xmlns="http://www.w3.org/1999/html">
  <div class='CaseView' v-if="overViewData">
    <el-tabs v-model="seeActiveName" type="card">
      <el-tab-pane label="案子信息" name="caseDetail">
        <OverView :overViewData="overViewData" :caseSubType="caseSubType"></OverView>
      </el-tab-pane>
      <el-tab-pane label="流程信息" name="process">
        <CaseFlow :caseFlowList="caseFlow.caseFlowList" :nextOperator="caseFlow.nextOperator"></CaseFlow>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
  import OverView from './components/OverView';
  import CaseFlow from './components/CaseFlow';

  export default {
    name: "CaseView",
    components: {
      OverView, CaseFlow
    },
    props: {
      caseId: {
        type: String,
        required: true,
      },
      caseSubType: {
        type: String,
        required: true,
      },
      _t: {
        type: Date,
        required: true,
        // default:new Date(123123123),
      }
    },
    data() {
      return {
        seeActiveName: 'caseDetail',
        currentData: {
          _t: new Date(),
        },
        overViewData: null,
        caseFlow: {
          caseFlowList: [],
          nextOperator: {},
        }
      }
    },
    created() {
      let vm = this;
      vm.refreshData(vm.caseId);
    },
    methods: {
      refreshData(caseId) {
        let vm = this;
        vm.overViewData = null;
        if (caseId) {
          vm.$api.getCaseOverviewInfo({caseId}).then(res => {
            vm.overViewData = res.data;
          });
          vm.$api.getCaseFlowList({caseId}).then(res => {
            vm.caseFlow.caseFlowList = res.data.logs;
            vm.caseFlow.nextOperator = res.data.nextOperator;
          });
        }
      }
    },
    watch: {
      _t() {
        let vm = this;
        if (vm._t.getTime() !== vm.currentData._t.getTime()) {
          vm.refreshData(vm.caseId);
        }
        vm.currentData._t = vm._t;
      }
    }
  }
</script>

<style lang='scss' scoped>
  .CaseView {
    .el-tabs {
      /deep/ .el-tabs__header {
        margin: 0 0 5px;

        /deep/ .el-tabs__item {
          height: 30px;
          line-height: 30px;
        }
      }
    }
  }
</style>
