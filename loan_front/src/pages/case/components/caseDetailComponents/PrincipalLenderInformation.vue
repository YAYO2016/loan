<template>
  <div class='PrincipalLenderInformation'>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="buttons">
      <el-button size="mini" @click="getData">重置</el-button>
      <el-button size="mini" @click="save('form')">保存</el-button>
      <el-button size="mini" @click="next('form')">下一步</el-button>
    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="form">
      <el-form ref="form" :model="form" size="mini" label-width="130px">
        <el-tabs type="card" editable @edit="handleTabsEdit" v-model="editableTabsValue">
          <el-tab-pane label="主贷人" name="主贷人">
            <el-row>
              <el-col :span="8">
                <el-form-item label="主贷姓名：" prop="custName" :rules="$rules.NotEmpty">
                  <el-input v-model="form.custName"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="证件类型：" prop="idType" :rules="$rules.NotEmpty">
                    <el-select v-model="form.idType" clearable>
                      <el-option v-for="item in $store.state.idTypeOptions" :value="item.code" :label="item.desc"
                                 :key="item.code"></el-option>
                    </el-select>
                  </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="证件号码：" prop="idNo" :rules="$rules.NotEmpty">
                  <el-input v-model="form.idNo"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="移动电话：" prop="mobilePhone" :rules="$rules.NotEmpty">
                  <el-input v-model="form.mobilePhone"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="家庭电话：" prop="landPhone" :rules="$rules.NotEmpty">
                  <el-input v-model="form.landPhone"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="单位电话：" prop="coPhone" :rules="$rules.NotEmpty">
                  <el-input v-model="form.coPhone"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="单位性质：" prop="coType" :rules="$rules.NotEmpty">
                  <el-select v-model="form.coType" clearable>
                    <el-option v-for="item in $store.state.coTypeOptions" :value="item.code" :label="item.desc"
                               :key="item.code"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="职业性质：" prop="occuType" :rules="$rules.NotEmpty">
                  <el-select v-model="form.occuType" clearable>
                    <el-option v-for="item in $store.state.occuTypeOptions" :value="item.code" :label="item.desc"
                               :key="item.code"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收入金额：" prop="amountValue" :rules="$rules.NotEmpty">
                  <el-input v-model="form.amountValue"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :sapn="24">
                <el-form-item label="工作单位：" prop="coName" :rules="$rules.NotEmpty">
                  <el-input v-model="form.coName"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>

          <!--   ---------------------------------------------------------------------------------       -->

          <el-tab-pane v-for="(item,index) in form.otherCusts" :name="index+1+''" :label="'共还人'+(index+1)"
                       :key="index+1+''">
            <el-row>
              <el-col :span="8">
                <el-form-item label="与主贷人关系：" :prop="'otherCusts.'+index+'.custRel'" :rules="$rules.NotEmpty">
                  <el-select v-model="item.custRel" clearable>
                    <el-option v-for="item in $store.state.custRelOptions" :value="item.code" :label="item.desc"
                               :key="item.code"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="共还人姓名：" :prop="'otherCusts.'+index+'.custName'" :rules="$rules.NotEmpty">
                  <el-input v-model="item.custName"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="证件类型：" :prop="'otherCusts.'+index+'.idType'" :rules="$rules.NotEmpty">
                  <el-select v-model="item.idType" clearable>
                    <el-option v-for="item in $store.state.idTypeOptions" :value="item.code" :label="item.desc"
                               :key="item.code"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="证件号码：" :prop="'otherCusts.'+index+'.idNo'" :rules="$rules.NotEmpty">
                  <el-input v-model="item.idNo"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="移动电话：" :prop="'otherCusts.'+index+'.mobilePhone'" :rules="$rules.NotEmpty">
                  <el-input v-model="item.mobilePhone"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="单位电话：" :prop="'otherCusts.'+index+'.coPhone'" :rules="$rules.NotEmpty">
                  <el-input v-model="item.coPhone"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="单位性质：" :prop="'otherCusts.'+index+'.coType'" :rules="$rules.NotEmpty">
                  <el-select v-model="item.coType" clearable>
                    <el-option v-for="item in $store.state.coTypeOptions" :value="item.code" :label="item.desc"
                               :key="item.code"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="职业性质：" :prop="'otherCusts.'+index+'.occuType'" :rules="$rules.NotEmpty">
                  <el-select v-model="item.occuType" clearable>
                    <el-option v-for="item in $store.state.occuTypeOptions" :value="item.code" :label="item.desc"
                               :key="item.code"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收入金额：" :prop="'otherCusts.'+index+'.amountValue'" :rules="$rules.NotEmpty">
                  <el-input v-model="item.amountValue"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :sapn="24">
                <el-form-item label="工作单位：" :prop="'otherCusts.'+index+'.coName'" :rules="$rules.NotEmpty">
                  <el-input v-model="item.coName"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>
        </el-tabs>
      </el-form>
    </div>
  </div>
