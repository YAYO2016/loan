//公共接口
import API from '../api';

const post = API.post;
const get = API.get;

const common= {
  //获取枚举数据
  getEnumsMap(params) {
    return get('/common/getEnumsMap', params);
  }
};

export default common;
