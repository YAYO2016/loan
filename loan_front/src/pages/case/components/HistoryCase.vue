<template>
  <div class='HistoryCase'>
    <div class="mini-search">
      <el-tabs type="card" :before-leave="handleTabChange">
        <el-tab-pane label="主贷人">
          <el-input v-model="searchAll.mainCredit" placeholder="请输入主贷人姓名" size="mini" clearable></el-input>
        </el-tab-pane>
        <el-tab-pane label="卖方">
          <el-input v-model="searchAll.seller" placeholder="请输入卖方姓名" size="mini" clearable></el-input>
        </el-tab-pane>
        <el-tab-pane label="主贷人工作单位">
          <el-input v-model="searchAll.mainCreditCoName" placeholder="请输入主贷人工作单位关键字" size="mini" clearable></el-input>
        </el-tab-pane>
        <el-tab-pane label="渠道">
          <el-input v-model="searchAll.channelName" placeholder="请输入渠道名称" size="mini" clearable></el-input>
        </el-tab-pane>
      </el-tabs>
      <div class="search-button">
        <el-button @click="handleSearch">搜索</el-button>
      </div>
      <div class="search-button">
        <el-button @click="searchAll.ifSearchAll = !searchAll.ifSearchAll">筛选</el-button>
      </div>
    </div>
    <el-collapse-transition>
      <div v-show="searchAll.ifSearchAll" class="all-search">
        <el-form ref="form" :model="searchAll" size="mini" label-width="130px">
          <el-row>
            <el-col :span="24">
              <el-form-item label="案子类型：" prop="caseType">
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
          <el-row>
            <el-col :span="24">
              <el-form-item label="贷款银行：" prop="loanBank">
                <el-select v-model="searchAll.loanBank" clearable @change="handleBankChange">
                  <el-option
                    v-for="item in $store.state.banksOptions"
                    :key="item.bankId"
                    :label="item.bankName"
                    :value="item.bankId">
                  </el-option>
                </el-select>
                <el-select v-model="searchAll.loanBranch" clearable>
                  <el-option
                    v-for="item in loanBranchOptions"
                    :key="item.branchId"
                    :label="item.branchName"
                    :value="item.branchId">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="签单人员：" prop="signUser">
                <el-select v-model="searchAll.orgId" clearable @change="handleOrgChange">
                  <el-option
                    v-for="item in allOrg"
                    :key="item.orgId"
                    :label="item.orgName"
                    :value="item.orgId">
                  </el-option>
                </el-select>
                <el-select v-model="searchAll.signUser" clearable>
                  <el-option
                    v-for="item in allOrgUserOptions"
                    :key="item.userId"
                    :label="item.userName"
                    :value="item.userId">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="主贷人职业：" prop="caseType">
                <el-select v-model="searchAll.occuType" clearable>
                  <el-option v-for="item in $store.state.occuTypeOptions" :value="item.code" :label="item.desc"
                             :key="item.code"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="签单日期：" prop="caseType">
                <el-date-picker
                  v-model="signTime"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  type="daterange"
                  range-separator="~"
                  start-placeholder="开始日期"
                  end-placeholder="结束日期">
                </el-date-picker>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </div>
    </el-collapse-transition>
    <div class="table-content">
      <Table :tableData="tableData" style="width: 100%">
        <el-table-column
          property="createTime"
          label="录入时间"
          width="85">
          <div slot-scope="scope">
            {{dateFormat(scope.row.createTime)}}<br>{{hourFormat(scope.row.createTime)}}
          </div>
        </el-table-column>
        <el-table-column
          property="mainCredit"
          label="主贷人"
          show-overflow-tooltip
          width="90">
        </el-table-column>
        <el-table-column
          property="loanBank"
          label="贷款银行"
          show-overflow-tooltip
          width="">
        </el-table-column>
        <el-table-column
          property="caseType"
          label="案子大类"
          :formatter="rowCaseType"
          width="80">
        </el-table-column>
        <el-table-column
          property="caseSubType"
          label="案子小类"
          :formatter="rowSubCaseType"
          width="80">
        </el-table-column>
        <el-table-column
          property="loanType"
          label="贷款大类"
          :formatter="rowLoanType"
          show-overflow-tooltip
          width="80">
        </el-table-column>
        <el-table-column
          property="reserveAmount"
          label="公积金"
          show-overflow-tooltip
          width="100">
        </el-table-column>
        <el-table-column
          property="commercialAmount"
          label="商业"
          show-overflow-tooltip
          width="100">
        </el-table-column>
        <el-table-column
          property="lastedDate"
          label="持续时间"
          width="80">
        </el-table-column>
        <el-table-column
          property="caseStatusLink"
          label="环节"
          show-overflow-tooltip
          width="80">
        </el-table-column>
        <el-table-column
          property="caseStatusDesc"
          label="状态"
          show-overflow-tooltip
          width="90">
        </el-table-column>
        <el-table-column
          property="operateTypes"
          label="操作"
          width="">
          <template slot-scope="scope">
            <el-button type="text" size="small" v-for="item in scope.row.operateTypes" :key="item.code"
                       @click="operate(scope.row.caseId,scope.row.caseSubType,item.code)"
            >
              {{item.desc}}
            </el-button>
          </template>
        </el-table-column>
      </Table>
      <div class="pagination">
        <el-pagination :total="Number(allPageInfo.totalItems)"
                       background
                       small
                       layout="total, prev, pager, next, jumper"
                       @current-change="currentChange"
                       :current-page="Number(allPageInfo.pageNum)"
                       :page-size="Number(allPageInfo.pageSize)">
        </el-pagination>
      </div>
    </div>
    <div class="dialog">
      <!-- 查看 对话框-->
      <Dialog :title="'查看'"
              :show.sync="caseView.seeVisible"
              :width="'1000px'">
        <CaseView :caseId="caseView.caseId" :caseSubType="caseView.caseSubType" :_t="caseView._t"/>
      </Dialog>
    </div>
  </div>
