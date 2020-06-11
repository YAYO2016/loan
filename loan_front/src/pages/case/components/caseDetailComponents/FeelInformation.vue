<template>
  <div class='FeelInformation'>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="buttons">
      <el-button size="mini" @click="getData">重置</el-button>
      <el-button size="mini" @click="save">保存</el-button>
      <el-button size="mini" @click="overview">总览</el-button>
      <el-button size="mini" @click="approval">提交审批</el-button>

    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="form">
      <el-form ref="form" :model="form" size="mini" label-width="160px">
        <Table
          :tableData="form.feeItemInfo" style="width: 100%"
        >
          <el-table-column
            width="50">
            <template slot-scope="scope">
              <span>
                <i class="el-icon-remove" style="color: red;font-size: 20px"
                   @click="delFeel(scope.row.itemId)"></i>
              </span>
            </template>
          </el-table-column>
          <el-table-column
            property="itemName"
            label="费用科目名称"
          ></el-table-column>
          <el-table-column
            property="beforeContent"
            label="增值内容（处理前）"
            width="150px"
          >
            <template slot-scope="scope">
              <el-input size="mini" v-model="form.feeItemInfo[scope.$index].beforeContent"></el-input>
            </template>
          </el-table-column>
          <el-table-column
            property="afterContent"
            label="增值内容（处理后）"
            width="150px"
          >
            <template slot-scope="scope">
              <el-input size="mini" v-model="form.feeItemInfo[scope.$index].afterContent"></el-input>
            </template>
          </el-table-column>
          <el-table-column
            property="itemPrice"
            label="单价"
          ></el-table-column>
          <el-table-column
            property="itemCount"
            label="数量"
          >
            <template slot-scope="scope">
              <el-input size="mini" v-model="form.feeItemInfo[scope.$index].itemCount"
                        @change="calcAmount(scope.$index)"></el-input>
            </template>
          </el-table-column>
            <el-table-column
            property="itemAmount"
            label="总价"
            >
              <template slot-scope="scope">
                {{form.feeItemInfo[scope.$index].itemAmount}}
              </template>
            </el-table-column>
          <el-table-column
            property="itemRate"
            label="成本扣点率"
            :formatter="rowItemRate"
          ></el-table-column>
          <el-table-column
            property="itemProfit"
            label="利润"
          >
            <template slot-scope="scope">
              <el-input size="mini" v-model="form.feeItemInfo[scope.$index].itemProfit"></el-input>
            </template>
          </el-table-column>
        </Table>
        <div style="margin-top:10px">
          <el-button @click="addFeel" size="small">添加新费用科目</el-button>
        </div>
      </el-form>
    </div>
    <div class="dialog">
      <Dialog
        :title="'请选择材料'"
        :show.sync="formVisible"
        @closedDialog="searchKey.input='';search.input='';">
        <div>
          <el-row>
            <el-col>
              <el-input v-model="search.input" style="width: 300px" size="mini"></el-input>
              <el-button size="mini" @click="handleSearch(search.input)">搜索</el-button>
            </el-col>
          </el-row>
          <Split></Split>
          <el-row>
            <el-col>
              <Table
                :tableData="tableData" style="width: 100%"
              >
                <el-table-column
                  property="itemName"
                  label="费用科目名"
                  width="100">
                </el-table-column>
                <el-table-column
                  property="itemDesc"
                  label="费用科目说明"
                  width="">
                </el-table-column>
                <el-table-column
                  property="itemPrice"
                  label="费用科目单价"
                  width="">
                </el-table-column>
                <el-table-column
                  property="itemRate"
                  label="费用科目扣点率"
                  width="">
                </el-table-column>
                <el-table-column
                  property="operator"
                  label="操作"
                  width="200px">
                  <template slot-scope="scope">
                    <el-button @click="select(scope.row.itemId)" type="text" size="small">选择</el-button>
                  </template>
                </el-table-column>
              </Table>
            </el-col>
          </el-row>
        </div>
      </Dialog>
      <Dialog :title="'审批人'"
              :show.sync="approvalVisible"
              @closedDialog="approvalTableData=[]">
        <Table
          :tableData="approvalTableData" style="width: 100%"
        >
          <el-table-column
            width="50">
            <template slot-scope="scope">
              <el-radio :label="scope.row.userId" v-model="approvalForm.nextOperatorId"
                        @change="selectUser(scope.$index,scope.row)">&nbsp;
              </el-radio>
            </template>
          </el-table-column>
          <el-table-column
            property="userName"
            label="人员名称"
            width="">
          </el-table-column>
        </Table>
        <div class="dialog-footer">
          <el-button @click="submit">提交</el-button>
        </div>
      </Dialog>

      <Dialog :title="'总览'"
              :show.sync="overViewVisible"
              @closedDialog=""
              :width="'1000px'">
        <OverView :overViewData="overViewData" :caseSubType="$route.query.caseSubType"></OverView>
      </Dialog>
    </div>
  </div>
