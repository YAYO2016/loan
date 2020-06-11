// 定义，管理数据状态，存放数据的文件
//vuex的数据是保存在页面中的，一旦页面刷新，就会清楚，所以需要保存数据,可以使用cookie，需要安装js-cookie，这样即使页面关闭也一样可以重新使用vuex

import Util from '../common/js/util';

const state = {
  userInfo: Util.StorageFn.getLocal('userInfo') || '',
  caseOptions: Util.StorageFn.getLocal('caseOptions') || [],
  houseOptions: Util.StorageFn.getLocal('houseOptions') || [],
  loanTypeOptions: Util.StorageFn.getLocal('loanTypeOptions') || [],
  maritalStatusOptions: Util.StorageFn.getLocal('maritalStatusOptions') || [],
  propertyRightsTypeOptions: Util.StorageFn.getLocal('propertyRightsTypeOptions') || [],
  loanTermOptions: Util.StorageFn.getLocal('loanTermOptions') || [],
  superviseTypeOptions: Util.StorageFn.getLocal('superviseTypeOptions') || [],
  channelTypeOptions: Util.StorageFn.getLocal('channelTypeOptions') || [],
  repaymentTypeOptions: Util.StorageFn.getLocal('repaymentTypeOptions') || [],
  idTypeOptions: Util.StorageFn.getLocal('idTypeOptions') || [],
  coTypeOptions: Util.StorageFn.getLocal('coTypeOptions') || [],
  occuTypeOptions: Util.StorageFn.getLocal('occuTypeOptions') || [],
  custRelOptions: Util.StorageFn.getLocal('custRelOptions') || [],
  banksOptions: Util.StorageFn.getLocal('banksOptions') || [],
  channelStaffDutyOptions: Util.StorageFn.getLocal('channelStaffDutyOptions') || [],
  materialBelongOptions: Util.StorageFn.getLocal('materialBelongOptions') || [],
  breadcrumbInfo:[],
  stepData:[]
};

export default state;