</template>

<script>
  import Table from '../../../components/table/Table';
  import Split from '../../../components/split/Split';
  import Dialog from '../../../components/dialog/Dialog';
  import CaseView from '../../caseview/CaseView';

  export default {
    name: "HistoryCase",
    components: {
      Table, Dialog, Split, CaseView
    },
    data() {
      return {
        caseSelect: [],
        signTime: [],
        loanBranch: {},
        loanBranchOptions: [],
        allOrg: [],
        allOrgUser: {},
        allOrgUserOptions: [],
        searchAll: {
          ifSearchAll: false,

          mainCredit: '',
          seller: '',
          mainCreditCoName: '',//主贷人工作单位
          channelName: '',//渠道名称

          caseType: '',
          caseSubType: '',
          signStartTime: '',
          signEndTime: '',
          loanBank: '',
          loanBranch: '',
          occuType: '', // 主贷人职业
          orgId: '',
          signUser: '',
        },
        tableData: [],
        allPageInfo: {
          pageNum: "1",
          pageSize: "10",
          totalItems: "0",
          totalPages: "0",
          offSet: "0"
        },
        //查看
        caseView: {
          seeVisible: false,
          caseSubType: '',
          _t: new Date(),
          caseId: '',
        },
      }
    },
    mounted() {
      // this.getData();
      this.getAllOrg();
      this.getData();
    },
    methods: {
      currentChange(currentPage) {
        let vm = this;
        vm.getData(currentPage, vm.allPageInfo.pageSize)
      },
      //列表中的流程按钮
      async operate(caseId, caseSubType, code) {
        let vm = this;
        switch (code) {
          case 'VIEW': // 查看
            vm.caseView.caseSubType = caseSubType;
            vm.caseView.caseId = caseId;
            vm.caseView._t = new Date();
            vm.caseView.seeVisible = true;
            break;
          default:
            return;
        }
      },
      getData(currentPage = '1', pageSize = '10') {
        let vm = this;
        vm.allPageInfo.pageNum = currentPage;
        vm.allPageInfo.pageSize = pageSize;
        vm.$api.getHistoryCaseList({
          ...vm.searchAll,
          ...vm.allPageInfo
        }).then(res => {
          vm.tableData = res.data;
          vm.allPageInfo = res.pageInfo;
        })
      },
      handleSearch() {
        let vm = this;
        console.log(vm.searchAll);
        vm.getData();
      },
      handleTabChange(activeName, oldActiveName) {
        let vm = this;
        vm.searchAll.mainCredit = '';
        vm.searchAll.seller = '';
        vm.searchAll.mainCreditCoName = '';
        vm.searchAll.channelName = '';
      },
      async handleBankChange(bankId) {
        let vm = this;
        if (!bankId) {
          vm.loanBranchOptions = [];
          vm.searchAll.loanBranch = '';
          return;
        }
        if (!vm.loanBranch[bankId]) {
          await vm.getBranch(bankId);
        }
        vm.loanBranchOptions = vm.loanBranch[bankId];
        vm.searchAll.loanBranch = '';
      },
      async getBranch(bankId) {
        let vm = this;
        await vm.$api.branchsList({
          bankId: bankId,
          pageNum: 1,
          pageSize: 9999,
        }).then(res => {
          vm.loanBranch[bankId] = res.data;
        })
      },
      getAllOrg() {
        let vm = this;
        vm.$api.orgList({
          pageNum: 1,
          pageSize: 9999,
        }).then(res => {
          vm.allOrg = res.data;
        })
      },
      async handleOrgChange(orgId) {
        let vm = this;
        if (!orgId) {
          vm.allOrgUserOptions = [];
          vm.searchAll.signUser = '';
          return;
        }
        if (!vm.allOrgUser[orgId]) {
          await vm.getOrgUsers(orgId);
        }
        vm.allOrgUserOptions = vm.allOrgUser[orgId];
        vm.searchAll.signUser = '';
      },
      async getOrgUsers(orgId) {
        let vm = this;
        await vm.$api.getUserByOrgId({orgId}).then(res => {
          vm.allOrgUser[orgId] = res.data;
        })
      },
    },
    watch: {
      caseSelect(newVal, oldVal) {
        let vm = this;
        vm.searchAll.caseType = newVal[0];
        vm.searchAll.caseSubType = newVal[1];
      },
      signTime(newVal, oldVal) {
        let vm = this;
        vm.searchAll.signStartTime = null;
        vm.searchAll.signEndTime = null;
        if (newVal) {
          vm.searchAll.signStartTime = newVal[0];
          vm.searchAll.signEndTime = newVal[1];
        }

      },
    }
  }