</template>

<script>
  import Dialog from '../../../../components/dialog/Dialog';
  import Table from '../../../../components/table/Table';
  import Split from '../../../../components/split/Split';
  import OverView from '../../../caseview/components/OverView';

  export default {
    name: "FeelInformation",
    components: {Dialog, Table, Split, OverView},
    data() {
      return {
        form: this.formDemo(),
        search: {
          input: '',
        },
        searchKey: {
          input: '',
        },
        formVisible: false,
        tableData: [],
        approvalVisible: false,
        approvalTableData: [],
        approvalForm:{
          caseId:this.$route.params.caseId,
          operateType:'SUBMIT',
          operateResult:'',
          nextOperatorId:'',
          operateRemark:''
        },
        //总览 对话框
        overViewVisible: false,
        overViewData: {},
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
        vm.$api.getCaseFeeItemCfgInfo({caseId: this.$route.params.caseId}).then(res => {
          vm.form = {...vm.form, ...res.data};
          if (vm.form.feeItemInfo === null) {  //初始数据
            vm.form.feeItemInfo = this.formDemo().feeItemInfo;
          }
        });
      },
      formDemo() {
        return {
          caseId: "",
          feeItemInfo: []
        }
      },
      addFeel() {
        let vm = this;
        vm.$api.feelsList({
          itemName: vm.searchKey.input,
          pageNum: 1,
          pageSize: 99999,
        }).then(res => {
          vm.tableData = res.data;
          vm.formVisible = true;
        })
      },
      handleSearch(input) {
        let vm = this;
        vm.searchKey.input = input;
        vm.addFeel();
      },
      select(itemId) {
        let vm = this;
        vm.$api.getSingleFeeItem({itemId}).then(res => {
          let lenOld = vm.form.feeItemInfo.length;
          vm.form.feeItemInfo.push(res.data);
          vm.form.feeItemInfo = vm.$util.ArrayFn.arrObjUnique(vm.form.feeItemInfo, 'itemId');
          let lenNew = vm.form.feeItemInfo.length;
          if (lenOld == lenNew) {
            vm.$message.info('该费用科目已存在！');
          }
        });
        vm.formVisible = false;
      },
      delFeel(itemId) {
        let vm = this;
        vm.form.feeItemInfo = vm.$util.ArrayFn.delObjArr(vm.form.feeItemInfo, itemId, 'itemId');
      },
      save() {
        let vm = this;
        this.$api.saveCaseFeeItemCfgInfo(this.form).then(res => {
          this.$router.push(
            {
              path: `/case/caseDetail/feelInformation/${this.$route.params.caseId}`,
              query: {
                caseSubType: vm.$route.query.caseSubType
              }
            }
          );
          this.$message.success(res.msg);
          this.getData();
        })
      },
      calcAmount(index) {
        let vm = this;
        vm.form.feeItemInfo[index].itemAmount = vm.changeTwoDecimal(parseFloat(vm.form.feeItemInfo[index].itemCount) * parseFloat(vm.form.feeItemInfo[index].itemPrice));
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
      overview() {
        let vm = this;
        vm.$api.getCaseOverviewInfo({caseId: vm.$route.params.caseId}).then(res => {
          vm.overViewData = res.data;
          vm.overViewVisible = true;
        })
      },
      approval() {
        let vm = this;
        vm.$api.listRoleUser({roleDict: 'R0301'}).then(res => {
          vm.approvalTableData = res.data;
          vm.approvalVisible = true;
        })
      },
      selectUser(index, row) {
        let vm = this;
        vm.approvalForm.nextOperatorId = '';
        vm.approvalForm.nextOperatorId = row.userId;
      },
      submit(){
        let vm = this;
        vm.$api.drivingProcess(vm.approvalForm).then(res=>{
          vm.approvalVisible = false;
          if ('200' === res.status){
            this.$message.success(res.msg);
            this.$router.push({path:`/case/workbench`});
          }else{
            this.$message.error(res.msg);
          }
        })
      }
    }
  }
</script>

<style lang='scss' scoped>
  .FeelInformation {
    .buttons {
      margin: 10px 20px;
    }

    .form {
      margin: 10px;

      /deep/ .el-input, .el-select ,.el-textarea{
        vertical-align: middle;
      }
    }
  }
</style>
