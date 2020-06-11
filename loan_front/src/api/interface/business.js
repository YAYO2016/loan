/**
 * Created by yanyue on 2019/5/29 16:13
 */
import API from '../api';

const post = API.post;
const get = API.get;
const business = {
  //获取柱形图
  departmentCasesCount(params){
  return get('/businessOverview/getCasesCount', params)
},

};

export default business;
