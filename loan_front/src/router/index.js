import Vue from 'vue';
import Router from 'vue-router';
import loanRouter from './routes';
import store from '../store/index';
import util from '../common/js/util'

Vue.use(Router);

export const router = new Router({
  // mode: 'history',
  routes: new Set([...loanRouter]),
});

// 路由守卫,进行拦截，可以拦截用户设置的权限是路由requireAuth:true的（但是可能token失效了，但是本地还是保存着，所以需要axios拦截配合）
router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth === undefined) {
    next({
      path: '/noFound'
    })
    return;
  }
  if (to.meta.requireAuth) { // 判断该路由是否需要登录权限
    if (store.state.userInfo) { // 判断当前是否有用户信息 && store.getters.addRouters.length <= 0
      if (store.getters.addRouters.length <= 0) {
        store.dispatch('GenerateRoutes', store.state.userInfo.privileges).then(() => {
          router.addRoutes(store.getters.addRouters);
          next({...to, replace: true});
        })
      } else {
        next();
      }

      // if (util.ArrayFn.intersect(to.meta.privileges, store.state.userInfo.privileges).length > 0) { //判断当前路由使用有权限去访问
      //   next();
      // } else {
      //   next({
      //     path: '/noFound'
      //   })
      // }
      // next();
    } else {
      next({
        path: '/login'
      });
    }
  } else {
    next();
  }
});

router.afterEach((to, from, next) => {
  window.scrollTo(0, 0);
});
export default router;
