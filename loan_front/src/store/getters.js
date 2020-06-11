// 获取state下的数据，state的映射,对statte中的数据进行二次处理的时候会使用

const getters = {
  getUserInfo: (state, getters) => state.userInfo,
  getBreadCrumbInfo: (state, getters) => state.breadcrumbInfo,
  getStepData: (state, getters) => state.stepData,
  addRouters: state => state.permission.addRouters,
};

export default getters;
