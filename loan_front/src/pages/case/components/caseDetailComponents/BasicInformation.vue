<template>
  <div class='BasicInformation'>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="buttons">
      <el-button size="mini" @click="getData">重置</el-button>
      <el-button size="mini" @click="save('form')">保存</el-button>
      <el-button size="mini" @click="next('form')">下一步</el-button>
    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="form">
      <el-form ref="form" :model="form" size="mini" label-width="140px">
        <el-row>
          <el-col :span="24">
            <el-form-item label="案子类型：" prop="caseType" :rules="$rules.NotEmpty">
              <el-cascader
                v-model="caseSelect"
                clearable
                placeholder="选择案子"
                :options="$store.state.caseOptions"
                :props="{value: 'code',label: 'desc',children: 'children'}"
              ></el-cascader>
            </el-form-item>
          </el-col>
        </el-row>
        <div v-if="form.caseSubType==='NEW_HOUSE'">
          <el-row>
            <el-col :span="24">
              <el-form-item label="房产属性：" prop="houseProperty" :rules="$rules.NotEmpty">
                <el-select v-model="form.houseProperty" clearable>
                  <el-option v-for="item in $store.state.houseOptions" :value="item.code" :label="item.desc"
                             :key="item.code"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="贷款类型：" prop="loanType" :rules="$rules.NotEmpty">
                <el-cascader
                  v-model="LoanTypeSelect"
                  clearable
                  placeholder="选择贷款类型"
                  :options="$store.state.loanTypeOptions"
                  :props="{value: 'code',label: 'desc',children: 'children'}"
                  filterable
                ></el-cascader>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="买方婚姻：" prop="maritalStatus" :rules="$rules.NotEmpty">
                <el-select v-model="form.maritalStatus" clearable>
                  <el-option v-for="item in $store.state.maritalStatusOptions" :value="item.code" :label="item.desc"
                             :key="item.code"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="放款条件：" prop="loanTerms" :rules="$rules.NotEmpty">
                <el-select v-model="form.loanTerms" clearable>
                  <el-option v-for="item in $store.state.loanTermOptions" :value="item.code" :label="item.desc"
                             :key="item.code"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
        </div>
        <div v-if="form.caseSubType==='SECOND_HAND_HOUSE'">
          <el-row>
            <el-col :span="24">
              <el-form-item label="房产属性：" prop="houseProperty" :rules="$rules.NotEmpty">
                <el-cascader
                  v-model="houseSelect"
                  clearable
                  placeholder="请选择"
                  :options="houseSelectOptions"
                  :props="{value: 'code',label: 'desc',children: 'children'}"
                ></el-cascader>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="监管类型：" prop="superviseType" :rules="$rules.NotEmpty">
                <el-select v-model="form.superviseType" clearable>
                  <el-option v-for="item in $store.state.superviseTypeOptions" :value="item.code" :label="item.desc"
                             :key="item.code"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="贷款类型：" prop="loanType" :rules="$rules.NotEmpty">
                <el-cascader
                  clearable
                  v-model="LoanTypeSelect"
                  placeholder="选择贷款类型"
                  :options="$store.state.loanTypeOptions"
                  :props="{value: 'code',label: 'desc',children: 'children'}"
                  filterable
                ></el-cascader>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="来源渠道：" prop="channelType" :rules="$rules.NotEmpty">
                <el-select v-model="form.channelType" clearable>
                  <el-option v-for="item in $store.state.channelTypeOptions" :value="item.code" :label="item.desc"
                             :key="item.code"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="买方婚姻：" prop="maritalStatus" :rules="$rules.NotEmpty">
                <el-select v-model="form.maritalStatus" clearable>
                  <el-option v-for="item in $store.state.maritalStatusOptions" :value="item.code" :label="item.desc"
                             :key="item.code"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
        </div>
        <el-row>
          <el-col :span="24">
            <el-form-item label="来源渠道：" prop="businessUser">
              <el-select v-model="form.businessUser.userId" clearable>
                <el-option v-for="item in businessUsersOptions" :value="item.userId" :label="item.userName"
                           :key="item.userId"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
    </div>
  </div>
