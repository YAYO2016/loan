<template>
    <div class='DeveloperInformation'>
      <hr style="border: 0.5px solid #D7D7D7">
      <div class="buttons">
        <el-button size="mini" @click="getData">重置</el-button>
        <el-button size="mini" @click="save('form')">保存</el-button>
        <el-button size="mini" @click="next('form')">下一步</el-button>
      </div>
      <hr style="border: 0.5px solid #D7D7D7">
      <div class="form">
        <el-form ref="form" :model="form" size="mini" label-width="150px">
          <el-card style="margin: 10px">
            <div slot="header" class="clearfix">
              <el-form-item label=" " prop="developerInfo.developerId" label-width="0px" style="margin-bottom: 0px;" :rules="$rules.NotEmpty">
                <el-select
                  placeholder="请选择开发商"
                  v-model="form.developerInfo.developerId"
                  @change="changeDeveloper"
                  clearable
                >
                  <el-option
                    v-for="item in developerListOptions"
                    :value="item.developerId"
                    :label="item.developerName"
                    :key="item.developerId"
                  ></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div>
              <el-row>
                <el-col :span="8">
                  <el-form-item label='开发商：' prop="developerName">
                    {{form.developerInfo.developerName}}
                  </el-form-item>
                </el-col>
                <el-col :span="16">
                  <el-form-item label='开发商地址：' prop="developerAddr">
                    {{form.developerInfo.developerAddr}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label='开发商电话：' prop="developerTel">
                    {{form.developerInfo.developerTel}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label='财务负责人：' prop="financeName">
                    {{form.developerInfo.financeName}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label='财务负责人手机：' prop="financeTel">
                    {{form.developerInfo.financeTel}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label='监管账户：' prop="accountNo">
                    {{form.developerInfo.accountNo}}
                  </el-form-item>
                </el-col>
                <el-col :span="16">
                  <el-form-item label='开户行：' prop="accountBank">
                    {{form.developerInfo.accountBank}}
                  </el-form-item>
                </el-col>
              </el-row>
            </div>
          </el-card>
          <el-card style="margin: 10px">
            <div slot="header" class="clearfix">
              <el-form-item label=" " prop="estateInfo.estateId" label-width="0px" style="margin-bottom: 0px;" :rules="$rules.NotEmpty">
                <el-select
                  placeholder="请选择楼盘"
                  v-model="form.estateInfo.estateId"
                  @change="changeEstate"
                  clearable
                >
                  <el-option
                    v-for="item in estateListOptions"
                    :value="item.estateId"
                    :label="item.estateName"
                    :key="item.estateId"
                  ></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div>
              <el-row>
                <el-col :span="8">
                  <el-form-item label='楼盘名称：' prop="estateName">
                    {{form.estateInfo.estateName}}
                  </el-form-item>
                </el-col>
                <el-col :span="16">
                  <el-form-item label='楼盘地址：' prop="estateAddr">
                    {{form.estateInfo.estateAddr}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label='楼盘电话：' prop="estateTel">
                    {{form.estateInfo.estateTel}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label='楼盘负责人：' prop="managerName">
                    {{form.estateInfo.managerName}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label='楼盘负责人手机：' prop="managerTel">
                    {{form.estateInfo.managerTel}}
                  </el-form-item>
                </el-col>
              </el-row>
            </div>
          </el-card>
          <el-card style="margin: 10px">
            <div slot="header" class="clearfix">
              <el-form-item label=" " prop="estateSalesmanInfo.salesmanId" label-width="0px" style="margin-bottom: 0px;" :rules="$rules.NotEmpty">
                <el-select
                  placeholder="请选择楼盘销售人员"
                  v-model="form.estateSalesmanInfo.salesmanId"
                  @change="changeEstateSalesman"
                  clearable
                >
                  <el-option
                    v-for="item in estateSalesmanListOptions"
                    :value="item.salesmanId"
                    :label="item.salesmanName"
                    :key="item.salesmanId"
                  ></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div>
              <el-row>
                <el-col :span="8">
                  <el-form-item label='销售员：' prop="salesmanName">
                    {{form.estateSalesmanInfo.salesmanName}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label='手机：' prop="salesmanTel">
                    {{form.estateSalesmanInfo.salesmanTel}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label='办公电话：' prop="officeTel">
                    {{form.estateSalesmanInfo.officeTel}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label='账户名：' prop="accountName">
                    {{form.estateSalesmanInfo.accountName}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label='开户行：' prop="accountBank">
                    {{form.estateSalesmanInfo.accountBank}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label='账号：' prop="accountNo">
                    {{form.estateSalesmanInfo.accountNo}}
                  </el-form-item>
                </el-col>
              </el-row>
            </div>
          </el-card>
        </el-form>
      </div>
    </div>
</template>

<script>
    export default {
        name: "DeveloperInformation",
        data() {
          return {
            developerListOptions: [],
            estateListOptions: [],
            estateSalesmanListOptions: [],
            form: this.formDemo(),
          }
        },
      async mounted() {
        let vm = this;
        vm.$refs.form.resetFields();
        await vm.$api.getCaseDeveloperCfgInfo({caseId: this.$route.params.caseId}).then(res => {
          vm.form = {...vm.form, ...res.data};
          if (vm.form.developerInfo === null) {  //初始数据
            vm.form.developerInfo = this.formDemo().developerInfo;
          }
          if (vm.form.estateInfo === null) {  //初始数据
            vm.form.estateInfo = this.formDemo().estateInfo;
          }
          if (vm.form.estateSalesmanInfo === null) {  //初始数据
            vm.form.estateSalesmanInfo = this.formDemo().estateSalesmanInfo;
          }
        });
        vm.$api.getDeveloperList().then(res => {
          vm.developerListOptions = res.data;
        });
        if (vm.form.developerInfo.developerId) {
          vm.$api.getEstateList({developerId: vm.form.developerInfo.developerId}).then(res => {
            vm.estateListOptions = res.data;
          });
        }
        if (vm.form.estateInfo.estateId) {
          vm.$api.getEstateSalesmanList({estateId: vm.form.estateInfo.estateId}).then(res => {
            vm.estateSalesmanListOptions = res.data;
          });
        }


      },
      methods: {
        getData() {
          let vm = this;
          vm.$refs.form.resetFields();
          vm.$api.getCaseDeveloperCfgInfo({caseId: this.$route.params.caseId}).then(res => {
            vm.form = {...vm.form, ...res.data};
            if (vm.form.developerInfo === null) {  //初始数据
              vm.form.developerInfo = this.formDemo().developerInfo;
            }
            if (vm.form.estateInfo === null) {  //初始数据
              vm.form.estateInfo = this.formDemo().estateInfo;
            }
            if (vm.form.estateSalesmanInfo === null) {  //初始数据
              vm.form.estateSalesmanInfo = this.formDemo().estateSalesmanInfo;
            }
          });
        },
        formDemo() {
          let vm = this;
          return {
            caseId: "",
            developerInfo: {   //开发商
              developerId: "",
              developerName: "",
              developerAddr: "",
              developerTel: "",
              financeName: "",
              financeTel: "",
              accountNo: "",
              accountBank: "",
              createUser: ""
            },
            estateInfo: {  //楼盘
              estateId: "",
              developerId: "",
              estateName: "",
              estateTel: "",
              estateAddr: "",
              managerName: "",
              managerTel: ""
            },
            estateSalesmanInfo: {  //楼盘销售人员
              salesmanId: "",
              estateId: "",
              salesmanName: "",
              salesmanTel: "",
              officeTel: "",
              accountName: "",
              accountBank: "",
              accountNo: ""
            }
          }
        },
        changeDeveloper(developerId) {
          let vm = this;
          let targetDeveloper;
          vm.developerListOptions.map(developer => {
            if (developer.developerId == developerId) {
              targetDeveloper = developer;
            }
          });
          vm.form.developerInfo = {...vm.form.developerInfo, ...targetDeveloper};
          vm.form.estateInfo = vm.formDemo().estateInfo;
          vm.form.estateSalesmanInfo = vm.formDemo().estateSalesmanInfo;
          vm.estateSalesmanListOptions = [];
          vm.$api.getEstateList({developerId: vm.form.developerInfo.developerId}).then(res => {
            vm.estateListOptions = res.data;
          });
        },
        changeEstate(estateId) {
          let vm = this;
          let target;
          vm.estateListOptions.map(estate => {
            if (estate.estateId == estateId) {
              target = estate;
            }
          });
          vm.form.estateInfo = {...vm.form.estateInfo, ...target};
          vm.form.estateSalesmanInfo = vm.formDemo().estateSalesmanInfo;
          vm.$api.getEstateSalesmanList({estateId: vm.form.estateInfo.estateId}).then(res => {
            vm.estateSalesmanListOptions = res.data;
          });
        },
        changeEstateSalesman(salesmanId) {
          let vm = this;
          let target;
          vm.estateSalesmanListOptions.map(estate => {
            if (estate.salesmanId == salesmanId) {
              target = estate;
            }
          });
          vm.form.estateSalesmanInfo = {...vm.form.estateSalesmanInfo, ...target};
        },
        save(formName) {
          let vm = this;
          if (vm.validateRules(formName, vm)) {
            this.$api.saveCaseDeveloperCfgInfo(this.form).then(res => {
              this.$router.push(
                {
                  path: `/case/caseDetail/developerInformation/${this.$route.params.caseId}`,
                  query: {
                    caseSubType: vm.$route.query.caseSubType
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
            this.$api.saveCaseDeveloperCfgInfo(this.form).then(res => {
              this.$router.push({
                path: `/case/caseDetail/materialInformation/${this.$route.params.caseId}`,
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
    .DeveloperInformation {
      .buttons {
        margin: 10px 20px;
      }

      .form {
        margin-top: 10px;
      }
    }
</style>
