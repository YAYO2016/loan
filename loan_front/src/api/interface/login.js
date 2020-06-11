import API from '../api';

const post = API.post;
const get = API.get;

const login = {
  //登录接口
  login(username, password) {
    return post('/login?username=' + username + "&password=" + password, null)
  },
  //登出
  loginOut(params) {
    return post('/logout', params)
  },
  //获取用户权限
  getAuth(params) {
    return get('/getAuth', params)
  },
};

export default login;