</template>

<script>
  export default {
    name: "PrincipalLenderInformation",
    data() {
      return {
        editableTabsValue:'主贷人',
        form: this.formDemo(),
      }
    },
    mounted(){
      let vm = this;
      //初始化数据
      vm.$refs.form.resetFields();
      vm.getData();
    },
    methods: {
      getData(){
        let vm = this;
        //初始化数据
        vm.$refs.form.resetFields();
        vm.$api.getCaseCustInfo({caseId: this.$route.params.caseId,type:'BUYER_MAIN_CREDIT'}).then(res => {
          vm.form = {...vm.form,...res.data};
        });
      },
      formDemo() {
        return {
          custId: "",
          caseId: "",
          caseCustType: "",
          custRel: '',
          custName: "",
          idType: "",
          idNo: '',
          mobilePhone: "",
          landPhone: "",
          coPhone: '',
          coType: '',
          occuType: '',
          amountValue: '',
          coName: "",
          maritalStatus: "",
          accountNo: '',
          createTime: "",
          otherCusts: []
        }
      },
      handleTabsEdit(targetName, action) {
        let vm = this;
        if (action === 'add') {
          let newTabName = (this.form.otherCusts.length + 1) + '';
          this.form.otherCusts.push({
              custId: "",
              caseId: "",
              caseCustType: "BUYER_CO_PAYER",
              custRel: "",
              custName: '',
              idType: '',
              idNo: '',
              mobilePhone: '',
              landPhone: "",
              coPhone: "",
              coType: "",
              occuType: '',
              amountValue: "",
              coName: "",
              maritalStatus: "",
              accountNo: '',
              createTime: ""
          });
          this.editableTabsValue = newTabName;
        }
        if (action === 'remove') {
          let tabs = this.form.otherCusts;
          let activeName = this.editableTabsValue;
          if (activeName == targetName) {
            tabs.forEach((tab, index) => {
              if ((index + 1) == targetName) {
                let nextTab = tabs[index + 1] || tabs[index - 1];
                if (nextTab) {
                  activeName = this.form.otherCusts.indexOf(nextTab) + 1;
                }
              }
            })
          }
          this.form.otherCusts = tabs.filter((tab, index) => (index + 1) != targetName);
          if (activeName > this.form.otherCusts.length) {
            activeName = this.form.otherCusts.length;
          }
          this.editableTabsValue = String(activeName)==0?'主贷人':String(activeName);
        }
      },
      save(formName) {
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          this.$api.saveCaseCustInfo(this.form).then(res => {
            this.$router.push(
              {
                path: `/case/caseDetail/principalLenderInformation/${this.$route.params.caseId}`,
                query: {
                  caseSubType: vm.$route.query.caseSubType
                }
              }
            );
            vm.getData();
            this.$message.success(res.msg);
          })
        }

      },
      next(formName) {
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          this.$api.saveCaseCustInfo(this.form).then(res => {
            this.$router.push({
              path: this.$route.query.caseSubType === 'NEW_HOUSE'
                ? `/case/caseDetail/developerInformation/${this.$route.params.caseId}`
                : `/case/caseDetail/sellerInformation/${this.$route.params.caseId}`
              ,
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
  .PrincipalLenderInformation {
    .buttons {
      margin: 10px 20px;
    }

    .form {
      margin: 10px;

      /deep/ .el-select {
        display: flex;
      }
    }
  }
</style>
