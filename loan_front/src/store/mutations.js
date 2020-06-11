// 对state的状态进行修改

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
// import Cookies from 'js-cookie';
import Util from '../common/js/util';

const mutations = {
  [SET_USERINFO](state, payload) {
    state.userInfo = payload;
    Util.StorageFn.setLocal('userInfo', payload);
  },
  [REMOVE_USERINFO](state) {
    state.userInfo = "";
    Util.StorageFn.clearLocal();
  },
  [SET_BREADCRUMBINFO](state, payload) {
    state.breadcrumbInfo = payload;
  },
  [REMOVE_BREADCRUMBINFO](state) {
    state.breadcrumbInfo = "";
  },
  [SET_STEPDATA](state, payload) {
    state.stepData = payload;
  },
  [REMOVE_STEPDATA](state) {
    state.stepData = "";
  },
  [SET_caseOptions](state, payload) {
    state.caseOptions = payload;
    Util.StorageFn.setLocal('caseOptions', payload);
  },
  [SET_houseOptions](state, payload) {
    state.houseOptions = payload;
    Util.StorageFn.setLocal('houseOptions', payload);
  },
  [SET_loanTypeOptions](state, payload) {
    state.loanTypeOptions = payload;
    Util.StorageFn.setLocal('loanTypeOptions', payload);
  },
  [SET_maritalStatusOptions](state, payload) {
    state.maritalStatusOptions = payload;
    Util.StorageFn.setLocal('maritalStatusOptions', payload);
  },
  [SET_propertyRightsTypeOptions](state, payload) {
    state.propertyRightsTypeOptions = payload;
    Util.StorageFn.setLocal('propertyRightsTypeOptions', payload);
  },
  [SET_loanTermOptions](state, payload) {
    state.loanTermOptions = payload;
    Util.StorageFn.setLocal('loanTermOptions', payload);
  },
  [SET_superviseTypeOptions](state, payload) {
    state.superviseTypeOptions = payload;
    Util.StorageFn.setLocal('superviseTypeOptions', payload);
  },
  [SET_channelTypeOptions](state, payload) {
    state.channelTypeOptions = payload;
    Util.StorageFn.setLocal('channelTypeOptions', payload);
  },
  [SET_repaymentTypeOptions](state, payload) {
    state.repaymentTypeOptions = payload;
    Util.StorageFn.setLocal('repaymentTypeOptions', payload);
  },
  [SET_idTypeOptions](state, payload) {
    state.idTypeOptions = payload;
    Util.StorageFn.setLocal('idTypeOptions', payload);
  },
  [SET_coTypeOptions](state, payload) {
    state.coTypeOptions = payload;
    Util.StorageFn.setLocal('coTypeOptions', payload);
  },
  [SET_occuTypeOptions](state, payload) {
    state.occuTypeOptions = payload;
    Util.StorageFn.setLocal('occuTypeOptions', payload);
  },
  [SET_custRelOptions](state, payload) {
    state.custRelOptions = payload;
    Util.StorageFn.setLocal('custRelOptions', payload);
  },
  [SET_banksOptions](state, payload) {
    state.banksOptions = payload;
    Util.StorageFn.setLocal('banksOptions', payload);
  },
  [SET_channelStaffDutyOptions](state, payload) {
    state.channelStaffDutyOptions = payload;
    Util.StorageFn.setLocal('channelStaffDutyOptions', payload);
  },
  [SET_materialBelongOptions](state, payload) {
    state.materialBelongOptions = payload;
    Util.StorageFn.setLocal('materialBelongOptions', payload);
  },



};

export default mutations;
