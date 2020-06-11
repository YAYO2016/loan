<template>
  <div class='CollateralInformation'>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="buttons">
      <el-button size="mini" @click="getData">重置</el-button>
      <el-button size="mini" @click="save('form')">保存</el-button>
      <el-button size="mini" @click="next('form')">下一步</el-button>
    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="form">
      <!--一手-->
      <div v-if="$route.query.caseSubType === 'NEW_HOUSE'">
        <el-form ref="form" :model="form" size="mini" label-width="120px">
          <el-row>
            <el-col :span="7">
              <el-form-item label="契约号：" prop="contractCode" :rules="$rules.NotEmpty">
              <el-input v-model="form.contractCode"></el-input>
            </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="房产地址：" prop="houseAddress" :rules="$rules.NotEmpty">
                <el-input v-model="form.houseAddress" placeholder="具体地址"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="7">
              <el-form-item label="房产面积：" prop="houseArea" :rules="$rules.NotEmpty">
                <el-input v-model="form.houseArea" placeholder="单位：平方米"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="契约总价：" prop="contractAmount">
                {{computedContractAmount}} 元
                <!-- <el-input v-model="computedContractAmount" placeholder="单位：元" disabled></el-input>-->
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="契约单价：" prop="contractPrice" :rules="$rules.NotEmpty">
                <el-input v-model="form.contractPrice" placeholder="单位：元"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </div>
      <!--二手-->
      <div v-else-if="$route.query.caseSubType === 'SECOND_HAND_HOUSE'">
        <el-form ref="form" :model="form" size="mini" label-width="110px">
          <el-card style="margin: 10px">
            <div slot="header" class="clearfix">
              <span>交易前房产信息</span>
            </div>
            <div>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="房产地址：" prop="pretradeHouseAddr" :rules="$rules.NotEmpty">
                    <el-input v-model="form.pretradeHouseAddr" placeholder='具体地址'></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="房产面积：" prop="pretradeArea" :rules="$rules.NotEmpty">
                    <el-input v-model="form.pretradeArea" placeholder='单位：平方米'></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="建筑楼层：" prop="pretradeFloor" :rules="$rules.NotEmpty">
                    <el-input v-model="form.pretradeFloor" placeholder='3/6'></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="建筑年代：" prop="pretradeAge" :rules="$rules.NotEmpty">
                    <el-input v-model="form.pretradeAge"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="网签价格：" prop="pretradeNetPrice" :rules="$rules.NotEmpty">
                    <el-input v-model="form.pretradeNetPrice" placeholder=''></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="成交总价：" prop="pretradePrice" :rules="$rules.NotEmpty">
                    <el-input v-model="form.pretradePrice" placeholder=''></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="成交单价：" prop="pretradeUnitPrice">
                    {{computedPretradeUnitPrice}} 元
