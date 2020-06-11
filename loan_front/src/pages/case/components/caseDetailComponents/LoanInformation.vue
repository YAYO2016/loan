<template>
  <div class='LoanInformation'>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="buttons">
      <el-button size="mini" @click="getData">重置</el-button>
      <el-button size="mini" @click="save('form')">保存</el-button>
      <el-button size="mini" @click="next('form')">下一步</el-button>
    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="form">
      <el-form ref="form" :model="form" size="mini" label-width="180px">
        <el-row v-if="form.loanType === 'RESERVE' || form.loanType === 'SYNDICATED'">
          <el-col :span="8">
            <el-form-item label="公积金贷款金额：" prop="reserveAmount" :rules="$rules.NotEmpty">
              <el-input v-model="form.reserveAmount"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="公积金贷款申请年限：" prop="reserveYear" :rules="$rules.NotEmpty">
              <el-input v-model="form.reserveYear"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row v-if="form.loanType === 'SYNDICATED'|| form.loanType === 'COMMERCIAL'">
          <el-col :span="8">
            <el-form-item label="商业贷款金额：" prop="commercialAmount" :rules="$rules.NotEmpty">
              <el-input v-model="form.commercialAmount"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="商业贷款申请年限：" prop="commercialYear" :rules="$rules.NotEmpty">
              <el-input v-model="form.commercialYear"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item label="还款方式：" prop="repaymentType" :rules="$rules.NotEmpty">
              <el-select v-model="form.repaymentType" clearable>
                <el-option v-for="item in $store.state.repaymentTypeOptions" :value="item.code" :label="item.desc"
                           :key="item.code"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="贷款银行：" prop="loanBank" :rules="$rules.NotEmpty">
              <el-select v-model="form.loanBank" clearable>
                <el-option
                  v-for="item in $store.state.banksOptions"
                  :key="item.bankId"
                  :label="item.bankName"
                  :value="item.bankId">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item label="还款账号：" prop="repaymentAccount" :rules="$rules.NotEmpty">
              <el-input v-model="form.repaymentAccount"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
    </div>
  </div>
</template>

<script>

  export default {
    name: "LoanInformation",
    data() {
      return {
        form: this.formDemo(),
      }
    },
    mounted() {
      let vm = this;
      vm.$refs.form.resetFields();
      //初始化数据
      this.getData();

    },
    methods: {
      getData(){
        let vm = this;
        vm.$refs.form.resetFields();
        vm.$api.getCaseLoanInfo({caseId: this.$route.params.caseId}).then(res => {
          vm.form = {...vm.form,...res.data};
        });
      },
      formDemo() {
        return {
          caseId: "",
          loanType: "",
          loanSubType: "",
          reserveAmount: "",
          reserveYear: "",
          commercialAmount: "",
          commercialYear: "",
          repaymentType: "",
          repaymentAccount: "",
          loanBank: "",
          loanBankBranch: ""
        }
      },
      save(formName) {
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          this.$api.saveCaseLoanInfo(this.form).then(res => {
            this.$router.push(
              {
                path: `/case/caseDetail/loanInformation/${this.$route.params.caseId}`,
                query: {
                  caseSubType:vm.$route.query.caseSubType
                }
              }
            );
            this.$message.success(res.msg);
            this.getData();
          })
        }

      },
      next(formName) {
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          this.$api.saveCaseLoanInfo(this.form).then(res => {
            this.$router.push({
              path: `/case/caseDetail/collateralInformation/${this.$route.params.caseId}`,
              query: {
                caseSubType: vm.$route.query.caseSubType
              }
            });
            this.$message.success(res.msg);
          })
        }

      }
    }
  }
</script>

<style lang='scss' scoped>
  .LoanInformation {
    .buttons {
      margin: 10px 20px;
    }

    .form {
      margin-top: 10px;

      /deep/ .el-select {
        display: flex;
      }
    }
  }
</style>