</script>

<style lang='scss' scoped>
  .HistoryCase {
    margin: 10px;

    .mini-search {
      display: flex;
      justify-content: flex-end;

      /deep/ .el-tabs {
        width: 100%;
      }

      .search-button {
        padding-top: 31px;

        /deep/ .el-button {
          margin-left: 0;
          padding: 6px 15px;
        }
      }

      /deep/ .el-tabs__header {
        margin: 0;
        /*border-bottom: 1px;*/
        /deep/ .el-tabs__item {
          height: 30px;
          line-height: 30px;
        }

        /deep/ .is-active {
          background: #409EFF;
          color: white;
          /*border-radius: 4px 4px 0 0;*/
          border-bottom-color: rgba(0, 0, 0, 0);
        }
      }
    }

    .all-search {
      .el-form {
        /deep/ .el-form-item {
          margin-bottom: 0;

          /deep/ .el-date-editor {
            margin-top: 2px;
          }
        }
      }
    }

    .table-content {
      margin-top: 10px;

      /deep/ .el-table td {
        padding: 0;
      }

      /deep/ .el-table td .cell {
        line-height: 20px;
        padding-left: 1px;
        padding-right: 1px;

        /deep/ .el-button {
          margin-left: 5px;
        }
      }

      .pagination {
        margin-top: 5px;
        text-align: center;
      }


    }
  }
</style>
