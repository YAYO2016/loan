<template>
  <div class='OverView' v-if="overViewData">
    <el-form ref="form" :model="overViewData" size="mini" label-width="105px">
      <div class="title">
        <el-row>
          <el-col :span="24">
            <el-form-item label="案子类型：">
              <el-cascader
                v-model="caseSelect"
                placeholder="选择案子"
                :options="$store.state.caseOptions"
                :props="{value: 'code',label: 'desc',children: 'children'}"
                disabled
              ></el-cascader>
            </el-form-item>
          </el-col>
        </el-row>
      </div>
      <!--贷款信息-->
      <div class="item-information">
        <!-- 一手 -->
        <div v-if="caseSubType === 'NEW_HOUSE'">
          <el-card>
            <div slot="header" class="clearfix">
              <span>贷款信息</span>
            </div>
            <div>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="贷款类型：">
                    <el-cascader
                      v-model="LoanTypeSelect"
                      disabled
                      placeholder="选择贷款类型"
                      :options="$store.state.loanTypeOptions"
                      :props="{value: 'code',label: 'desc',children: 'children'}"
                      filterable
                    ></el-cascader>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="还款方式：">
                    <el-select v-model="overViewData.loanInfo.repaymentType" disabled>
                      <el-option v-for="item in $store.state.repaymentTypeOptions" :value="item.code" :label="item.desc"
                                 :key="item.code"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row v-if="overViewData.loanInfo.loanType === 'RESERVE' || overViewData.loanInfo.loanType === 'SYNDICATED'">
                <el-col :span="8">
                  <el-form-item label="贷款金额(公)：">
                    {{overViewData.loanInfo.reserveAmount}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="贷款年限(公)：">
                    {{overViewData.loanInfo.reserveYear}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row v-if="overViewData.loanInfo.loanType === 'COMMERCIAL' || overViewData.loanInfo.loanType === 'SYNDICATED'">
                <el-col :span="8">
                  <el-form-item label="贷款金额(商)：">
                    {{overViewData.loanInfo.commercialAmount}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="贷款年限(商)：">
                    {{overViewData.loanInfo.commercialYear}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="放款条件：">
                    <el-select v-model="overViewData.loanTerms" disabled>
                      <el-option v-for="item in $store.state.loanTermOptions" :value="item.code" :label="item.desc"
                                 :key="item.code"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="贷款银行：">
                    <el-select v-model="overViewData.loanInfo.loanBank" disabled>
                      <el-option
                        v-for="item in $store.state.banksOptions"
                        :key="item.bankId"
                        :label="item.bankName"
                        :value="item.bankId">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="还款账号：">
                    {{overViewData.loanInfo.repaymentAccount}}
                  </el-form-item>
                </el-col>
              </el-row>
            </div>
          </el-card>
        </div>
        <!-- 二手 -->
        <div v-else-if="caseSubType === 'SECOND_HAND_HOUSE'">
          <el-card>
            <div slot="header" class="clearfix">
              <span>贷款信息</span>
            </div>
            <div>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="贷款类型：">
                    <el-cascader
                      v-model="LoanTypeSelect"
                      disabled
                      placeholder="选择贷款类型"
                      :options="$store.state.loanTypeOptions"
                      :props="{value: 'code',label: 'desc',children: 'children'}"
                      filterable
                    ></el-cascader>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row v-if="overViewData.loanInfo.loanType === 'RESERVE' || overViewData.loanInfo.loanType === 'SYNDICATED'">
                <el-col :span="12">
                  <el-form-item label="贷款金额(公)：">
                    {{overViewData.loanInfo.reserveAmount}}
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="贷款年限(公)：">
                    {{overViewData.loanInfo.reserveYear}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row v-if="overViewData.loanInfo.loanType === 'COMMERCIAL' || overViewData.loanInfo.loanType === 'SYNDICATED'">
                <el-col :span="8">
                  <el-form-item label="贷款金额(商)：">
                    {{overViewData.loanInfo.commercialAmount}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="贷款年限(商)：">
                    {{overViewData.loanInfo.commercialYear}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="12">
                  <el-form-item label="还款方式：">
                    <el-select v-model="overViewData.loanInfo.repaymentType" disabled>
                      <el-option v-for="item in $store.state.repaymentTypeOptions" :value="item.code" :label="item.desc"
                                 :key="item.code"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="贷款银行：">
                    <el-select v-model="overViewData.loanInfo.loanBank" disabled>
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
                <el-col :span="12" v-if="overViewData.loanInfo.loanBranch">
                  <el-form-item label="审批银行：">
                    {{overViewData.loanInfo.loanBranch.branchName}}
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="还款账号：">
                    {{overViewData.loanInfo.repaymentAccount}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="12" v-if="overViewData.loanInfo.loanBranch">
                  <el-form-item label="审批银行客户经理：">
                    {{overViewData.loanInfo.loanBranch.managerName}}
                  </el-form-item>
                </el-col>
                <el-col :span="12" v-if="overViewData.loanInfo.loanBranch">
                  <el-form-item label="审批银行客户经理电话：" label-width="170px">
                    {{overViewData.loanInfo.loanBranch.managerPhone}}
                  </el-form-item>
                </el-col>
              </el-row>
            </div>
          </el-card>
        </div>
      </div>
      <!--房产信息-->
      <div v-if="caseSubType === 'NEW_HOUSE' && overViewData.newHouseInfo">
        <!-- 一手 -->
        <div class="item-information">
          <el-card>
            <div slot="header" class="clearfix">
              <span>房产信息</span>
            </div>
            <div>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="房产类型：">
                    <el-select v-model="overViewData.newHouseInfo.houseProperty" disabled>
                      <el-option v-for="item in $store.state.houseOptions" :value="item.code" :label="item.desc"
                                 :key="item.code"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="契约号：">
                    {{overViewData.newHouseInfo.contractCode}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="房产地址：">
                    {{overViewData.newHouseInfo.houseAddress}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="房产面积：">
                    {{overViewData.newHouseInfo.houseArea}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="契约总价：">
                    {{overViewData.newHouseInfo.contractAmount}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="契约单价：">
                    {{overViewData.newHouseInfo.contractPrice}}
                  </el-form-item>
                </el-col>
              </el-row>

            </div>
          </el-card>
        </div>
      </div>
      <div v-else-if="caseSubType === 'SECOND_HAND_HOUSE' && overViewData.secondHandHouseInfo">
        <!--二手-->
        <div class="item-information">
          <el-card>
            <div slot="header" class="clearfix">
              <span>房产信息（交易前）</span>
            </div>
            <div>
              <el-row>
                <el-col :span="12">
                  <el-form-item label="房产类型：">
                    <el-select v-model="overViewData.secondHandHouseInfo.houseProperty" disabled>
                      <el-option v-for="item in $store.state.houseOptions" :value="item.code" :label="item.desc"
                                 :key="item.code"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="房产地址：">
                    {{overViewData.secondHandHouseInfo.pretradeHouseAddr}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="6">
                  <el-form-item label="交易方式：">
                    <el-select v-model="overViewData.secondHandHouseInfo.superviseType" disabled>
                      <el-option v-for="item in $store.state.superviseTypeOptions" :value="item.code" :label="item.desc"
                                 :key="item.code"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="房产面积：">
                    {{overViewData.secondHandHouseInfo.pretradeArea}}
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="建筑楼层：">
                    {{overViewData.secondHandHouseInfo.pretradeFloor}}
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="建筑年代：">
                    {{overViewData.secondHandHouseInfo.pretradeAge}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="6">
                  <el-form-item label="网签价格：">
                    {{overViewData.secondHandHouseInfo.pretradeNetPrice}}
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="成交单价：">
                    {{overViewData.secondHandHouseInfo.pretradeUnitPrice}}
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="成交总价：">
                    {{overViewData.secondHandHouseInfo.pretradePrice}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row v-if="overViewData.secondHandHouseInfo.propertyRightsType === 'REAL_ESTATE'">
                <el-col :span="24">
                  <el-form-item label="不动产证号：">
                    {{overViewData.secondHandHouseInfo.pretradeBdc}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row v-else>
                <el-col :span="12">
                  <el-form-item label="产权证号：">
                    {{overViewData.secondHandHouseInfo.pretradeCqz}}
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="土地证号：">
                    {{overViewData.secondHandHouseInfo.pretradeTdz}}
                  </el-form-item>
                </el-col>
              </el-row>
            </div>
          </el-card>
        </div>
        <div class="item-information">
          <el-card>
            <div slot="header" class="clearfix">
              <span>房产信息（交易后）</span>
            </div>
            <div>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="房产地址：">
                    {{overViewData.secondHandHouseInfo.afttradeBdcArea}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="不动产号：">
                    {{overViewData.secondHandHouseInfo.afttradeBdc}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="计税价格：">
                    {{overViewData.secondHandHouseInfo.afttradeJsdj}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="过户单价：">
                    {{overViewData.secondHandHouseInfo.afttradeGhdj}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="成交单价：">
                    {{overViewData.secondHandHouseInfo.afttradeUnitPrice}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="契税单号：">
                    {{overViewData.secondHandHouseInfo.afttradeQsd}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="增值税单号：">
                    {{overViewData.secondHandHouseInfo.afttradeZzsd}}
                  </el-form-item>
                </el-col>
              </el-row>
            </div>
          </el-card>
        </div>
      </div>
      <!--主贷人信息-->
      <div class="item-information">
        <el-card>
          <div slot="header" class="clearfix">
            <span>主贷人信息</span>
          </div>
          <div>
            <el-row>
              <el-col :span="8">
                <el-form-item label="主贷姓名：">
                  {{overViewData.buyerCustInfo.custName}}
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="证件类型：">
                  <el-select v-model="overViewData.buyerCustInfo.idType" disabled>
                    <el-option v-for="item in $store.state.idTypeOptions" :value="item.code" :label="item.desc"
                               :key="item.code"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="证件号码：">
                  {{overViewData.buyerCustInfo.idNo}}
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="移动电话：">
                  {{overViewData.buyerCustInfo.mobilePhone}}
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="家庭电话：">
                  {{overViewData.buyerCustInfo.landPhone}}
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="单位电话：">
                  {{overViewData.buyerCustInfo.coPhone}}
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="单位性质：">
                  <el-select v-model="overViewData.buyerCustInfo.coType" disabled>
                    <el-option v-for="item in $store.state.coTypeOptions" :value="item.code" :label="item.desc"
                               :key="item.code"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="职业性质：">
                  <el-select v-model="overViewData.buyerCustInfo.occuType" disabled>
                    <el-option v-for="item in $store.state.occuTypeOptions" :value="item.code" :label="item.desc"
                               :key="item.code"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收入金额：">
                  {{overViewData.buyerCustInfo.amountValue}}
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :sapn="24">
                <el-form-item label="工作单位：">
                  {{overViewData.buyerCustInfo.coName}}
                </el-form-item>
              </el-col>
            </el-row>
          </div>
        </el-card>
      </div>
      <!--共还人信息-->
      <div class="item-information" v-if="overViewData.buyerCustInfo.otherCusts.length > 0">
        <el-card>
          <div slot="header" class="clearfix">
            <span>共还人信息</span>
          </div>
          <div>
            <el-tabs type="card" v-model="editableTabsValue">
              <el-tab-pane v-for="(item,index) in overViewData.buyerCustInfo.otherCusts" :name="index+1+''"
                           :label="'共还人'+(index+1)"
                           :key="index+1+''">
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="与主贷人关系：">
                      <el-select v-model="item.custRel" disabled>
                        <el-option v-for="item in $store.state.custRelOptions" :value="item.code" :label="item.desc"
                                   :key="item.code"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="共还人姓名：">
                      {{item.custName}}
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="证件类型：">
                      <el-select v-model="item.idType" disabled>
                        <el-option v-for="item in $store.state.idTypeOptions" :value="item.code" :label="item.desc"
                                   :key="item.code"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="证件号码：">
                      {{item.idNo}}
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="移动电话：">
                      {{item.mobilePhone}}
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="单位电话：">
                      {{item.coPhone}}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="单位性质：">
                      <el-select v-model="item.coType" disabled>
                        <el-option v-for="item in $store.state.coTypeOptions" :value="item.code" :label="item.desc"
                                   :key="item.code"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="职业性质：">
                      <el-select v-model="item.occuType" disabled>
                        <el-option v-for="item in $store.state.occuTypeOptions" :value="item.code" :label="item.desc"
                                   :key="item.code"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="收入金额：">
                      {{item.amountValue}}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :sapn="24">
                    <el-form-item label="工作单位：">
                      {{item.coName}}
                    </el-form-item>
                  </el-col>
                </el-row>
              </el-tab-pane>
            </el-tabs>
          </div>
        </el-card>
      </div>
      <!--开发商信息-->
      <div v-if="caseSubType === 'NEW_HOUSE' && overViewData.cfgInfo.developerInfo">
        <div class="item-information">
          <el-card>
            <div slot="header" class="clearfix">
              <span>开发商信息</span>
            </div>
            <div>
              <el-row>
                <el-col :span="8">
                  <el-form-item label='开发商：'>
                    {{overViewData.cfgInfo.developerInfo.developerName}}
                  </el-form-item>
                </el-col>
                <el-col :span="16">
                  <el-form-item label='开发商地址：'>
                    {{overViewData.cfgInfo.developerInfo.developerAddr}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label='开发商电话：'>
                    {{overViewData.cfgInfo.developerInfo.developerTel}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label='财务负责人：'>
                    {{overViewData.cfgInfo.developerInfo.financeName}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label='联系方式：'>
                    {{overViewData.cfgInfo.developerInfo.financeTel}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label='监管账户：'>
                    {{overViewData.cfgInfo.developerInfo.accountNo}}
                  </el-form-item>
                </el-col>
                <el-col :span="16">
                  <el-form-item label='开户行：'>
                    {{overViewData.cfgInfo.developerInfo.accountBank}}
                  </el-form-item>
                </el-col>
              </el-row>
            </div>
          </el-card>
        </div>
      </div>
      <!--楼盘信息-->
      <div v-if="caseSubType === 'NEW_HOUSE' && overViewData.cfgInfo.estateInfo">
        <div class="item-information">
          <el-card>
            <div slot="header" class="clearfix">
              <span>楼盘信息</span>
            </div>
            <div>
              <el-row>
                <el-col :span="8">
                  <el-form-item label='楼盘名称：'>
                    {{overViewData.cfgInfo.estateInfo.estateName}}
                  </el-form-item>
                </el-col>
                <el-col :span="16">
                  <el-form-item label='楼盘地址：'>
                    {{overViewData.cfgInfo.estateInfo.estateAddr}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label='楼盘电话：'>
                    {{overViewData.cfgInfo.estateInfo.estateTel}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label='楼盘负责人：'>
                    {{overViewData.cfgInfo.estateInfo.managerName}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label='联系方式：'>
                    {{overViewData.cfgInfo.estateInfo.managerTel}}
                  </el-form-item>
                </el-col>
              </el-row>
            </div>
          </el-card>
        </div>
      </div>
      <!--楼盘销售人员信息-->
      <div v-if="caseSubType === 'NEW_HOUSE' && overViewData.cfgInfo.estateSalesmanInfo">
        <div class="item-information">
          <el-card>
            <div slot="header" class="clearfix">
              <span>楼盘销售人员信息</span>
            </div>
            <div>
              <el-row>
                <el-col :span="8">
                  <el-form-item label='销售员：'>
                    {{overViewData.cfgInfo.estateSalesmanInfo.salesmanName}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label='手机：'>
                    {{overViewData.cfgInfo.estateSalesmanInfo.salesmanTel}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label='办公电话：'>
                    {{overViewData.cfgInfo.estateSalesmanInfo.officeTel}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label='账户名：'>
                    {{overViewData.cfgInfo.estateSalesmanInfo.accountName}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label='开户行：'>
                    {{overViewData.cfgInfo.estateSalesmanInfo.accountBank}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label='账号：'>
                    {{overViewData.cfgInfo.estateSalesmanInfo.accountNo}}
                  </el-form-item>
                </el-col>
              </el-row>
            </div>
          </el-card>
        </div>
      </div>
      <!-- 卖方信息 -->
      <div v-if="caseSubType === 'SECOND_HAND_HOUSE' && overViewData.sellerCustInfo">
        <div class="item-information">
          <el-card>
            <div slot="header" class="clearfix">
              <span>卖方信息</span>
            </div>
            <div>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="卖方姓名：">
                    {{overViewData.sellerCustInfo.custName}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="卖方证件类型：">
                    <el-select v-model="overViewData.sellerCustInfo.idType" disabled>
                      <el-option v-for="item in $store.state.idTypeOptions" :value="item.code" :label="item.desc"
                                 :key="item.code"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="卖方证件号：">
                    {{overViewData.sellerCustInfo.idNo}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="卖方联系电话：">
                    {{overViewData.sellerCustInfo.mobilePhone}}
                  </el-form-item>
                </el-col>
                <!--                <el-col :span="8">-->
                <!--                  <el-form-item label="收款人姓名：">-->
                <!--                    {{overViewData.sellerCustInfo.custName}}-->
                <!--                  </el-form-item>-->
                <!--                </el-col>-->
                <el-col :span="8">
                  <el-form-item label="收款账号：">
                    {{overViewData.sellerCustInfo.accountNo}}
                  </el-form-item>
                </el-col>
              </el-row>
            </div>
          </el-card>
        </div>
      </div>

      <!-- 共有人信息 -->
      <div v-if="caseSubType === 'SECOND_HAND_HOUSE' && overViewData.sellerCustInfo.otherCusts.length > 0">
        <div class="item-information">
          <el-card>
            <div slot="header" class="clearfix">
              <span>共有人信息</span>
            </div>
            <div>
              <el-tabs type="card" v-model="editableTabsValueSecond">
                <el-tab-pane v-for="(item,index) in overViewData.sellerCustInfo.otherCusts" :name="index+1+''"
                             :label="'共有人'+(index+1)"
                             :key="index+1+''">
                  <el-row>
                    <el-col :span="8">
                      <el-form-item label="与卖方关系：">
                        <el-select v-model="item.custRel" disabled>
                          <el-option v-for="item in $store.state.custRelOptions" :value="item.code" :label="item.desc"
                                     :key="item.code"></el-option>
                        </el-select>
                      </el-form-item>
                    </el-col>
                    <el-col :span="8">
                      <el-form-item label="共有人姓名：">
                        {{item.custName}}
                      </el-form-item>
                    </el-col>
                    <el-col :span="8">
                      <el-form-item label="共有人联系电话：">
                        {{item.mobilePhone}}
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="8">
                      <el-form-item label="证件类型：">
                        <el-select v-model="item.idType" disabled>
                          <el-option v-for="item in $store.state.idTypeOptions" :value="item.code" :label="item.desc"
                                     :key="item.code"></el-option>
                        </el-select>
                      </el-form-item>
                    </el-col>
                    <el-col :span="8">
                      <el-form-item label="共有人证件号：">
                        {{item.idNo}}
                      </el-form-item>
                    </el-col>
                  </el-row>
                </el-tab-pane>
              </el-tabs>
            </div>
          </el-card>
        </div>
      </div>

      <!-- 渠道信息 -->
      <div v-if="caseSubType === 'SECOND_HAND_HOUSE' && overViewData.cfgInfo.channelInfo">
        <div class="item-information">
          <el-card>
            <div slot="header" class="clearfix">
              <span>渠道信息</span>
            </div>
            <div>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="渠道类型：">
                    <el-select v-model="overViewData.channelType" disabled>
                      <el-option v-for="item in $store.state.channelTypeOptions" :label="item.desc" :value="item.code"
                                 :key="item.code">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="渠道名称：">
                    {{overViewData.cfgInfo.channelInfo.channelName}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="渠道电话：">
                    {{overViewData.cfgInfo.channelInfo.channelPhone}}
                  </el-form-item>
                </el-col>
                <el-col :span="16">
                  <el-form-item label="渠道地址：">
                    {{overViewData.cfgInfo.channelInfo.channelAddress}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="渠道负责人：">
                    {{overViewData.cfgInfo.channelInfo.bossName}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="负责人手机：">
                    {{overViewData.cfgInfo.channelInfo.bossMphone}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="结算户名：">
                    {{overViewData.cfgInfo.channelInfo.accountName}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="结算卡开户行：">
                    {{overViewData.cfgInfo.channelInfo.accountBank}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="账号：">
                    {{overViewData.cfgInfo.channelInfo.accountNo}}
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="对接人职务：">
                    <el-select placeholder="请选择" v-model="overViewData.cfgInfo.channelInfo.staffDuty"
                               disabled>
                      <el-option v-for="item in $store.state.channelStaffDutyOptions" :label="item.desc"
                                 :value="item.code" :key="item.code"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="对接人：">
                    {{overViewData.cfgInfo.channelInfo.staffName}}
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="对接人电话：">
                    {{overViewData.cfgInfo.channelInfo.staffTel}}
                  </el-form-item>
                </el-col>
              </el-row>
            </div>
          </el-card>
        </div>
      </div>

      <!--费用信息-->
      <div class="item-information">
        <el-card>
          <div slot="header" class="clearfix">
            <span>费用信息</span>
          </div>
          <div>
            <Table
              :tableData="overViewData.cfgInfo.feeItemInfo" style="width: 100%"
            >
              <el-table-column
                property="itemName"
                label="费用科目名称"
              ></el-table-column>
              <el-table-column
                property="beforeContent"
                label="增值内容（处理前）"
                width="150px"
              ></el-table-column>
              <el-table-column
                property="afterContent"
                label="增值内容（处理后）"
                width="150px"
              ></el-table-column>
              <el-table-column
                property="itemPrice"
                label="单价"
              ></el-table-column>
              <el-table-column
                property="itemCount"
                label="数量"
              >
              </el-table-column>
              <el-table-column
                property="itemAmount"
                label="总价"
              >
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
              </el-table-column>
            </Table>
          </div>
        </el-card>
      </div>
      <!--材料信息-->
      <div class="item-information">
        <el-card>
          <div slot="header" class="clearfix">
            <span>材料信息</span>
          </div>
          <div>
            <Table
              :tableData="overViewData.cfgInfo.materialInfo" style="width: 100%"
            >
              <el-table-column
                property="materialName"
                label="材料名称"
              ></el-table-column>
              <el-table-column
                property="materialBelong"
                label="材料归属"
                width="90"
                :formatter="rowMaterialBelong"
              ></el-table-column>
              <el-table-column
                property="materialCount"
                label="数量"
                width="80px"
              >
              </el-table-column>
              <el-table-column
                property="materialType"
                :formatter="rowMaterialType"
                label="材料类型"
              ></el-table-column>
              <el-table-column
                property="materialStatus"
                label="状态"
                :formatter="materialStatusRow"
              >
              </el-table-column>
              <el-table-column
                property="raiseTime"
                label="提出时间"
                width="150px"
              >
                <template slot-scope="scope">
                  <el-date-picker
                    style="width: 100%"
                    size="mini"
                    value-format="timestamp"
                    v-model="overViewData.cfgInfo.materialInfo[scope.$index].raiseTime"
                    disabled
                    placeholder="选择日期"
                  >
                  </el-date-picker>
                </template>
              </el-table-column>
              <el-table-column
                property="promiseTime"
                label="承诺时间"
                width="150px"
              >
                <template slot-scope="scope">
                  <el-date-picker
                    style="width: 100%"
                    size="mini"
                    value-format="timestamp"
                    v-model="overViewData.cfgInfo.materialInfo[scope.$index].promiseTime"
                    disabled
                    placeholder="选择日期"
                  >
                  </el-date-picker>
                </template>
              </el-table-column>
              <el-table-column
                property="deliveryTime"
                label="送达时间"
                width="150px"
              >
                <template slot-scope="scope">
                  <el-date-picker
                    style="width: 100%"
                    size="mini"
                    value-format="timestamp"
                    v-model="overViewData.cfgInfo.materialInfo[scope.$index].deliveryTime"
                    disabled
                    placeholder="选择日期"
                  >
                  </el-date-picker>
                </template>
              </el-table-column>
              <el-table-column
                property="materialRemark"
                label="备注"
                width="150px"
              >
                <template slot-scope="scope">
                  <el-input
                    type="textarea"
                    size="mini"
                    autosize
                    disabled
                    v-model="overViewData.cfgInfo.materialInfo[scope.$index].materialRemark"
                  ></el-input>
                </template>
              </el-table-column>
            </Table>
          </div>
        </el-card>
      </div>
    </el-form>
  </div>
</template>

<script>
  import Table from '../../../components/table/Table';
  import Split from '../../../components/split/Split';
  import Dialog from '../../../components/dialog/Dialog';
  import Pagination from '../../../components/pagination/Pagination';

  export default {
    name: "OverView",
    components: {
      Table, Dialog, Pagination, Split
    },
    props: {
      overViewData: {
        type: Object,
        required: true,
      },
      caseSubType:{
        type: String,
        required: true,
      }
    },
    data() {
      return {
        editableTabsValue: '1',
        editableTabsValueSecond: '1'
      }
    },
    computed: {
      caseSelect() {
        let vm = this;
        return [vm.overViewData.caseType, vm.overViewData.caseSubType];
      },
      LoanTypeSelect() {
        let vm = this;
        return [vm.overViewData.loanInfo.loanType, vm.overViewData.loanInfo.loanSubType];
      }
    },
    mounted() {
      let vm = this;

    },
    methods: {}
  }
</script>

<style lang='scss' scoped>
  .OverView {
    /*margin: 20px;*/

    /deep/ .el-form {
      /deep/ .el-form-item {
        margin-bottom: 0;

        /deep/ .el-form-item__label {
          padding: 0;
        }
      }
    }

    /deep/ .el-card {
      /deep/ .el-card__header {
        padding: 6px 14px;
      }

      /deep/ .el-card__body {
        padding: 5px;
      }
    }

    .item-information {
      margin-top: 5px;
    }

    .buttons {
      text-align: center;
    }

    /deep/ .el-select {
      display: flex;
    }
  }
</style>
