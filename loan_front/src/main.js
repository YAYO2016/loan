// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import api from './api/interface/index';
import './common/style/reset_pt.css';
import "./common/iconfont/iconfont.css";

import backbase from './common/js/backbase';
import util from './common/js/util';
import rules from './common/js/rules';
import "babel-polyfill";


Vue.prototype.$api = api;

Vue.use(backbase);

Vue.prototype.$util = util;

Vue.prototype.$rules = rules;

Vue.use(ElementUI);

//全局引入echarts
import echarts from 'echarts'
Vue.prototype.$echarts = echarts;

Vue.config.productionTip = false;

import VueSocketio from 'vue-socket.io';
// import socketio from 'socket.io-client';
// Vue.use(VueSocketio, socketio('localhost:9090'));
Vue.use(new VueSocketio({
  debug: false,
  connection: location.hostname + ':8998',
}));

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: {App},
  template: '<App/>'
});
