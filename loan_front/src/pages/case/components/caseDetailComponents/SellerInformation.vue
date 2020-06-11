<template>
  <div class='SellerInformation'>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="buttons">
      <el-button size="mini" @click="getData">重置</el-button>
      <el-button size="mini" @click="save('form')">保存</el-button>
      <el-button size="mini" @click="next('form')">下一步</el-button>
    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="form">
      <el-form ref="form" :model="form" size="mini" label-width="140px">
        <el-tabs type="card" editable @edit="handleTabsEdit" v-model="editableTabsValue">
          <el-tab-pane label="卖方" name="卖方">
            <el-row>
              <el-col :span="8">
                <el-form-item label="卖方姓名：" prop="custName" :rules="$rules.NotEmpty">
                  <el-input v-model="form.custName"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="卖方证件类型：" prop="idType" :rules="$rules.NotEmpty">
                  <el-select v-model="form.idType" clearable>
                    <el-option v-for="item in $store.state.idTypeOptions" :value="item.code" :label="item.desc"
                               :key="item.code"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="卖方证件号：" prop="idNo" :rules="$rules.NotEmpty">
                  <el-input v-model="form.idNo" ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="卖方联系电话：" prop="mobilePhone" :rules="$rules.NotEmpty">
                  <el-input v-model="form.mobilePhone"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收款账号：" prop="accountNo" :rules="$rules.NotEmpty">
                  <el-input v-model="form.accountNo"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label-width="0">
                  <div style="margin-left: 10px">
                  <span style="color: red"><strong>注：</strong></span>
                  <span style="color: #3399FF">收款账号必须是卖方的，非共有人</span>
                  </div>
                </el-form-item>
              </el-col>
            </el-row>
          </el-tab-pane>
          <el-tab-pane v-for="(item,index) in form.otherCusts" :name="index+1+''" :label="'共有人'+(index+1)"
                       :key="index+1+''">
            <el-row>
              <el-col :span="8">
                <el-form-item label="与卖方关系：" :prop="'otherCusts.'+index+'.custRel'" :rules="$rules.NotEmpty">
                  <el-select v-model="item.custRel" clearable>
                    <el-option v-for="item in $store.state.custRelOptions" :value="item.code" :label="item.desc"
                               :key="item.code"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="共有人姓名：" :prop="'otherCusts.'+index+'.custName'" :rules="$rules.NotEmpty">
                  <el-input v-model="item.custName"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="共有人联系电话：" :prop="'otherCusts.'+index+'.mobilePhone'" :rules="$rules.NotEmpty">
                  <el-input v-model="item.mobilePhone"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="证件类型：" :prop="'otherCusts.'+index+'.idType'" :rules="$rules.NotEmpty">
                  <el-select v-model="item.idType" clearable>
                    <el-option v-for="item in $store.state.idTypeOptions" :value="item.code" :label="item.desc"
                               :key="item.code"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="共有人证件号：" :prop="'otherCusts.'+index+'.idNo'" :rules="$rules.NotEmpty">
                  <el-input v-model="item.idNo"></el-input>
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
    name: "SellerInformation",
    data() {
      return {
        editableTabsValue:'卖方',
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
        vm.$refs.form.resetFields();
        //初始化数据 -- 获取卖方人信息
        vm.$api.getCaseCustInfo({caseId: this.$route.params.caseId,type:'SELLER_HOUSE_OWNER'}).then(res => {
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
            caseCustType: "SELLER_CO_OWNER",
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
          this.editableTabsValue = String(activeName)==0?'卖方':String(activeName);
        }
      },
      save(formName) {
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          this.$api.saveCaseCustInfo(this.form).then(res => {
            this.$router.push(
              {
                path: `/case/caseDetail/sellerInformation/${this.$route.params.caseId}`,
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
              path: `/case/caseDetail/channelInformation/${this.$route.params.caseId}`,
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
  .SellerInformation {
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