</template>

<script>

  export default {
    name: "BasicInformation",
    data() {
      return {
        caseSelect: [],
        houseSelect: [],
        LoanTypeSelect: [],
        houseSelectOptions: [],
        businessUsersOptions: [],
        form: this.formDemo()
      }
    },
    mounted() {
      let vm = this;
      vm.getData();
      vm.buildHouseSelectOptions();
    },
    methods: {
      buildHouseSelectOptions() {
        let vm = this;
        vm.$store.state.houseOptions.map(houseOpt => {
          // 深拷贝，避免影响$store中数据
          let myOpt = JSON.parse(JSON.stringify(houseOpt));
          myOpt.children = JSON.parse(JSON.stringify(vm.$store.state.propertyRightsTypeOptions));
          vm.houseSelectOptions.push(myOpt);
        });
      },
      getData() {
        let vm = this;
        vm.$refs.form.resetFields();
        if (this.$route.params.caseId !== '0') {  //0是新建 不调接口
          vm.$api.getCaseBaseInfo({caseId: this.$route.params.caseId}).then(res => {
            vm.form = {...vm.form, ...res.data};
            vm.caseSelect = [vm.form.caseType, vm.form.caseSubType];
            vm.LoanTypeSelect = [vm.form.loanType, vm.form.loanSubType];
            if ('SECOND_HAND_HOUSE' === vm.form.caseSubType) {
              // 二手房时，需要组织房产属性二级联动
              vm.houseSelect = [vm.form.houseProperty, vm.form.propertyRightsType];
            }
            if (!vm.form.businessUser) vm.form.businessUser = {userId: ''};
          });
        }
        // 调用渠道接口
        vm.$api.getBusinessUser().then(res => {
          vm.businessUsersOptions = res.data.map(user => {
            return {userId: user.userId, userName: user.userName};
          })
        });
      },
      formDemo() {
        return {
          caseType: '',
          caseSubType: '',
          houseProperty: '',
          loanType: '',
          loanSubType: '',
          maritalStatus: '',
          loanTerms: '',
          propertyRightsType: '',
          superviseType: '',
          channelType: '',
          businessUser: {},
        }
      },
      save(formName) {
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          vm.$api.saveCaseBaseInfo(this.form).then(res => {
            vm.$router.push(
              {
                path: `/case/caseDetail/basicInformation/${res.data.caseId}`,
                query: {
                  caseSubType: res.data.caseSubType    //判断是一手房还是二手房
                }
              }
            );
            vm.$message.success(res.msg);
            vm.getData();
          })
        }
      },
      next(formName) {
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          vm.$api.saveCaseBaseInfo(this.form).then(res => {
            vm.$router.push({
              path: `/case/caseDetail/loanInformation/${res.data.caseId}`,
              query: {
                caseSubType: res.data.caseSubType    //判断是一手房还是二手房
              }
            });
            vm.$message.success(res.msg);
          })
        }
      },
    },
    watch: {
      caseSelect(newVal, oldVal) {
        let vm = this;
        vm.form.caseType = newVal[0];
        vm.form.caseSubType = newVal[1];
        if ('SECOND_HAND_HOUSE' === vm.form.caseSubType) {
          // 从一手房切换到二手房时，默认为"两证"
          if (!vm.form.propertyRightsType) vm.form.propertyRightsType = 'HOUSE_CERTIFY';
          vm.houseSelect = [vm.form.houseProperty, vm.form.propertyRightsType];
        }
      },
      LoanTypeSelect(newVal, oldVal) {
        let vm = this;
        vm.form.loanType = newVal[0];
        vm.form.loanSubType = newVal[1];
      },
      houseSelect(newVal, oldVal) {
        let vm = this;
        vm.form.houseProperty = newVal[0];
        vm.form.propertyRightsType = newVal[1];
      }
    },
  }
</script>

<style lang='scss' scoped>
  .BasicInformation {
    .buttons {
      margin: 10px 20px;
    }

    .form {
      margin-top: 10px;
    }
  }
</style>
