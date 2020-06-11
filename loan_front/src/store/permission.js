import routerMap from "../router/routes";

function hasPermission(roles, route) {
  if (route.meta && route.meta.privileges) {
    return roles.some(role => route.meta.privileges.includes(role));
  } else {
    return true;
  }
}

function filterAsyncRouter(routes, roles) {
  const res = [];
  routes.forEach(route => {
    const tmp = {...route};
    if (hasPermission(roles, tmp)) {
      if (tmp.children) {
        tmp.children = filterAsyncRouter(tmp.children, roles);
      }
      res.push(tmp);
    }
  });
  return res;
}

const permission = {
  state: {
    addRouters: []
  },
  mutations: {
    SET_ROUTERS: (state, routers) => {
      state.addRouters = routers;
    }
  },
  actions: {
    GenerateRoutes({commit}, data) {
      let allRouters = routerMap;
      return new Promise(resolve => {
        let accessedRouters;
        accessedRouters = filterAsyncRouter(allRouters, data);
        commit('SET_ROUTERS', accessedRouters);
        resolve();
      });

    }
  }
};
export default permission;
