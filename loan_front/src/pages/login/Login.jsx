import {mapActions} from 'vuex';
import Split from '../../components/split/Split';
import './Login.scss'

export default {
  name: 'Login',
  data() {
    return {
      loginAccount: '',
      userPwd: ''
    }
  },
  methods: {
    ...mapActions([
      'setUserInfo',
      'SET_caseOptions',
      'SET_houseOptions',
      'SET_loanTypeOptions',
      'SET_maritalStatusOptions',
      'SET_propertyRightsTypeOptions',
      'SET_loanTermOptions',
      'SET_superviseTypeOptions',
      'SET_channelTypeOptions',
      'SET_repaymentTypeOptions',
      'SET_idTypeOptions',
      'SET_coTypeOptions',
      'SET_occuTypeOptions',
      'SET_custRelOptions',
      'SET_banksOptions',
      'SET_channelStaffDutyOptions',
      'SET_materialBelongOptions'
    ]),
    async login() {
      let vm = this;
      await vm.$api.login({
        loginAccount: vm.loginAccount,
        password: vm.userPwd
      }).then(res => {
        if (res) {
          vm.setUserInfo(res.data);
          vm.$router.push({
            path: `/`,
          });
        }
      });
      vm.$api.getEnumsMap({enumsType: 'CaseType'}).then(res => {
        vm.SET_caseOptions(res.data);
      });
      vm.$api.getEnumsMap({enumsType: 'HouseProperty'}).then(res => {
        vm.SET_houseOptions(res.data);
      });
      vm.$api.getEnumsMap({enumsType: 'LoanType'}).then(res => {
        vm.SET_loanTypeOptions(res.data);
      });
      vm.$api.getEnumsMap({enumsType: 'MaritalStatus'}).then(res => {
        vm.SET_maritalStatusOptions(res.data);
      });
      vm.$api.getEnumsMap({enumsType: 'LoanTerms'}).then(res => {
        vm.SET_loanTermOptions(res.data);
      });
      vm.$api.getEnumsMap({enumsType: 'PropertyRightsType'}).then(res => {
        vm.SET_propertyRightsTypeOptions(res.data);
      });
      vm.$api.getEnumsMap({enumsType: 'SuperviseType'}).then(res => {
        vm.SET_superviseTypeOptions(res.data);
      });
      vm.$api.getEnumsMap({enumsType: 'ChannelType'}).then(res => {
        vm.SET_channelTypeOptions(res.data);
      });
      vm.$api.getEnumsMap({enumsType: 'RepaymentType'}).then(res => {
        vm.SET_repaymentTypeOptions(res.data);
      });
      vm.$api.getEnumsMap({enumsType: 'IDType'}).then(res => {
        vm.SET_idTypeOptions(res.data);
      });
      vm.$api.getEnumsMap({enumsType: 'CoType'}).then(res => {
        vm.SET_coTypeOptions(res.data);
      });
      vm.$api.getEnumsMap({enumsType: 'OccuType'}).then(res => {
        vm.SET_occuTypeOptions(res.data);
      });
      vm.$api.getEnumsMap({enumsType: 'CustomerRelation'}).then(res => {
        vm.SET_custRelOptions(res.data);
      });
      vm.$api.getEnumsMap({enumsType: 'ChannelStaffDuty'}).then(res => {
        vm.SET_channelStaffDutyOptions(res.data);
      });
      vm.$api.getEnumsMap({enumsType: 'MaterialBelong'}).then(res => {
        vm.SET_materialBelongOptions(res.data);
      });
      vm.$api.bankList({}).then(res => {
        vm.SET_banksOptions(res.data);
      });
    },
    reset() {
      let vm = this;
      vm.loginAccount = '';
      vm.userPwd = '';
    }
  },
  render() {
    return (
      <div class="Login">
        <div class="title">
          公司-系统名称
        </div>
        <Split/>
        <div class="content">
          <div class="loan-search">案子查询</div>
          <div class="loan-introduce">公司简介</div>
          <div class="user-login">
            <div>
              工号：
              <el-input type="text" style="width: 230px;" value={this.loginAccount} on-input={val => this.loginAccount = val}/>
            </div>
            <Split/>
            <div>
              密码：
              <el-input type="password" style="width: 230px;" value={this.userPwd} on-input={val => this.userPwd = val}/>
            </div>
            <Split/>
            <div class="buttons">
              <el-button onClick={this.reset}>重置</el-button>
              <el-button type="primary" onClick={this.login}>登录</el-button>
            </div>
          </div>
        </div>
        <Split/>
        <div class="authority">
          版权信息
        </div>
      </div>
    )
  }
}
