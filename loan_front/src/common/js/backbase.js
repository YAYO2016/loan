import moment from 'moment';

const install = function (Vue, options) {
  Vue.prototype.sexFormat = (sex) => {
    if (sex === 'MALE') {
      return "男";
    } else if (sex === 'FEMALE') {
      return "女";
    } else {
      return "";
    }
  };

  Vue.prototype.rowSexFormat = (row, column) => {
    let sex = row[column.property];
    if (sex === 'MALE') {
      return "男";
    } else if (sex === 'FEMALE') {
      return "女";
    } else {
      return "";
    }
  };

  //备注格式处理
  Vue.prototype.remarkFormat = (row, column) => {
    let content = row[column.property];
    return content.replace(/\n/g,'<br/>');
  };

  Vue.prototype.timeFormat = (date) => {
    if( (!date && typeof(date)!="undefined" && date!=0)|| date == ''){
      return '';
    }else{
      return moment(parseInt(date)).format("YYYY-MM-DD HH:mm:ss");
    }
  };

  Vue.prototype.dateFormat = (date) => {
    if( (!date && typeof(date)!="undefined" && date!=0)|| date == ''){
      return '';
    }else{
      return moment(parseInt(date)).format("YYYY-MM-DD");
    }
  };

  Vue.prototype.hourFormat = (date) => {
    if( (!date && typeof(date)!="undefined" && date!=0)|| date == ''){
      return '';
    }else{
      return moment(parseInt(date)).format("HH:mm:ss");
    }
  };

  Vue.prototype.rowDateFormat = (row, column) => {
    let date = row[column.property];
    if (!date && typeof(date)!="undefined" && date!=0) {
      return "";
    }else{
      return moment(parseInt(date)).format("YYYY-MM-DD");
    }
  };

  Vue.prototype.rowStatusFormat = (row, column) => {
    let status = row[column.property];
    if (status == 'VALID') {
      return "有效";
    } else if (status == 'INVALID') {
      return "无效";
    } else {
      return "";
    }
  };

  Vue.prototype.roleFormat = (roleArr) => {
    if(roleArr){
      return roleArr.map(role=>{
        return role.roleName
      }).join(',');
    }else{
      return ''
    }
  };

  Vue.prototype.rowItemRate = (row, column) => {
    let itemRate = row[column.property];
    return itemRate + "%";
  };

  Vue.prototype.rowItemNoPoint = (row, column) => {
    let itemNum = row[column.property];
    return itemNum.substring(0, itemNum.indexOf('.'));
  };

  Vue.prototype.rowMaterialBelong = (row, column) => {
    let materialBelong = row[column.property];
    switch (materialBelong) {
      case 'BUYER':
        return '主贷人';
      case 'BUYER_SPOUSE':
        return '主贷人配偶';
      case 'CO_BUYER':
        return '共还人';
      case 'CO_BUYER_SPOUSE':
        return '共还人配偶';
      case 'SELLER':
        return '出售方';
      case 'SELLER_SPOUSE':
        return '出售方配偶';
      case 'CO_SELLER':
        return '共有人';
      case 'CO_SELLER_SPOUSE':
        return '共有人配偶';
      default:
        return '';
    }
  };

  Vue.prototype.channelTypeFormat = (row, column) => {
    let channelType = row[column.property];
    switch (channelType) {
      case 'DEFAULT':
        return '无';
      case 'AGENCY':
        return '中介';
      case 'PEER':
        return '同行';
      default:
        return '';
    }
  };
  Vue.prototype.channelTypeLowFormat = (channelType) => {
    switch (channelType) {
      case 'DEFAULT':
        return '无';
      case 'AGENCY':
        return '中介';
      case 'PEER':
        return '同行';
      default:
        return '';
    }
  };

  Vue.prototype.channelStaffDuty = (channelStaffDuty) => {
    switch (channelStaffDuty) {
      case 'WARRANT':
        return '权证';
      case 'AGENT':
        return '业务员';
      default:
        return '';
    }
  };

  Vue.prototype.rowMaterialType = (row, column) => {
    let materialType = row[column.property];
    switch (materialType) {
      case 'ORIGINAL':
        return '原件';
      case 'COPY':
        return '复印件';
      default:
        return '';
    }
  };

  //材料状态
  Vue.prototype.materialStatusRow = (row, column) => {
    let materialStatus = row[column.property];
    switch (materialStatus) {
      case 'PROVIDED':
        return '已提供';
      case 'NOT_PROVIDED':
        return '未提供';
      default:
        return '';
    }
  };

  //贷款大类
  Vue.prototype.rowLoanType = (row, column) => {
    let loanType = row[column.property];
    switch (loanType) {
      case 'RESERVE':
        return '公积金贷款';
      case 'SYNDICATED':
        return '组合贷款';
      case 'COMMERCIAL':
        return '商业贷款';
      default:
        return '';
    }
  };

  //贷款大类
  Vue.prototype.rowCaseType = (row, column) => {
    let rowCaseType = row[column.property];
    switch (rowCaseType) {
      case 'HOME_LOAN':
        return '住房贷款';
      default:
        return '';
    }
  };

  //贷款大类
  Vue.prototype.rowSubCaseType = (row, column) => {
    let rowSubCaseType = row[column.property];
    switch (rowSubCaseType) {
      case 'NEW_HOUSE':
        return '一手房';
      case 'SECOND_HAND_HOUSE':
        return '二手房';
      default:
        return '';
    }
  };

  Vue.prototype.validateRules = (formName, _this) => {
    let result = '';
    _this.$refs[formName].validate((valid) => {
      if (valid) {
        result = true;
      } else {
        _this.$message({
          message: '输入有误',
          type: 'error'
        });
        result = false;
      }
    });
    return result;
  };

};

export default install;
