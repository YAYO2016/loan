// 对数据进行各种操作
import {
  REMOVE_BREADCRUMBINFO,
  REMOVE_STEPDATA,
  REMOVE_USERINFO,
  SET_banksOptions,
  SET_BREADCRUMBINFO,
  SET_caseOptions,
  SET_channelTypeOptions,
  SET_coTypeOptions,
  SET_custRelOptions,
  SET_houseOptions,
  SET_idTypeOptions,
  SET_loanTermOptions,
  SET_loanTypeOptions,
  SET_maritalStatusOptions,
  SET_occuTypeOptions,
  SET_propertyRightsTypeOptions,
  SET_repaymentTypeOptions,
  SET_STEPDATA,
  SET_superviseTypeOptions,
  SET_USERINFO,
  SET_channelStaffDutyOptions,
  SET_materialBelongOptions
} from './type';


const actions = {
  setUserInfo({commit, state}, payload) {
    commit(SET_USERINFO, payload);
  },
  removeUserInfo({commit, state}) {
    commit(REMOVE_USERINFO);
  },
  setBreadCrumbInfo({commit, state}, payload) {
    commit(SET_BREADCRUMBINFO, payload);
  },
  removeBreadCrumbInfo({commit, state}) {
    commit(REMOVE_BREADCRUMBINFO);
  },
  setStepData({commit, state}, payload) {
    commit(SET_STEPDATA, payload);
  },
  removeStepData({commit, state}) {
    commit(REMOVE_STEPDATA);
  },


  SET_caseOptions({commit, state},payload) {
    commit(SET_caseOptions,payload);
  },
  SET_houseOptions({commit, state},payload) {
    commit(SET_houseOptions,payload);
  },
  SET_loanTypeOptions({commit, state},payload) {
    commit(SET_loanTypeOptions,payload);
  },
  SET_maritalStatusOptions({commit, state},payload) {
    commit(SET_maritalStatusOptions,payload);
  },
  SET_propertyRightsTypeOptions({commit, state},payload) {
    commit(SET_propertyRightsTypeOptions,payload);
  },
  SET_loanTermOptions({commit, state},payload) {
    commit(SET_loanTermOptions,payload);
  },
  SET_superviseTypeOptions({commit, state},payload) {
    commit(SET_superviseTypeOptions,payload);
  },
  SET_channelTypeOptions({commit, state},payload) {
    commit(SET_channelTypeOptions,payload);
  },
  SET_repaymentTypeOptions({commit, state},payload) {
    commit(SET_repaymentTypeOptions,payload);
  },
  SET_idTypeOptions({commit, state},payload) {
    commit(SET_idTypeOptions,payload);
  },
  SET_coTypeOptions({commit, state},payload) {
    commit(SET_coTypeOptions,payload);
  },
  SET_occuTypeOptions({commit, state},payload) {
    commit(SET_occuTypeOptions,payload);
  },
  SET_custRelOptions({commit, state},payload) {
    commit(SET_custRelOptions,payload);
  },
  SET_banksOptions({commit, state},payload) {
    commit(SET_banksOptions,payload);
  },
  SET_channelStaffDutyOptions({commit, state},payload) {
    commit(SET_channelStaffDutyOptions,payload);
  },
  SET_materialBelongOptions({commit, state},payload) {
    commit(SET_materialBelongOptions,payload);
  },
};

export default actions;
