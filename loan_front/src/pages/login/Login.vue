<template>
  <div class='Login'>
    <div class="title">
      贷款管理系统
    </div>
    <Split/>
    <div class="content">
      <div class="loan-search">案子查询</div>
      <div class="loan-introduce">公司简介</div>
      <div class="user-login">
        <div>
          工号：
          <el-input type="text" style="width: 230px;" v-model="loginAccount"/>
        </div>
        <Split/>
        <div>
          密码：
          <el-input type="password" style="width: 230px;" v-model="password" @keyup.enter.native="login"/>
        </div>
        <Split/>
        <div class="buttons">
          <el-button @click.enter="reset">重置</el-button>
          <el-button type="primary" @click="login">登录</el-button>
        </div>
      </div>
    </div>
    <Split/>
    <div class="authority">
      版权信息
    </div>
  </div>
</template>

<script>
  import {mapActions} from 'vuex';
  import Split from '../../components/split/Split';

  export default {
    name: "Login",
    data() {
      return {
        loginAccount: '',
        password: ''
      }
    },
    components: {
      Split
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
        let loginSuccess = false;
        await vm.$api.login(vm.loginAccount, vm.password).then(res => {
          if (200 === parseInt(res.status)) {
            loginSuccess = true;
          }
        });
        if (!loginSuccess) return;
        await vm.$api.getAuth({}).then(r => {
          if (r) {
            vm.$socket.emit('userRegisterEvent', r.data); // 给后台发送登录通知
            vm.setUserInfo(r.data);
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

        vm.$router.push({
          path: `/case`,
        });
      },
      reset() {
        let vm = this;
        vm.loginAccount = '';
        vm.userPwd = '';
      }
    }
  }
</script>

<style lang="scss" scoped>
  $wrapperWidth: 700px;
  $loginFontSize: 20px;
  $loanBackGroundColor: #36A9CE;
  $loanTitleBackGroundColor: #F2F2F2;
  .Login {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100%;
    font-size: $loginFontSize;

    .title {
      text-align: center;
      height: 50px;
      width: $wrapperWidth;
      line-height: 50px;
      background: $loanTitleBackGroundColor;
    }

    .content {
      width: $wrapperWidth;
      display: flex;
      flex-direction: row;
      justify-content: space-between;

      .loan-search, .loan-introduce {
        background: $loanBackGroundColor;
        width: 150px;
        height: 150px;
        line-height: 150px;
        text-align: center;
        cursor: pointer;
      }
    }

    .authority {
      text-align: center;
      width: $wrapperWidth;
      line-height: 50px;
      background: $loanTitleBackGroundColor;
    }
  }
</style>
