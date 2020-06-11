<template>
  <div class='CaseFlow'>
    <el-timeline v-if="caseFlowList.length && caseFlowList.length>0">
      <el-timeline-item :timestamp="getLatestTime()"
                        placement="top"
                        size="large"
                        type='info'
                        v-if="nextOperator">
        <div class="log-item">
          <div class="log-title">下一步操作人：</div>
          {{getUserName(nextOperator)}}&nbsp;({{getRoles(nextOperator)}})
        </div>
      </el-timeline-item>

      <el-timeline-item v-for="(caseFlow , index) in caseFlowList"
                        :key="index"
                        :type="ifOperateResultPass(caseFlow.operateResult)?'success':'danger'"
                        :timestamp="$util.DateFn.formatTime(caseFlow.operateTime,'{y}/{m}/{d} {h}:{i}:{s}')"
                        placement="top">
        <div class="log-item">
          <div class="log-title">操作类型：</div>
          {{operateTypeDescMap[caseFlow.operateType]}}&nbsp;&nbsp;&nbsp;
          <span v-if="needCheckOperateType.includes(caseFlow.operateType)"
                :style="{color:ifOperateResultPass(caseFlow.operateResult)?'#67C23A':'#F56C6C'}">{{ifOperateResultPass(caseFlow.operateResult)?'通过':'不通过'}}</span>
        </div>
        <div class="log-item">
          <div class="log-title">操作人：</div>
          {{getUserName(caseFlow.operatorInfo)}}&nbsp;({{getRoles(caseFlow.operatorInfo)}})
        </div>
        <div class="log-item">
          <div class="log-title">备注：</div>
          <div style="display:inline-flex"
               v-if="caseFlow.operateRemark"
               v-html="caseFlow.operateRemark.replace(/\n/g, '<br>').replace(/ /g,'&nbsp;')"></div>
        </div>
      </el-timeline-item>
    </el-timeline>
    <div v-else>暂无流程信息，请先提交案子</div>
  </div>
</template>

<script>
  export default {
    name: "CaseFlow",
    components: {},
    props: {
      caseFlowList: {
        type: Array,
        required: true,
      },
      nextOperator: {
        type: Object,
        // required: true,
      }
    },
    data() {
      return {
        operateTypeDescMap: {
          CREATE: '新增案件',
          SUBMIT: '案件提交',
          FENGKONG_CHECK: '风控审核',
          CAIWU_CHECK: '财务审核',
          FENGKONG_REFORM: '风控整改',
          CAIWU_REFORM: '财务整改',
          FIELD_RECEVING: '外勤收件',
          FIELD_RECEIVED: '外勤送件',
          INTERVIEW_APPOINTMENT: '预约面签',
          BANK_INTERVIEW: '银行面签',
          BANK_CHECK_COMMERCIAL: '贷款审批(商业)',
          CHECK_COMMERCIAL_PASS: '审批通过(商业)',
          BANK_CHECK_RESERVE: '贷款审批(公积金)',
          CHECK_RESERVE_PASS: '审批通过(公积金)',
          BANK_REFORM: '贷款审批整改',
          PICK_UP_CASE: '批复取件',
          TRANSFER_APPOINTMENT: '预约过户',
          TRANSFER_MORTGAGE: '过户抵押',
          MORTGAGE_RECEVING: '抵押出件',
          SEND_OFF_LOANS: '送行放款',
          MAKE_LOAN: '贷款发放',
          CAIWU_REVIEW: '财务复核',
          CUSTOMER_RECEVING: '客户取件',
          ARCHIVE_CASE: '归档',
        },
        needCheckOperateType: [
          'FENGKONG_CHECK',
          'CAIWU_CHECK',
          'CHECK_COMMERCIAL_PASS',
          'CHECK_RESERVE_PASS',
        ]
      }
    },
    computed: {},
    mounted() {
    },
    methods: {
      getLatestTime() {
        let vm = this;
        let time = new Date().getDate;
        if (vm.caseFlowList) {
          time = vm.caseFlowList[0].operateTime;
        }
        return vm.$util.DateFn.formatTime(time, '{y}/{m}/{d} {h}:{i}:{s}');
      },

      getUserName(operatorInfo) {
        return operatorInfo.userName;
      },

      getRoles(operatorInfo) {
        let result = '';
        if (operatorInfo.userRoles) {
          operatorInfo.userRoles.map(role => {
            result += role.roleName + '、';
          });
        }
        if (result.length > 0)
          return result.substring(0, result.length - 1);
        return result;
      },

      ifOperateResultPass(operateResult) {
        return operateResult === 'PASS';
      }
    }
  }
</script>

<style lang='scss' scoped>
  .CaseFlow {
    margin: 20px;

    .log-item {
      clear: both;
      margin-bottom: 3px;

      .log-title {
        width: 100px;
        text-align: right;
        float: left;
        margin-right: 8px;
      }
    }
  }
</style>
