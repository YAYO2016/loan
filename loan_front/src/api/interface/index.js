import login from './login';
import system from './system';
import common from './common';
import caseManage from "./caseManage";
import business from "./business";

const api = {
  ...login,
  ...system,
  ...common,
  ...caseManage,
  ...business
};

export default api;