<!--                    <el-input v-model="form.pretradeUnitPrice"></el-input>-->
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row v-if="form.propertyRightsType === 'REAL_ESTATE'">
                <el-col :span="24">
                  <el-form-item label="不动产证号：" prop="pretradeBdc" :rules="$rules.NotEmpty">
                    <el-input v-model="form.pretradeBdc" placeholder=''></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row v-else>
                <el-col :span="12">
                  <el-form-item label="产权证号：" prop="pretradeCqz" :rules="$rules.NotEmpty">
                    <el-input v-model="form.pretradeCqz" placeholder=''></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="土地证号：" prop="pretradeTdz" :rules="$rules.NotEmpty">
                    <el-input v-model="form.pretradeTdz" placeholder=''></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
            </div>
          </el-card>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "CollateralInformation",
    data() {
      return {
        form: this.formDemo(),
      }
    },
    computed: {
      computedContractAmount() {
        let vm = this;
        vm.form.contractAmount = parseFloat(vm.form.houseArea) * parseFloat(vm.form.contractPrice);
        return vm.form.contractAmount = vm.changeTwoDecimal(vm.form.contractAmount);
      },
      computedPretradeUnitPrice() {
        let vm = this;
        vm.form.pretradeUnitPrice = parseFloat(vm.form.pretradePrice) / parseFloat(vm.form.pretradeArea);
        return vm.form.pretradeUnitPrice = vm.changeTwoDecimal(vm.form.pretradeUnitPrice);
      }
    },
    mounted() {
      let vm = this;
      vm.$refs.form.resetFields();
      vm.getData();
    },
    methods: {
      getData() {
        let vm = this;
        vm.$refs.form.resetFields();
        if (vm.$route.query.caseSubType === 'NEW_HOUSE') {
          vm.$api.getNewHouseCollateralInfo({caseId: this.$route.params.caseId}).then(res => {
            vm.form = {...vm.form, ...res.data};
          });
        } else if (vm.$route.query.caseSubType === 'SECOND_HAND_HOUSE') {
          vm.$api.getSecondHandHouseCollateralInfo({caseId: this.$route.params.caseId}).then(res => {
            vm.form = {...vm.form, ...res.data};
          });
        }
      },
      formDemo() {
        let vm = this;
        if (vm.$route.query.caseSubType === 'NEW_HOUSE') {
          return {
            caseId: "",
            houseProperty: "",
            contractCode: "",
            houseAddress: "",
            houseArea: "",
            contractAmount: "",
            contractPrice: ""
          }
        } else if (vm.$route.query.caseSubType === 'SECOND_HAND_HOUSE') {
          return {
            caseId: "",
            houseProperty: "",
            propertyRightsType: "",
            superviseType: "",
            pretradeHouseAddr: "",
            pretradeCqz: "",
            pretradeTdz: "",
            pretradeBdc: "",
            pretradeArea: "",
            pretradeFloor: "",
            pretradeAge: "",
            pretradeNetPrice: "",
            pretradePrice: "",
            pretradeUnitPrice: ""
          }
        }
      },
      changeTwoDecimal(x) {   //计算 四舍五入+保留两位小数
        var f_x = parseFloat(x);
        if (isNaN(f_x)) {
          // alert('function:changeTwoDecimal->parameter error');
          return 0;
        }
        f_x = Math.round(f_x * 100) / 100;
        var s_x = f_x.toString();
        var pos_decimal = s_x.indexOf('.');
        if (pos_decimal < 0) {
          pos_decimal = s_x.length;
          s_x += '.';
        }
        while (s_x.length <= pos_decimal + 2) {
          s_x += '0';
        }
        return s_x;
      },
      save(formName) {
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          if (vm.$route.query.caseSubType === 'NEW_HOUSE') {
            this.$api.saveNewHouseCollateralInfo(this.form).then(res => {
              this.$router.push(
                {
                  path: `/case/caseDetail/collateralInformation/${this.$route.params.caseId}`,
                  query: {
                    caseSubType: vm.$route.query.caseSubType  //判断是一手房还是二手房
                  }
                }
              );
              vm.getData();
              this.$message.success(res.msg);
            })
          } else if (vm.$route.query.caseSubType === 'SECOND_HAND_HOUSE') {
            this.$api.saveSecondHandHouseCollateralInfo(this.form).then(res => {
              this.$router.push(
                {
                  path: `/case/caseDetail/collateralInformation/${this.$route.params.caseId}`,
                  query: {
                    caseSubType: vm.$route.query.caseSubType    //判断是一手房还是二手房
                  }
                }
              );
              vm.getData();
              this.$message.success(res.msg);
            })
          }
        }

      },
      next(formName) {
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          if (vm.$route.query.caseSubType === 'NEW_HOUSE') {
            this.$api.saveNewHouseCollateralInfo(this.form).then(res => {
              this.$router.push(
                {
                  path: `/case/caseDetail/principalLenderInformation/${this.$route.params.caseId}`,
                  query: {
                    caseSubType: vm.$route.query.caseSubType    //判断是一手房还是二手房
                  }
                }
              );
              this.$message.success(res.msg);
            })
          } else if (vm.$route.query.caseSubType === 'SECOND_HAND_HOUSE') {
            this.$api.saveSecondHandHouseCollateralInfo(this.form).then(res => {
              this.$router.push(
                {
                  path: `/case/caseDetail/principalLenderInformation/${this.$route.params.caseId}`,
                  query: {
                    caseSubType: vm.$route.query.caseSubType   //判断是一手房还是二手房
                  }
                }
              );
              this.$message.success(res.msg);
            })
          }
        }

      }
    }
  }
</script>

<style lang='scss' scoped>
  .CollateralInformation {
    .buttons {
      margin: 10px 20px;
    }

    .form {
      margin-top: 10px;

      /deep/ .el-card__header{
        font-size: 14px;
        padding: 14px 16px;
      }

      /deep/ .el-card__body{
        padding: 10px;
      }
    }
  }
</style>
