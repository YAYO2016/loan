<template>
  <div class='ChannelInformation'>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="buttons">
      <el-button size="mini" @click="getData">重置</el-button>
      <el-button size="mini" @click="save('form')">保存</el-button>
      <el-button size="mini" @click="next('form')">下一步</el-button>
    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="form">
      <el-form ref="form" :model="form" size="mini" label-width="130px">
        <el-row>
          <el-col :span="24">
            <el-form-item label="渠道全称：" prop="channelInfo.channelName">
              <el-input v-model="form.channelInfo.channelName" placeholder="请选择" readonly size="small">
                <el-button slot="prepend" @click="searchChannel">选择</el-button>
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item label="渠道电话：" prop="channelPhone">
              <el-input v-model="form.channelInfo.channelPhone" readonly/>
            </el-form-item>
          </el-col>
          <el-col :span="16">
            <el-form-item label="渠道地址：" prop="channelAddress">
              <el-input v-model="form.channelInfo.channelAddress" readonly/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item label="渠道负责人：" prop="bossName">
              <el-input v-model="form.channelInfo.bossName" readonly/>
            </el-form-item>
          </el-col>
          <el-col :span="16">
            <el-form-item label="负责人手机：" prop="bossMphone">
              <el-input v-model="form.channelInfo.bossMphone" readonly/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item label="结算户名：" prop="accountName">
              <el-input v-model="form.channelInfo.accountName" readonly/>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="结算卡开户行：" prop="accountBank">
              <el-input v-model="form.channelInfo.accountBank" readonly/>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="账号：" prop="accountNo">
              <el-input v-model="form.channelInfo.accountNo" readonly/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item label="对接人：" prop="staffName">
              <el-select placeholder="请选择" v-model="form.channelInfo.staffName"
                         @change="staffIdChange">
                <el-option
                  v-for="item in staffIdOptions"
                  :key="item.staffId"
                  :label="item.staffName"
                  :value="item.staffId"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="对接人职务：" prop="staffDuty">
              <el-input :value="channelStaffDuty(form.channelInfo.staffDuty)" readonly/>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="对接人电话：" prop="staffTel">
              <el-input v-model="form.channelInfo.staffTel" readonly/>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
    </div>
    <div class="dialog">
      <Dialog
        :title="'请选择渠道'"
        :show.sync="formVisible"
        @closedDialog="">
        <div>
          <el-row>
            <el-col>
              <el-input v-model="search.input" style="width: 100%" placeholder="请输入渠道名称" size="small">
                <el-button slot="append" @click="handleSearch(search.input)">搜索</el-button>
              </el-input>
            </el-col>
          </el-row>
          <Split></Split>
          <el-row>
            <el-col>
              <Table
                :tableData="tableData" style="width: 100%"
              >
                <el-table-column
                  property="channelType"
                  label="渠道类型"
                  :formatter="channelTypeFormat"
                  width="100">
                </el-table-column>
                <el-table-column
                  property="channelName"
                  label="渠道名称"
                  show-overflow-tooltip
                  width="">
                </el-table-column>
                <el-table-column
                  property="bossMphone"
                  label="电话"
                  width="">
                </el-table-column>
                <el-table-column
                  property="channelAddress"
                  label="地址"
                  show-overflow-tooltip
                  width="">
                </el-table-column>
                <el-table-column
                  property="operator"
                  label="操作"
                  width="70">
                  <template slot-scope="scope">
                    <el-button @click="select(scope.row.channelId)" type="text" size="small">选择</el-button>
                  </template>
                </el-table-column>
              </Table>
            </el-col>
          </el-row>
        </div>
      </Dialog>
    </div>
  </div>
</template>

<script>
  import Dialog from '../../../../components/dialog/Dialog';
  import Table from '../../../../components/table/Table';
  import Split from '../../../../components/split/Split';

  export default {
    name: "ChannelInformation",
    components: {Dialog, Table, Split},
    data() {
      return {
        form: this.formDemo(),
        formVisible: false,
        staffIdOptions: [],
        search: {
          input: '',
        },
        searchKey: {
          input: '',
        },
        tableData: []
      }
    },
    mounted() {
      let vm = this;
      //初始化数据
      vm.$refs.form.resetFields();
      this.getData();
    },
    methods: {
      getData() {
        let vm = this;
        vm.$refs.form.resetFields();
        vm.$api.getCaseChannelCfgInfo({caseId: this.$route.params.caseId}).then(res => {
          vm.form = {...vm.form, ...res.data};
          if (vm.form.channelInfo === null) {  //初始数据
            vm.form.channelInfo = this.formDemo().channelInfo;
          } else if (res.data.channelInfo.staffInfos !== null) {
            vm.staffIdOptions = res.data.channelInfo.staffInfos;
          }
        });
      },
      formDemo() {
        return {
          caseId: "",
          channelInfo: {
            channelId: "",
            channelType: "",
            channelName: "",
            channelPhone: "",
            channelAddress: "",
            bossName: "",
            bossMphone: "",
            accountName: "",
            accountBank: "",
            accountNo: "",
            staffId: "",
            staffName: "",
            staffTel: "",
            staffDuty: ""
          }
        }
      },
      searchChannel() {
        let vm = this;
        vm.$api.getChannelList({
          channelName: vm.searchKey.input,
          channelType: "",
          pageNum: 1,
          pageSize: 99999,
        }).then(res => {
          vm.tableData = res.data;
          vm.formVisible = true;
        })
      },
      //搜索
      handleSearch(input) {
        let vm = this;
        vm.searchKey.input = input;
        vm.searchChannel();
      },
      select(channelId) {
        let vm = this;
        vm.$api.getSingleChannel({channelId}).then(res => {
          vm.form.channelInfo = {
            ...vm.form.channelInfo,
            ...res.data,
            staffDuty: '',
            staffTel: '',
            staffName: ''
          };
          vm.staffIdOptions = res.data.staffInfos;
        });
        vm.formVisible = false;
      },
      staffIdChange(staffId) {
        let vm = this;
        vm.staffIdOptions.map(staffIdItem => {
          if (staffIdItem.staffId === staffId) {
            vm.form.channelInfo.staffId = staffIdItem.staffId;
            vm.form.channelInfo.staffDuty = staffIdItem.staffDuty;
            vm.form.channelInfo.staffName = staffIdItem.staffName;
            vm.form.channelInfo.staffTel = staffIdItem.staffTel;
          }
        })
      },
      save(formName) {
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          this.$api.saveCaseChannelCfgInfo(this.form).then(res => {
            this.$router.push(
              {
                path: `/case/caseDetail/channelInformation/${this.$route.params.caseId}`,
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
          this.$api.saveCaseChannelCfgInfo(this.form).then(res => {
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
  .ChannelInformation {
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
