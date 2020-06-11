<template>
  <div class='WorkBench'>
    <div class="top">
      <el-row>
        <!--          <el-col :span="8">-->
        <!--            <div class="left">-->
        <!--              <el-card>-->
        <!--                <div slot="header" class="clearfix">-->
        <!--                  <span>个人信息</span>-->
        <!--                </div>-->
        <!--                <div>-->
        <!--                  <el-row>-->
        <!--                    <el-col :span="8">-->
        <!--                      <i class="iconfont icon-gangweiqiehuan" style="font-size:50px"></i>-->
        <!--                    </el-col>-->
        <!--                    <el-col :span="16">-->
        <!--                      <div><strong>员工号：</strong>{{$store.state.userInfo.loginAccount}}</div>-->
        <!--                      <div><strong>姓 名：</strong>{{$store.state.userInfo.userName}}</div>-->
        <!--                    </el-col>-->
        <!--                  </el-row>-->
        <!--                  <el-row>-->
        <!--                    <el-col :span="24">-->
        <!--                      <el-col :span="8">-->
        <!--                        <strong>角  色：</strong>-->
        <!--                      </el-col>-->
        <!--                      <el-col :span="15">-->
        <!--                      <span v-for="item in $util.StorageFn.getUserRoleMap()">-->
        <!--                        {{item.name}}-->
        <!--                      </span>-->
        <!--                      </el-col>-->
        <!--                    </el-col>-->
        <!--                  </el-row>-->
        <!--                  <el-row>-->
        <!--                    <el-col :span="24">-->
        <!--                      <el-col :span="8">-->
        <!--                        <strong>组织机构：</strong>-->
        <!--                      </el-col>-->
        <!--                      <el-col :span="15">-->
        <!--                        {{$store.state.userInfo.orgName}}-->
        <!--                      </el-col>-->
        <!--                    </el-col>-->
        <!--                  </el-row>-->
        <!--                </div>-->
        <!--              </el-card>-->
        <!--            </div>-->
        <!--          </el-col>-->
        <el-col :span="24">
          <div class="right">
            <el-card>
              <div slot="header" class="clearfix">
                <span>我的工作概况</span>
              </div>
              <div>
                <el-row v-if="$store.state.userInfo.roles.indexOf('R0201') !== -1">
                  <el-col :span="5">
                    <div class="item-detail" style="background: #36A9CE;">
                      <div>签单总数</div>
                      <div>{{caseCountData.c11}}</div>
                    </div>
                  </el-col>
                  <el-col :span="5">
                    <div class="item-detail" style="background: #999999">
                      <div>当月签单数</div>
                      <div>{{caseCountData.c12}}</div>
                    </div>
                  </el-col>
                  <el-col :span="14">
                    <el-row>
                      <el-col :span="12">
                        <div class="item-detail" style="background: #D0E17D; height: 40px;padding-top: 5px;">
                          <div>进行中</div>
                          <div>{{caseCountData.c13}}</div>
                        </div>
                      </el-col>
                      <el-col :span="12">
                        <div class="item-detail" style="background: #EF5AA1 ;height: 40px;padding-top: 5px;">
                          <div>完成</div>
                          <div>{{caseCountData.c14}}</div>
                        </div>
                      </el-col>
                    </el-row>
                    <el-row>
                      <div class="item-detail" style="background: #FFDF25; height: 40px;padding-top: 5px;">
                        <div>待办任务</div>
                        <div>{{caseCountData.c15}}</div>
                      </div>
                    </el-row>
                  </el-col>
                </el-row>
                <el-row v-if="$store.state.userInfo.roles.indexOf('R0201') === -1">
                  <el-col :span="6">
                    <div class="item-detail" style="background: #36A9CE;">
                      <div>审核案子数总数</div>
                      <div>{{caseCountData.c21}}</div>
                    </div>
                  </el-col>
                  <el-col :span="6">
                    <div class="item-detail" style="background: #999999">
                      <div>当月审核案子数</div>
                      <div>{{caseCountData.c22}}</div>
                    </div>
                  </el-col>
                  <el-col :span="6">
                    <div class="item-detail" style="background: #FFDF25">
                      <div>当月收入</div>
                      <div>{{caseCountData.c23}}</div>
                    </div>
                  </el-col>
                  <el-col :span="6">
                    <div class="item-detail" style="background: #D0E17D">
                      <div>待办任务</div>
                      <div>{{caseCountData.c24}}</div>
                    </div>
                  </el-col>
                </el-row>
              </div>
            </el-card>
          </div>
        </el-col>
      </el-row>
    </div>
    <div class="middle case-table">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>----待办任务----</span>
          <!--  管理员的时候不显示 新增案子-->
          <el-button v-if="$util.StorageFn.checkPrivileges(['LFR02001'])" size="mini" @click="addCase">
            新增案子
          </el-button>
          <el-badge is-dot class="item" :hidden="!hasNewWait" style="vertical-align: unset;">
            <el-button size="mini" @click="refreshWaitData">刷新</el-button>
          </el-badge>
        </div>
        <div>
          <Table :tableData="tableWaitData" style="width: 100%">
            <el-table-column
              property="createTime"
              label="录入时间"
              width="85">
              <div slot-scope="scope">
                {{dateFormat(scope.row.createTime)}}<br>{{hourFormat(scope.row.createTime)}}
              </div>
            </el-table-column>
            <el-table-column
              property="createUserName"
              label="签单员"
              show-overflow-tooltip
              width="90">
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
              width="80">
            </el-table-column>
            <el-table-column
              property="reserveAmount"
              label="公积金"
              width="100">
            </el-table-column>
            <el-table-column
              property="commercialAmount"
              label="商业"
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
            <el-pagination :total="Number(waitPageInfo.totalItems)"
                           background
                           small
                           layout="total, prev, pager, next, jumper"
                           @current-change="currentWaitChange"
                           @size-change="sizeWaitChange"
                           :current-page="Number(waitPageInfo.pageIndex)"
                           :page-size="Number(waitPageInfo.pageSize)">
            </el-pagination>
          </div>
        </div>
      </el-card>
    </div>
    <div class="bottom case-table">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>----工作跟踪----</span>&nbsp;
          <el-button
            v-if="$store.state.userInfo.roles.indexOf('R0101') === -1 && $store.state.userInfo.roles.indexOf('R0201') !== -1"
            size="mini" :type="'2'===searchAll.pageType?'primary':''" @click="pageTypeAll('2')">我发起的
          </el-button>
          <el-button size="mini" :type="'3'===searchAll.pageType?'primary':''" @click="pageTypeAll('3')">我参与的
          </el-button>&nbsp;
          <el-radio v-model="searchAll.ifClose" label="1" size="mini">未完结</el-radio>
          <el-radio v-model="searchAll.ifClose" label="2" size="mini">已完结</el-radio>
          <el-button size="mini" @click="refresh">刷新</el-button>
        </div>
        <div>
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
              width="80">
            </el-table-column>
            <el-table-column
              property="reserveAmount"
              label="公积金"
              width="100">
            </el-table-column>
            <el-table-column
              property="commercialAmount"
              label="商业"
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
                           @size-change="sizeChange"
                           :current-page="Number(allPageInfo.pageIndex)"
                           :page-size="Number(allPageInfo.pageSize)">
            </el-pagination>
          </div>
        </div>
      </el-card>
    </div>

    <div class="dialog">
      <!-- 风控审核 对话框-->
      <Dialog :title="''"
              :show.sync="fengKongCheckVisible"
              @closedDialog="fengKongCheckForm=fengKongCheckDemoForm()"
              :width="'900px'">
        <el-form ref="fengKongCheckForm" :model="fengKongCheckForm" size="mini" label-width="180px">
          <el-row>
            <el-col :span="24">
              <el-form-item label="审批结果：" prop="operateResult" :rules="$rules.NotEmpty">
                <el-select v-model="fengKongCheckForm.operateResult">
                  <el-option label="通过" value="PASS"></el-option>
                  <el-option label="退回" value="NOT_PASS"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <el-form-item label="审批银行：" prop="branchName">
                {{fengKongCheckForm.bankName}} &nbsp;
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="分行：" prop="branchId" :rules="$rules.NotEmpty">
                <el-select v-model="fengKongCheckForm.branchId" @change="changeBranch">
                  <el-option v-for="branch in fengKongCheckForm.branchInfos" :label="branch.branchName"
                             :value="branch.branchId"
                             :key="branch.branchId"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
          </el-row>
          <el-col :span="8">
            <el-form-item label="审批银行客户经理：" prop="managerName">
              {{fengKongCheckForm.managerName}}
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="审批银行客户经理电话：" prop="managerPhone">
              {{fengKongCheckForm.managerPhone}}
            </el-form-item>
          </el-col>
          <el-row v-if="'PASS' === fengKongCheckForm.operateResult">
            <el-col :span="24">
              <el-form-item label="财务人员：" prop="nextOperatorId" :rules="$rules.NotEmpty">
                <el-select v-model="fengKongCheckForm.nextOperatorId">
                  <el-option v-for="Operator in fengKongCheckForm.nextOperatorOptions" :label="Operator.userName"
                             :value="Operator.userId"
                             :key="Operator.userId"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="24">
              <el-form-item label="审批意见：" prop="operateRemark" :rules="$rules.NotEmpty">
                <el-input type="textarea" v-model="fengKongCheckForm.operateRemark"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item>
                <el-button @click="fengKongCheckSubmit('fengKongCheckForm')">提交</el-button>
                <el-button @click="fengKongCheckVisible=false">取消</el-button>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </Dialog>

      <!-- 提交  对话框-->
      <Dialog :title="'风控审批人'"
              :show.sync="approvalVisible"
              @closedDialog="approvalTableData=[]">
        <Table
          :tableData="approvalTableData" style="width: 100%"
        >
          <el-table-column
            label="选择"
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
        <el-row>
          <el-col :span="24">
            <el-form-item label="备注：" prop="operateRemark">
              <el-input type="textarea" v-model="flowForm.operateRemark"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <div class="dialog-footer">
          <el-button @click="submit">提交</el-button>
        </div>
      </Dialog>
      <!--财务审核 对话框-->
      <Dialog :title="flowForm.dialogTitle"
              :show.sync="reviewVisible"
              @closedDialog="flowForm=flowDemoForm()"
              :width="'400px'">
        <el-form ref="reviewForm" :model="flowForm" size="mini" label-width="100px">
          <el-row>
            <el-col :span="24">
              <el-form-item label="审批结果：" prop="operateResult" :rules="$rules.NotEmpty">
                <el-select v-model="flowForm.operateResult">
                  <el-option label="通过" value="PASS"></el-option>
                  <el-option label="退回" value="NOT_PASS"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row v-if="'PASS' === flowForm.operateResult && 'CAIWU_CHECK' === flowForm.operateType">
            <el-col :span="24">
              <el-form-item label="外勤人员：" prop="nextOperatorId" :rules="$rules.NotEmpty">
                <el-select v-model="flowForm.nextOperatorId">
                  <el-option v-for="Operator in flowForm.nextOperatorOptions" :label="Operator.userName"
                             :value="Operator.userId"
                             :key="Operator.userId"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="备注：" prop="operateRemark">
                <el-input type="textarea" v-model="flowForm.operateRemark"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-form-item>
            <el-button type="primary" @click="flowSubmit('reviewForm','reviewVisible')">确定</el-button>
            <el-button @click="reviewVisible=false">取消</el-button>
          </el-form-item>
        </el-form>
      </Dialog>

      <Dialog :title="flowForm.dialogTitle"
              :show.sync="submitVisible"
              @closedDialog="flowForm=flowDemoForm()"
              :width="'400px'">
        <el-form ref="submitForm" :model="flowForm" size="mini" label-width="80px">
          <!--          <div style="text-align: center;line-height: 40px;font-size: 16px">-->
          <!--            {{flowForm.dialogTitle}}-->
          <!--          </div>-->
          <el-form-item label="备注：" prop="operateRemark">
            <el-input type="textarea" v-model="flowForm.operateRemark"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="flowSubmit('submitForm','submitVisible')">确定</el-button>
            <el-button @click="submitVisible=false">取消</el-button>
          </el-form-item>
        </el-form>

      </Dialog>

      <!-- 查看 对话框-->
      <Dialog :title="'查看'"
              :show.sync="caseView.seeVisible"
              :width="'1000px'">
        <CaseView :caseId="caseView.caseId" :caseSubType="caseView.caseSubType" :_t="caseView._t"/>
      </Dialog>

      <!-- 整改 对话框-->
      <Dialog :title="'整改'"
              :show.sync="reformVisible"
              @closedDialog="reformData=reformDemoData()"
              :width="'1000px'"
      >
        <el-form ref="reformForm" :model="reformData" size="mini" label-width="100px">
          <el-card>
            <div slot="header" class="clearfix">
              <span>案子整改</span>
            </div>
            <div>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="案子类型：" prop="caseSelect">
                    <el-cascader
                      v-model="reformData.caseSelect"
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
                  <el-form-item label="整改来源：">
                    {{reformData.reformSource}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="整改意见：" prop="reformRemark">
                    <el-input type="textarea" v-model="reformData.reformRemark" disabled></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
            </div>
          </el-card>
          <el-card style="margin-top: 20px">
            <el-tabs v-model="reformActiveName" type="card">
              <!-- 贷款信息整改-->
              <el-tab-pane label="贷款信息整改" name="loanInformation" v-if="reformData.loanInfo">
                <el-row>
                  <el-col :span="24">
                    <el-form-item label="贷款类型：" prop="LoanTypeSelect" :rules="$rules.NotEmpty">
                      <el-cascader
                        v-model="reformData.LoanTypeSelect"
                        clearable
                        placeholder="选择贷款类型"
                        :options="$store.state.loanTypeOptions"
                        :props="{value: 'code',label: 'desc',children: 'children'}"
                        filterable
                      ></el-cascader>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row v-if="reformData.loanInfo.loanType === 'RESERVE' || reformData.loanInfo.loanType === 'SYNDICATED'">
                  <el-col :span="8">
                    <el-form-item label="公积金贷款金额：" label-width="140px" prop="loanInfo.reserveAmount" :rules="$rules.NotEmpty">
                      <el-input v-model="reformData.loanInfo.reserveAmount"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="公积金贷款申请年限：" label-width="170px" prop="loanInfo.reserveYear" :rules="$rules.NotEmpty">
                      <el-input v-model="reformData.loanInfo.reserveYear"></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row v-if="reformData.loanInfo.loanType === 'SYNDICATED'|| reformData.loanInfo.loanType === 'COMMERCIAL'">
                  <el-col :span="8">
                    <el-form-item label="商业贷款金额：" label-width="140px" prop="loanInfo.commercialAmount" :rules="$rules.NotEmpty">
                      <el-input v-model="reformData.loanInfo.commercialAmount"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="商业贷款申请年限：" label-width="170px" prop="loanInfo.commercialYear" :rules="$rules.NotEmpty">
                      <el-input v-model="reformData.loanInfo.commercialYear"></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="还款方式：" prop="loanInfo.repaymentType" :rules="$rules.NotEmpty">
                      <el-select v-model="reformData.loanInfo.repaymentType" clearable>
                        <el-option v-for="item in $store.state.repaymentTypeOptions" :value="item.code"
                                   :label="item.desc"
                                   :key="item.code"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="贷款银行：" prop="loanInfo.loanBank" :rules="$rules.NotEmpty">
                      <el-select v-model="reformData.loanInfo.loanBank" clearable>
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
                    <el-form-item label="还款账号：" prop="loanInfo.repaymentAccount" :rules="$rules.NotEmpty">
                      <el-input v-model="reformData.loanInfo.repaymentAccount"></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
              </el-tab-pane>
              <!-- 材料信息整改-->
              <el-tab-pane label="材料信息整改" name="materialInformation">
                <Table
                  :tableData="reformData.materialInfo" style="width: 100%"
                >
                  <el-table-column
                    width="50">
                    <template slot-scope="scope">
                        <span>
                          <i class="el-icon-remove" style="color: red;font-size: 20px"
                             @click="delMaterial(scope.row.materialId)"></i>
                          </span>
                    </template>
                  </el-table-column>
                  <el-table-column
                    property="materialName"
                    label="材料名称"
                  ></el-table-column>
                  <el-table-column
                    property="materialBelong"
                    label="材料归属"
                    width="130"
                  >
                    <template slot-scope="scope">
                      <el-select size="mini" v-model="reformData.materialInfo[scope.$index].materialBelong">
                        <el-option v-for="item in $store.state.materialBelongOptions" :value="item.code"
                                   :label="item.desc"
                                   :key="item.code"></el-option>
                      </el-select>
                    </template>
                  </el-table-column>
                  <el-table-column
                    property="materialCount"
                    label="数量"
                    width="80px"
                  >
                    <template slot-scope="scope">
                      <el-input size="mini" v-model="reformData.materialInfo[scope.$index].materialCount"></el-input>
                    </template>
                  </el-table-column>
                  <el-table-column
                    property="materialType"
                    :formatter="rowMaterialType"
                    label="材料类型"
                  ></el-table-column>
                  <el-table-column
                    property="materialStatus"
                    label="状态"
                    width="110"
                  >
                    <template slot-scope="scope">
                      <el-select size="mini" v-model="reformData.materialInfo[scope.$index].materialStatus">
                        <el-option label="已提供" value="PROVIDED"></el-option>
                        <el-option label="未提供" value="NOT_PROVIDED"></el-option>
                      </el-select>
                    </template>
                  </el-table-column>
                  <el-table-column
                    property="raiseTime"
                    label="提出时间"
                    width="160"
                  >
                    <template slot-scope="scope">
                      <el-date-picker
                        style="width: 100%"
                        size="mini"
                        value-format="timestamp"
                        v-model="reformData.materialInfo[scope.$index].raiseTime"
                        placeholder="选择日期"
                      >
                      </el-date-picker>
                    </template>
                  </el-table-column>
                  <el-table-column
                    property="promiseTime"
                    label="承诺时间"
                    width="160"
                  >
                    <template slot-scope="scope">
                      <el-date-picker
                        style="width: 100%"
                        size="mini"
                        value-format="timestamp"
                        v-model="reformData.materialInfo[scope.$index].promiseTime"
                        placeholder="选择日期"
                      >
                      </el-date-picker>
                    </template>
                  </el-table-column>
                  <el-table-column
                    property="deliveryTime"
                    label="送达时间"
                    width="160"
                  >
                    <template slot-scope="scope">
                      <el-date-picker
                        style="width: 100%"
                        size="mini"
                        value-format="timestamp"
                        v-model="reformData.materialInfo[scope.$index].deliveryTime"
                        placeholder="选择日期"
                      >
                      </el-date-picker>
                    </template>
                  </el-table-column>
                  <el-table-column
                    property="materialRemark"
                    label="备注"
                    width="150"
                  >
                    <template slot-scope="scope">
                      <el-input
                        type="textarea"
                        size="mini"
                        autosize
                        v-model="reformData.materialInfo[scope.$index].materialRemark"
                      ></el-input>
                    </template>
                  </el-table-column>
                </Table>
                <div style="margin-top:10px">
                  <el-button @click="addMaterial" size="mini">点击添加新材料</el-button>
                </div>
              </el-tab-pane>
              <!-- 费用信息整改-->
              <el-tab-pane label="费用信息整改" name="feelInformation">
                <Table
                  :tableData="reformData.feeItemInfo" style="width: 100%"
                >
                  <el-table-column
                    width="50">
                    <template slot-scope="scope">
                        <span>
                          <i class="el-icon-remove" style="color: red;font-size: 20px"
                             @click="delFee(scope.row.itemId)"></i>
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
                      <el-input size="mini" v-model="reformData.feeItemInfo[scope.$index].beforeContent"></el-input>
                    </template>
                  </el-table-column>
                  <el-table-column
                    property="afterContent"
                    label="增值内容（处理后）"
                    width="150px"
                  >
                    <template slot-scope="scope">
                      <el-input size="mini" v-model="reformData.feeItemInfo[scope.$index].afterContent"></el-input>
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
                      <el-input size="mini" v-model="reformData.feeItemInfo[scope.$index].itemCount"
                                @change="calcAmount(scope.$index)"></el-input>
                    </template>
                  </el-table-column>
                  <el-table-column
                    property="itemAmount"
                    label="总价"
                  >
                    <template slot-scope="scope">
                      {{reformData.feeItemInfo[scope.$index].itemAmount}}
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
                      <el-input size="mini" v-model="reformData.feeItemInfo[scope.$index].itemProfit"></el-input>
                    </template>
                  </el-table-column>
                </Table>
                <div style="margin-top:10px">
                  <el-button @click="addFeel" size="mini">点击添加新费用科目</el-button>
                </div>
              </el-tab-pane>
            </el-tabs>
          </el-card>
          <el-form-item style="margin-top: 20px;margin-left: 250px">
            <el-button @click="reformVisible=false">取消</el-button>
            <el-button @click="submitReformForm('reformForm')">提交审批</el-button>
          </el-form-item>
        </el-form>
      </Dialog>

      <!-- 材料选择-->
      <Dialog
        :title="'请选择材料'"
        :show.sync="materialFormVisible"
        @closedDialog="searchKey.input='';search.input='';">
        <div>
          <el-row>
            <el-col>
              <el-input v-model="search.input" style="width: 300px" size="mini"></el-input>
              <el-button size="mini" @click="handleSearchMaterial(search.input)">搜索</el-button>
            </el-col>
          </el-row>
          <Split></Split>
          <el-row>
            <el-col>
              <Table
                :tableData="materialTableData" style="width: 100%"
              >
                <el-table-column
                  property="materialName"
                  label="材料名称"
                  width="">
                </el-table-column>
                <!--                  <el-table-column-->
                <!--                    property="materialBelong"-->
                <!--                    label="材料归属"-->
                <!--                    :formatter="rowMaterialBelong"-->
                <!--                    width="">-->
                <!--                  </el-table-column>-->
                <el-table-column
                  property="materialType"
                  label="材料类型"
                  :formatter="rowMaterialType"
                  width="">
                </el-table-column>
                <el-table-column
                  property="operator"
                  label="操作"
                  width="200px">
                  <template slot-scope="scope">
                    <el-button @click="selectMaterial(scope.row.materialId)" type="text" size="small">选择</el-button>
                  </template>
                </el-table-column>
              </Table>
            </el-col>
          </el-row>
        </div>
      </Dialog>

      <!--选择费用材料-->
      <Dialog
        :title="'请选择材料'"
        :show.sync="feeFormVisible"
        @closedDialog="searchKey.input='';search.input='';">
        <div>
          <el-row>
            <el-col>
              <el-input v-model="search.input" style="width: 300px" size="mini"></el-input>
              <el-button size="mini" @click="handleSearchFee(search.input)">搜索</el-button>
            </el-col>
          </el-row>
          <Split></Split>
          <el-row>
            <el-col>
              <Table
                :tableData="feeTableData" style="width: 100%"
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
                    <el-button @click="selectFee(scope.row.itemId)" type="text" size="small">选择</el-button>
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
  import Table from '../../../components/table/Table';
  import Split from '../../../components/split/Split';
  import Dialog from '../../../components/dialog/Dialog';
  import CaseView from '../../caseview/CaseView';

  export default {
    name: "WorkBench",
    components: {
      Table, Dialog, Split, CaseView
    },
    data() {
      return {
        hasNewWait: false,
        tableWaitData: [],
        searchWait: {
          pageType: "1",
          ifClose: '2',
          activeNames: '1',
        },
        waitPageInfo: {
          pageIndex: "1",
          pageSize: "5",
          totalItems: "0",
          totalPages: "0",
          offSet: "0"
        },
        searchAll: {
          pageType: "3",
          ifClose: '1'
        },
        tableData: [],
        allPageInfo: {
          pageIndex: "1",
          pageSize: "5",
          totalItems: "0",
          totalPages: "0",
          offSet: "0"
        },
        //风控审核
        fengKongCheckVisible: false, //风控审核 模态框
        fengKongCheckForm: this.fengKongCheckDemoForm(),

        //提交
        approvalVisible: false,
        approvalTableData: [],
        approvalForm: this.approvalDemoForm(),
        flowForm: this.flowDemoForm(),
        //审核
        reviewVisible: false,
        //收件
        submitVisible: false,
        //查看
        caseView: {
          seeVisible: false,
          caseSubType: '',
          _t: new Date(),
          caseId: '',
        },
        //整改
        reformVisible: false,
        reformData: this.reformDemoData(),
        reformActiveName: 'loanInformation',
        materialTableData: [],
        materialFormVisible: false,
        search: {
          input: ''
        },
        searchKey: {
          input: ''
        },
        feeTableData: [],
        feeFormVisible: false,
        caseCountData: {},
      }
    },
    mounted() {
      this.getWaitData();
      this.getData();
      // this.getCaseCountData();
    },
    methods: {
      getCaseCountData() {
        let vm = this;
        vm.$api.getCasesCountBlock({
          type: '1'
        }).then(res => {
          if ("200" === res.status) {
            vm.caseCountData = res.data;
          }
        })
      },
      getWaitData(currentPage = '1', pageSize = '5') {
        let vm = this;
        vm.waitPageInfo.pageIndex = currentPage;
        vm.waitPageInfo.pageSize = pageSize;
        vm.$api.getCaseList({
          pageType: '1',
          // ifClose: '1',
          pageNum: vm.waitPageInfo.pageIndex,
          pageSize: vm.waitPageInfo.pageSize,
        }).then(res => {
          if (vm.waitPageInfo.pageIndex !== '1' && res.data === null && res.data === []) {
            vm.getWaitData('1');
          }
          vm.tableWaitData = res.data;
          vm.waitPageInfo = res.pageInfo;
          vm.getCaseCountData();
        })
      },
      getData(currentPage = '1', pageSize = '5') {
        let vm = this;
        vm.allPageInfo.pageIndex = currentPage;
        vm.allPageInfo.pageSize = pageSize;
        vm.$api.getCaseList({
          pageType: vm.searchAll.pageType,
          ifClose: vm.searchAll.ifClose,
          pageNum: vm.allPageInfo.pageIndex,
          pageSize: vm.allPageInfo.pageSize,
        }).then(res => {
          if (vm.allPageInfo.pageIndex !== '1' && res.data === null && res.data === []) {
            vm.getData('1');
          }
          vm.tableData = res.data;
          vm.allPageInfo = res.pageInfo;
          vm.getCaseCountData();
        })
      }, //翻页
      currentChange(currentPage) {
        let vm = this;
        vm.getData(currentPage, vm.allPageInfo.pageSize)
      },
      currentWaitChange(currentPage) {
        let vm = this;
        vm.getWaitData(currentPage, vm.waitPageInfo.pageSize)
      },
      sizeChange(pageSize) {
        let vm = this;
        vm.getData(vm.allPageInfo.pageIndex, pageSize)
      },
      sizeWaitChange(pageSize) {
        let vm = this;
        vm.getWaitData(vm.waitPageInfo.pageIndex, pageSize)
      },
      refresh() {
        let vm = this;
        vm.getData(vm.allPageInfo.pageIndex, vm.allPageInfo.pageSize);
      },
      refreshWaitData() {
        let vm = this;
        vm.hasNewWait = false;
        vm.getWaitData(vm.waitPageInfo.pageIndex, vm.waitPageInfo.pageSize);
      },
      pageTypeAll(pageType) {
        let vm = this;
        vm.searchAll.pageType = pageType;
        vm.getData(vm.allPageInfo.pageIndex, vm.allPageInfo.pageSize);
      },
      addCase() {
        this.$router.push({path: `/case/caseDetail/basicInformation/0`});
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
          case 'MODIFY':  //修改 -- 跳转到基本页面
            vm.$router.push({
              path: `/case/caseDetail/basicInformation/${caseId}`,
              query: {
                caseSubType: caseSubType    //判断是一手房还是二手房
              }
            });
            break;
          case 'SUBMIT':  //提交
            vm.approvalForm.caseId = caseId;
            vm.approvalForm.operateType = code;
            vm.$api.listRoleUser({roleDict: 'R0301'}).then(res => {
              vm.approvalTableData = res.data;
              vm.approvalVisible = true;
            });
            break;
          case 'FENGKONG_CHECK':  //风控审核
            //获取审批银行
            vm.fengKongCheckForm.caseId = caseId;
            vm.fengKongCheckForm.operateType = code;
            vm.$api.getBranchInfo({caseId}).then(res => {
              vm.fengKongCheckForm = {...vm.fengKongCheckForm, ...res.data};
            });
            // 风控审核时需要选择财务人员
            vm.$api.listRoleUser({roleDict: 'R0401'}).then(res => {
              vm.fengKongCheckForm = {...vm.fengKongCheckForm, nextOperatorOptions: res.data};
            });
            vm.fengKongCheckVisible = true;
            break;
          case 'CAIWU_CHECK': //财务审核
            vm.flowForm.caseId = caseId;
            vm.flowForm.operateType = code;
            vm.flowForm.dialogTitle = '财务审核';
            // 财务审核时需要选择外勤人员
            vm.$api.listRoleUser({roleDict: 'R0601'}).then(res => {
              vm.flowForm = {...vm.flowForm, nextOperatorOptions: res.data};
            });
            vm.reviewVisible = true;
            break;
          case 'CAIWU_REFORM': //财务整改
            vm.$api.getCaseReformInfo({caseId}).then(res => {
              vm.reformData.operateType = code;
              vm.reformData = {...vm.reformData, ...res.data};
              vm.reformData.caseSelect = [vm.reformData.caseType, vm.reformData.caseSubType];
              vm.reformData.LoanTypeSelect = [vm.reformData.loanInfo.loanType, vm.reformData.loanInfo.loanSubType];
              vm.reformVisible = true;
            });
            break;
          case 'FENGKONG_REFORM': //风控整改
            vm.$api.getCaseReformInfo({caseId}).then(res => {
              vm.reformData.operateType = code;
              vm.reformData = {...vm.reformData, ...res.data};
              vm.reformData.caseSelect = [vm.reformData.caseType, vm.reformData.caseSubType];
              vm.reformData.LoanTypeSelect = [vm.reformData.loanInfo.loanType, vm.reformData.loanInfo.loanSubType];
              vm.reformVisible = true;
            });
            break;
          case 'BANK_REFORM': //银行整改
            vm.$api.getCaseReformInfo({caseId}).then(res => {
              vm.reformData.operateType = code;
              vm.reformData = {...vm.reformData, ...res.data};
              vm.reformData.caseSelect = [vm.reformData.caseType, vm.reformData.caseSubType];
              vm.reformData.LoanTypeSelect = [vm.reformData.loanInfo.loanType, vm.reformData.loanInfo.loanSubType];
              vm.reformVisible = true;
            });
            break;
          case 'FIELD_RECEVING': //财务审核通过后的外勤收件
            vm.fillFlowForm(caseId, code, '确定收件吗？');
            break;
          case 'FIELD_RECEIVED':  //财务审核通过后的外勤送达
            vm.fillFlowForm(caseId, code, '确定送达吗？');
            break;
          case 'INTERVIEW_APPOINTMENT':  //预约面签
            vm.fillFlowForm(caseId, code, '确定预约面签吗？');
            break;
          case 'BANK_INTERVIEW':  //面签
            vm.fillFlowForm(caseId, code, '确定面签吗？');
            break;
          case 'BANK_CHECK_COMMERCIAL':  // 贷款审批 商业
            vm.fillFlowForm(caseId, code, '确定商业贷款审批吗？');
            break;
          case 'CHECK_COMMERCIAL_PASS':  // 审批通过 商业
            vm.fillReviewForm(caseId, code, '确定商业贷款审批通过吗？');
            break;
          case 'BANK_CHECK_RESERVE':  // 贷款审批 公积金
            vm.fillFlowForm(caseId, code, '确定公积金贷款审批吗？');
            break;
          case 'CHECK_RESERVE_PASS':  // 审批通过 公积金
            vm.fillReviewForm(caseId, code, '确定公积金贷款审批通过吗？');
            break;
          case 'PICK_UP_CASE':  //批复取件
            vm.fillFlowForm(caseId, code, '确定取件吗？');
            break;
          case 'TRANSFER_APPOINTMENT':  //预约过户
            vm.fillFlowForm(caseId, code, '确定预约过户吗？');
            break;
          case 'TRANSFER_MORTGAGE':  //过户抵押
            vm.fillFlowForm(caseId, code, '确定过户吗？');
            break;
          case 'MORTGAGE_RECEVING':  //抵押出件
            vm.fillFlowForm(caseId, code, '确定抵押出件吗？');
            break;
          case 'SEND_OFF_LOANS':  //送行放款
            vm.fillFlowForm(caseId, code, '确定送行放款吗？');
            break;
          case 'MAKE_LOAN':  //银行放款
            vm.fillFlowForm(caseId, code, '确定放款吗？');
            break;
          case 'CAIWU_REVIEW':  //财务复核
            vm.fillFlowForm(caseId, code, '确定财务复核通过吗？');
            break;
          case 'CUSTOMER_RECEVING':  //客户取件
            vm.fillFlowForm(caseId, code, '确定客户取件吗？');
            break;
          case 'ARCHIVE_CASE':  //归档
            vm.fillFlowForm(caseId, code, '确定归档吗？');
            break;
          default:
            return;
        }
      },
      fillFlowForm(caseId, code, title) {
        let vm = this;
        vm.flowForm.caseId = caseId;
        vm.flowForm.operateType = code;
        vm.flowForm.dialogTitle = title;
        vm.submitVisible = true;
      },
      fillReviewForm(caseId, code, title) {
        let vm = this;
        vm.flowForm.caseId = caseId;
        vm.flowForm.operateType = code;
        vm.flowForm.dialogTitle = title;
        vm.reviewVisible = true;
      },
      approvalDemoForm() {
        return {
          caseId: '',
          operateType: '',
          operateResult: '',
          nextOperatorId: '',
          operateRemark: ''
        }
      },
      fengKongCheckDemoForm() {  //风控提交表单
        return {
          caseId: "",
          operateType: "",
          operateResult: "",
          nextOperatorId: "",
          operateRemark: "",
          branchName: "",
          branchId: '',
          managerName: "",
          managerPhone: "",
          branchInfos: []
        }
      },
      flowDemoForm() {  //流程提交表单
        return {
          caseId: "",
          operateType: "",
          operateResult: "",
          nextOperatorId: "",
          operateRemark: "",
          dialogTitle: '',
          nextOperatorOptions: '',
        }
      },
      reformDemoData() {
        return {
          caseId: "",
          caseType: "",
          caseSubType: "",
          reformSource: "",
          reformRemark: "",
          operateType: "",
          loanInfo: {
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
            loanBankBranch: "",
            createTime: "",
            modifyTime: ""
          },
          materialInfo: [
            {
              materialStatus: "",
              materialName: "",
              materialRemark: "",
              deliveryTime: "",
              materialType: "",
              raiseTime: "",
              promiseTime: "",
              index: "",
              createUser: "",
              materialId: "",
              materialCount: "",
              materialBelong: ""
            }
          ],
          feeItemInfo: [
            {
              itemId: "",
              itemName: "",
              itemAmount: "",
              afterContent: "",
              index: "",
              itemPrice: "",
              optional: "",
              itemProfit: "",
              itemDesc: "",
              itemRate: "",
              beforeContent: "",
              itemCount: ""
            }
          ],
          caseSelect: [],
          LoanTypeSelect: [],
        }
      },
      changeBranch(branchId) {
        let vm = this;
        vm.fengKongCheckForm.branchInfos.forEach(branch => {
          if (branch.branchId == branchId) {
            vm.fengKongCheckForm.branchName = branch.branchName;
            vm.fengKongCheckForm.managerName = branch.managerName;
            vm.fengKongCheckForm.managerPhone = branch.managerPhone;
          }
        });
      },
      fengKongCheckSubmit(formName) {
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          vm.$api.drivingProcessForCheck(vm.fengKongCheckForm).then(res => {
            vm.$message.success(res.msg);
            vm.fengKongCheckVisible = false;
            this.getWaitData();
            this.getData();
          })
        }
      },
      selectUser(index, row) {
        let vm = this;
        vm.approvalForm.nextOperatorId = '';
        vm.approvalForm.nextOperatorId = row.userId;
      },
      submit() {  //风控提交
        let vm = this;
        vm.$api.drivingProcess(vm.approvalForm).then(res => {
          vm.approvalVisible = false;
          this.$message.success(res.msg);
          this.getWaitData();
          this.getData();
        })
      },
      flowSubmit(formName, visibleName) {  //流程提交
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          vm.$api.drivingProcess(vm.flowForm).then(res => {
            vm[visibleName] = false;
            this.$message.success(res.msg);
            this.getWaitData();
            this.getData();
          })
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
      //删除材料
      delMaterial(materialId) {
        let vm = this;
        vm.reformData.materialInfo = vm.$util.ArrayFn.delObjArr(vm.reformData.materialInfo, materialId, 'materialId');
      },
      //新增材料
      addMaterial() {
        let vm = this;
        vm.$api.materialsList({
          materialName: vm.searchKey.input,
          materialBelong: "",
          pageNum: 1,
          pageSize: 99999,
        }).then(res => {
          vm.materialTableData = res.data;
          vm.materialFormVisible = true;
        })
      },
      //材料搜索
      handleSearchMaterial(input) {
        let vm = this;
        vm.searchKey.input = input;
        vm.addMaterial();
      },
      selectMaterial(materialId) {
        let vm = this;
        vm.$api.getSingleMaterial({materialId}).then(res => {
          // let lenOld = vm.reformData.materialInfo.length;
          vm.reformData.materialInfo.push(res.data);
          // vm.reformData.materialInfo = vm.$util.ArrayFn.arrObjUnique(vm.reformData.materialInfo, 'materialId');
          // let lenNew = vm.reformData.materialInfo.length;
          // if (lenOld == lenNew) {
          //   vm.$message.info('该材料已存在！');
          // }
        });
        vm.materialFormVisible = false;
      },
      addFeel() {
        let vm = this;
        vm.$api.feelsList({
          itemName: vm.searchKey.input,
          pageNum: 1,
          pageSize: 99999,
        }).then(res => {
          vm.feeTableData = res.data;
          vm.feeFormVisible = true;
        })
      },
      handleSearchFee(input) {
        let vm = this;
        vm.searchKey.input = input;
        vm.addFeel();
      },
      selectFee(itemId) {
        let vm = this;
        vm.$api.getSingleFeeItem({itemId}).then(res => {
          let lenOld = vm.reformData.feeItemInfo.length;
          vm.reformData.feeItemInfo.push(res.data);
          vm.reformData.feeItemInfo = vm.$util.ArrayFn.arrObjUnique(vm.reformData.feeItemInfo, 'itemId');
          let lenNew = vm.reformData.feeItemInfo.length;
          if (lenOld == lenNew) {
            vm.$message.info('该费用科目已存在！');
          }
        });
        vm.feeFormVisible = false;
      },
      delFee(itemId) {
        let vm = this;
        vm.reformData.feeItemInfo = vm.$util.ArrayFn.delObjArr(vm.reformData.feeItemInfo, itemId, 'itemId');
      },
      calcAmount(index) {
        let vm = this;
        vm.reformData.feeItemInfo[index].itemAmount = vm.changeTwoDecimal(parseFloat(vm.reformData.feeItemInfo[index].itemCount) * parseFloat(vm.reformData.feeItemInfo[index].itemPrice));
      },
      //整改提交
      submitReformForm(formName) {
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          vm.$api.drivingProcessForReform(vm.reformData).then(res => {
            vm.$message.success(res.msg);
            vm.reformVisible = false;
            this.getWaitData();
            this.getData();
          })
        }
      }
    },
    watch: {
      'reformData.caseSelect'(newVal, oldVal) {
        let vm = this;
        vm.reformData.caseType = newVal[0];
        vm.reformData.caseSubType = newVal[1];
      },
      'reformData.LoanTypeSelect'(newVal, oldVal) {
        let vm = this;
        vm.reformData.loanInfo.loanType = newVal[0];
        vm.reformData.loanInfo.loanSubType = newVal[1];
        console.log(vm.reformData.loanInfo.loanType);
      },
    },
    sockets: {
      messageNotify(data) {
        let vm = this;
        vm.hasNewWait = true;
      }
    },
  }
</script>

<style lang='scss' scoped>
  .WorkBench {
    width: 100%;

    .top {
      .left, .right {
        margin: 5px;
      }
    }

    .middle {
      margin: 0 5px 5px 5px;
    }

    .bottom {
      margin: 5px;
    }

    .case-table {
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
    }

    .item-detail {
      height: 80px;
      text-align: center;
      /*font-weight: 700;*/
      box-sizing: border-box;
      padding-top: 25px;
    }

    .el-card {
      /deep/ .el-card__header {
        padding: 5px;

        /deep/ .el-button {
          padding: 5px 5px;
        }

        .el-radio {
          /deep/ .el-radio__label {
            font-size: 12px;
          }
        }
      }

      /deep/ .el-card__body {
        padding: 1px 1px 1px 1px;

        .pagination {
          margin-top: 5px;
          text-align: center;
        }
      }
    }

  }
</style>
