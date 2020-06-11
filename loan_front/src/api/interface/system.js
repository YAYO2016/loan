//系统管理
import API from '../api';

const post = API.post;
const get = API.get;

const system = {
  //渠道管理
  //获取渠道数据
  getChannelList(params) {
    return get('/channel/list', params);
  },
  //新增渠道
  addChannel(params) {
    return post('/channel/addOrUpdateSingleChannel', params);
  },
  //获取单个渠道信息
  getSingleChannel(params) {
    return get('/channel/getSingleChannel', params);
  },
  //删除单个渠道数据
  deleteChannel(params) {
    return post('/channel/deleteChannel', params);
  },

  //用户管理
  //获取用户数据
  getUserList(params) {
    return get('/user/list', params);
  },
  //获取单个用户信息
  getSingleUserInfo(params) {
    return get('/user/getSingleUserInfo', params);
  },
  //新增单个用户
  addOrUpdateSingleUserInfo(params) {
    return post('/user/addOrUpdateSingleUserInfo', params);
  },
  //更新单个用户状态
  updateUserStatus(params) {
    return post('/user/updateUserStatus', params);
  },
  //修改用户密码
  modifyPassword(params) {
    return post('/user/modifyPassword', params);
  },

  //组织机构管理
  //组织机构列表获取和查询接口
  orgList(params) {
    return get('/org/list', params);
  },
  //获取单个组织机构
  getSingleOrganization(params) {
    return get('/org/getSingleOrganization', params);
  },
  //新增组织机构
  addOrUpdateSingleOrganization(params) {
    return post('/org/addOrUpdateSingleOrganization', params);
  },
  //删除组织机构
  deleteOrganization(params) {
    return post('/org/deleteOrganization', params);
  },


  //费用科目
  //费用科目列表接口
  feelsList(params) {
    return get('/feeItem/list', params);
  },
  //获取单个费用科目
  getSingleFeeItem(params) {
    return get('/feeItem/getSingleFeeItem', params);
  },
  //新增或修改费用科目
  addOrUpdateSingleFeeItem(params) {
    return post('/feeItem/addOrUpdateSingleFeeItem', params);
  },
  //删除费用科目
  deleteFeeItem(params) {
    return post('/feeItem/deleteFeeItem', params);
  },


  //银行信息
  //银行信息列表获取
  branchsList(params) {
    return get('/branch/list', params);
  },
  //获取单个银行信息
  getSingleBranch(params) {
    return get('/branch/getSingleBranch', params);
  },
  //新增或修改新航信息
  addOrUpdateSingleBranch(params) {
    return post('/branch/addOrUpdateSingleBranch', params);
  },
  //删除银行
  deleteBranch(params) {
    return post('/branch/deleteBranch', params);
  },
  //总行信息获取
  bankList(params) {
    return get('/bank/list', params);
  },

  //材料
  //获取材料管理分页列表
  materialsList(params) {
    return get('/material/list', params);
  },
  //获取单个材料的信息
  getSingleMaterial(params) {
    return get('/material/getSingleMaterial', params);
  },
  //新增或修改材料信息
  addOrUpdateSingleMaterial(params) {
    return post('/material/addOrUpdateSingleMaterial', params);
  },
  //删除费用科目
  deleteMaterial(params) {
    return post('/material/deleteMaterial', params);
  },


  //开发商
  //开发商楼盘分页列表
  developersList(params) {
    return get('/developer/list', params);
  },
  //获取开发商楼盘信息
  getDeveloperInfo(params) {
    return get('/developer/getDeveloperInfo', params);
  },
  //更新或保存开发商楼盘信息
  addOrUpdateDeveloperInfo(params) {
    return post('/developer/addOrUpdateDeveloperInfo', params);
  },
  //删除开发商楼盘
  deleteEstateInfo(params) {
    return post('/developer/deleteEstateInfo', params);
  },


  //角色管理
  //获取所有角色信息
  roleList(params) {
    return get('/role/listAll', params);
  },
  //获取单个角色信息
  getRoleInfo(params) {
    return get('/role/getRoleInfo', params);
  },
  //更新单个角色信息
  updateRoleInfo(params) {
    return post('/role/updateRoleInfo', params);
  },
  //获取全部权限信息
  getAllPrivileges(params) {
    return get('/role/getAllPrivileges', params);
  },
  //获取单个角色的权限信息
  getRolePrivileges(params) {
    return get('/role/getRolePrivileges', params);
  },
  //更新单个角色的权限信息
  updateRolePrivileges(params) {
    return post('/role/updateRolePrivileges', params);
  },


  //通知管理
  //获取通知列表
  messageList(params) {
    return get('/message/list', params);
  },
  //获取单个消息
  getSingleMessage(params) {
    return get('/message/getSingleMessage', params);
  },
  //新增或修改消息
  addOrUpdateSingleMessage(params) {
    return post('/message/addOrUpdateSingleMessage', params);
  },
  //发送消息
  sendMessage(params) {
    return post('/message/sendMessage', params);
  },
  //获取已发送的信息总数
  getSendedMessagesNum(params) {
    return get('/message/getSendedMessagesNum', params);
  },

};

export default system;
