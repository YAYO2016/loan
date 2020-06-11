import axios from 'axios';
import {Loading, Message} from 'element-ui';
import Router from '../router/index';
import util from '../common/js/util'

var loadingInstance;

let baseUrl = '';
const timeout = 10 * 1000;
const system = 'loan';

if (process.env.NODE_ENV == 'development') {  //开发环境
  if (location.pathname == '/') {
    baseUrl = location.origin + `/${system}/`;
  } else if (location.pathname == `/${system}/`) {
    baseUrl = location.origin + location.pathname;
  }
} else if (process.env.NODE_ENV == 'production') { //生产环境
  baseUrl = location.origin + '/';
}

export default class API {
  static get(url, params={}) {
    //request intercept
    // console.log('请求拦截');
    loadingInstance = Loading.service({
      lock: true,
      text: '数据加载中，请稍后...',
      spinner: 'el-icon-loading',
      background: 'rgba(0, 0, 0, 0.7)'
    });

    return new Promise((resolve, reject) => {
      axios({
        url: url,
        method: 'get',
        baseURL: baseUrl,
        timeout: timeout,
        params: {...params, _t: new Date().getTime()} || "",
      }).then(response => {
        //response intercept
        // console.log('响应拦截');
        loadingInstance.close();

        if (response.status == '200') {  //这边的是http请求OK
          let res = response.data;
          if (res.status == '200') {  //这边的是接口返回业务数据是OK的
            resolve(res);
          } else if(res.status == '300'){  //接口300，返回登录页面
            util.StorageFn.clearLocal();
            Router.push({path: '/login'});
            Message.error(res.msg);
          } else if (res.status == '400') {  //接口400,业务出错
            Message.error(`${res.msg}，${res.data}`);
          } else {
            Message.error(res.msg);
          }
        } else {
          reject(response);
        }
      }).catch(error => {
        loadingInstance.close();
        console.log(error);
      })
    });
  }

  static post(url, params) {
    //request intercept
    loadingInstance = Loading.service({
      lock: true,
      text: '数据加载中，请稍后...',
      spinner: 'el-icon-loading',
      background: 'rgba(0, 0, 0, 0.7)'
    });

    return new Promise((resolve, reject) => {
      axios({
        url: url,
        method: 'post',
        baseURL: baseUrl,
        timeout: timeout,
        data: params || "",
        headers: {'Content-Type': 'application/json;charset=UTF-8'}
      }).then(response => {
        //response intercept
        loadingInstance.close();
        if (response.status == '200') {  //这边的是http请求OK
          let res = response.data;
          if (res.status == '200') {  //这边的是接口返回业务数据是OK的
            resolve(res);
          } else if(res.status == '300'){   //接口300，返回登录页面
            Router.push({path: '/login'});
            Message.error(res.msg);
          }else if (res.status == '400') {  //接口400,业务出错
            Message.error(`${res.msg}，${res.data}`);
          } else{
            Message.error(res.msg);
          }
        } else {
          reject(response);
        }
      }).catch(error => {
        loadingInstance.close();
        console.log(error);
      })
    });
  }

}
