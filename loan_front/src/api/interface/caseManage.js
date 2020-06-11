import API from '../api';

const post = API.post;
const get = API.get;

const caseManage = {
  //工作概况
  getCasesCountBlock(params) {
    return get('/businessOverview/getCasesCountBlock', params)
  },

  //案子列表
  getHistoryCaseList(params) {
    return get('/case/getAllCaseList', params)
  },
  //案子列表
  getCaseList(params) {
    return get('/case/list', params)
  },

  //案子流程信息
  getCaseFlowList(params) {
    return get('/flow/getCaseFlowList', params)
  },

  //获取案子基本信息
  getCaseBaseInfo(params) {
    return get('/case/getCaseBaseInfo', params)
  },
  //保存案子基本信息
  saveCaseBaseInfo(params) {
    return post('/case/saveCaseBaseInfo', params)
  },
  //获取当前登录人的渠道人
  getBusinessUser() {
    return get('/user/getBusinessUser', null)
  },

  //获取案子贷款信息
  getCaseLoanInfo(params) {
    return get('/case/getCaseLoanInfo', params)
  },
  //保存案子贷款信息
  saveCaseLoanInfo(params) {
    return post('/case/saveCaseLoanInfo', params)
  },

  //获取案子一手房抵押物信息
  getNewHouseCollateralInfo(params) {
    return get('/case/getNewHouseCollateralInfo', params)
  },
  //保存案子一手房抵押物信息
  saveNewHouseCollateralInfo(params) {
    return post('/case/saveNewHouseCollateralInfo', params)
  },
  //获取案子二手房抵押物信息
  getSecondHandHouseCollateralInfo(params) {
    return get('/case/getSecondHandHouseCollateralInfo', params)
  },
  //保存案子二手房抵押信息
  saveSecondHandHouseCollateralInfo(params) {
    return post('/case/saveSecondHandHouseCollateralInfo', params)
  },

  //获取干系人信息
  getCaseCustInfo(params) {
    return get('/case/getCaseCustInfo', params)
  },
  //保存干系人信息
  saveCaseCustInfo(params) {
    return post('/case/saveCaseCustInfo', params)
  },

  //获取开发商列表信息
  getDeveloperList(params) {
    return get('/developer/getDeveloperList', params)
  },
  //获取楼盘列表信息
  getEstateList(params) {
    return get('/developer/getEstateList', params)
  },
  //获取楼盘销售人员的列表
  getEstateSalesmanList(params) {
    return get('/developer/getEstateSalesmanList', params)
  },


  //获取案子开发商信息
  getCaseDeveloperCfgInfo(params) {
    return get('/case/getCaseDeveloperCfgInfo', params)
  },
  //保存案子开发商信息
  saveCaseDeveloperCfgInfo(params) {
    return post('/case/saveCaseDeveloperCfgInfo', params)
  },

  //获取案子渠道信息
  getCaseChannelCfgInfo(params) {
    return get('/case/getCaseChannelCfgInfo', params)
  },
  //保存案子渠道信息
  saveCaseChannelCfgInfo(params) {
    return post('/case/saveCaseChannelCfgInfo', params)
  },

  //获取案子的材料信息
  getCaseMaterialCfgInfo(params) {
    return get('/case/getCaseMaterialCfgInfo', params)
  },
  //保存案子的材料信息
  saveCaseMaterialCfgInfo(params) {
    return post('/case/saveCaseMaterialCfgInfo', params)
  },

  //获取案子的费用科目信息
  getCaseFeeItemCfgInfo(params) {
    return get('/case/getCaseFeeItemCfgInfo', params)
  },
  //保存案子的费用科目消息
  saveCaseFeeItemCfgInfo(params) {
    return post('/case/saveCaseFeeItemCfgInfo', params)
  },

  //获取案例概览信息
  getCaseOverviewInfo(params) {
    return get('/case/getCaseOverviewInfo', params)
  },

  //提交审批的时候获取人员列表接口
  listRoleUser(params) {
    return get('/user/listRoleUser', params)
  },
  //风控审核获取审批银行接口
  getBranchInfo(params) {
    return get('/branch/getBranchInfo', params)
  },

  //风控审核提交接口
  drivingProcessForCheck(params) {
    return post('/flow/drivingProcessForCheck', params)
  },
  //流程驱动接口
  drivingProcess(params) {
    return post('/flow/drivingProcess', params)
  },
  //整改获取案子信息接口
  getCaseReformInfo(params) {
    return get('/case/getCaseReformInfo', params)
  },
  //整改提交接口
  drivingProcessForReform(params) {
    return post('/flow/drivingProcessForReform', params)
  },

  // 通过组织机构ID获取人员
  getUserByOrgId(params) {
    return get('/user/getUserByOrgId', params)
  }
};

export default caseManage;
