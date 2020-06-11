<template>
  <div class='Header'>
    <div class="left">
      <img src="../../assets/imgs/logo.jpg" alt="">
      <div class="title">
        <span>贷款管理系统</span>
      </div>
    </div>
    <div class="center">
      <el-menu
        :default-active="defaultActive"
        class="el-menu-demo"
        mode="horizontal"
        background-color="#8D96D7"
        text-color="#FFFFFF"
        active-text-color="#000000"
        router
      >
        <el-menu-item v-if="$util.StorageFn.checkPrivileges(['LFR01'])" index="/business">业务总览</el-menu-item>
        <!--        <el-menu-item v-if="$util.StorageFn.checkPrivileges(['LFR02'])" index="/case">案子管理</el-menu-item>-->
        <el-menu-item index="/case">案子管理</el-menu-item>
        <el-menu-item v-if="$util.StorageFn.checkPrivileges(['LFR03'])" index="/system">系统管理</el-menu-item>
      </el-menu>
    </div>
    <div class="right">
      <div class="info">
        <span>{{$store.state.userInfo.userName}}</span> |
        <span>{{$store.state.userInfo.orgName}}</span> |
        <span v-for="item in $util.StorageFn.getUserRoleMap()">
          {{item.name}}
        </span>
      </div>
      <div class="icon">
        <i class="iconfont icon-shezhi" @click="showPersonalInfo"/>
        <el-badge :value="iconNum" class="item">
          <i class="iconfont icon-duanxin" @click="showMessage"/>
        </el-badge>
        <i class="iconfont icon-tuichu" @click="logout"/>
      </div>
    </div>

    <div class="dialog">
      <Dialog :title="'密码修改'"
              :show.sync="personalInfoVisible"
              @closedDialog="resetPersonalInfoForm">
        <div>
          <div class="content">
            <el-form ref="personInfoForm" :model="personInfoForm" size="mini" label-width="140px">
              <el-row>
                <el-col :span="12">
                  <el-form-item label="用户密码：" prop="userPw">
                    <el-input type="password" v-model="personInfoForm.userPw"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="12">
                  <el-form-item label="确认密码：" prop="confirmPwd">
                    <el-input type="password" v-model="personInfoForm.confirmPwd"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </div>
          <hr style="border: 0.5px solid #D7D7D7"/>
          <div class="dialog-footer">
            <el-button @click="personalInfoVisible = false" size="mini">取消</el-button>
            <el-button @click="savePersonInfo" size="mini">保存</el-button>
          </div>
        </div>
      </Dialog>

      <Dialog :title="'消息通知'"
              :show.sync="messageVisible">
        <div>
          <div class="search">
            <el-form ref="form" :model="search" size="mini" label-width="110px">
              <el-row>
                <el-col :span="15">
                  <el-form-item label="关键字：" prop="keyWord">
                    <el-input v-model="search.keyWord" placeholder="请输入关键字" clearable/>
                  </el-form-item>
                </el-col>
                <el-col :span="9">
                  <el-form-item label="">
                    <el-button @click="getData()" class="search-button">查询</el-button>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="15">
                  <el-form-item label="发起日期：" prop="sendTimeSearch">
                    <el-date-picker
                      v-model="sendTimeSearch"
                      value-format="yyyy-MM-dd HH:mm:ss"
                      type="daterange"
                      range-separator="~"
                      start-placeholder="开始日期"
                      end-placeholder="结束日期">
                    </el-date-picker>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="15">
                  <el-form-item label="通知级别：" prop="msgLevel">
                    <el-select v-model="search.msgLevel" clearable>
                      <el-option
                        v-for="item in msgLevelOptions"
                        :key="item.code"
                        :label="item.desc"
                        :value="item.code">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </div>
          <hr style="border: 0.5px solid #D7D7D7">
          <div class="content">
            <Table :tableData="tableData" style="width: 100%">
              <el-table-column
                property="sendTime"
                label="发送时间"
                width="140">
                <div slot-scope="scope">
                  {{timeFormat(scope.row.sendTime)}}
                </div>
              </el-table-column>
              <el-table-column
                property="msgTitle"
                label="标题"
                show-overflow-tooltip
                width="100">
              </el-table-column>
              <el-table-column
                property="msgContent"
                label="内容"
                show-overflow-tooltip
                width="">
              </el-table-column>
              <el-table-column
                property="msgLevel"
                label="通知等级"
                width="90">
                <div slot-scope="scope">
                  {{$util.StorageFn.getEnumDesc(msgLevelOptions,scope.row.msgLevel)}}
                </div>
              </el-table-column>
            </Table>
            <Pagination :total="pageInfo.totalItems"
                        @changePage="currentChange"
                        :currentPage="pageInfo.pageNum"
                        :pageSize="pageInfo.pageSize"/>
          </div>
        </div>
      </Dialog>
    </div>
  </div>
</template>

<script>
  import Dialog from '../../components/dialog/Dialog';
  import Table from '../../components/table/Table';
  import Pagination from '../../components/pagination/Pagination';

  import {mapActions} from 'vuex';

  export default {
    name: "Header",
    components: {
      Dialog, Table, Pagination,
    },
    data() {
      return {
        personalInfoVisible: false,
        personInfoForm: {
          userPw: '',
          confirmPwd: ''
        },

        messageVisible: false,
        sendTimeSearch: [],
        msgLevelOptions: [],
        msgStatusOptions: [],
        tableData: [],
        search: {
          keyWord: '',
          startSendTime: null,
          endSendTime: null,
          msgLevel: '',
          msgStatus: 'SENDED',
        },
        pageInfo: {
          pageNum: "1",
          pageSize: "5",
          totalItems: "0",
          totalPages: "0",
          offSet: "0"
        },
        iconNum: '',


        defaultActive: '/case',
      }
    },
    mounted() {
      let vm = this;
      vm.initEnums();
      vm.initMessageNum();
    },
    methods: {
      ...mapActions(['removeUserInfo']),
      logout() {
        let vm = this;

        vm.$confirm('是否退出当前用户?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          vm.removeUserInfo();
          vm.$router.push('/login');
          vm.$api.loginOut({}).then(res => {
            vm.$message.success(res.msg);
          });
        }).catch(() => {
        });
      },
      resetPersonalInfoForm() {
        let vm = this;
        vm.$refs.personInfoForm.resetFields();
      },
      showPersonalInfo() {
        let vm = this;
        vm.personalInfoVisible = true;
      },
      savePersonInfo() {
        let vm = this;
        if (!vm.personInfoForm.userPw) {
          vm.$message.error('请设置密码');
          return;
        } else if (vm.personInfoForm.userPw !== vm.personInfoForm.confirmPwd) {
          vm.$message.error('密码输入不一致');
          return;
        }
        vm.$api.modifyPassword(vm.personInfoForm).then(res => {
          vm.$message.success(res.msg);
          vm.personalInfoVisible = false;
        })
      },
      showMessage() {
        let vm = this;
        vm.messageVisible = true;
        vm.getData();
      },
      initEnums() {
        let vm = this;
        vm.$api.getEnumsMap({enumsType: 'MsgLevel'}).then(res => {
          vm.msgLevelOptions = res.data;
        });
        vm.$api.getEnumsMap({enumsType: 'MsgStatus'}).then(res => {
          vm.msgStatusOptions = res.data;
        });
      },
      //获取数据
      getData(currentPage = '1') {
        let vm = this;
        vm.pageInfo.pageNum = currentPage;
        vm.$api.messageList({
          ...vm.search,
          ...vm.pageInfo,
        }).then(res => {
          if (vm.pageInfo.pageIndex !== '1' && res.data === null && res.data === []) {
            vm.getData('1');
          }
          vm.tableData = res.data;
          vm.pageInfo = res.pageInfo;
          vm.initMessageNum();
        })
      },
      //翻页
      currentChange(currentPage) {
        let vm = this;
        vm.getData(currentPage)
      },
      initMessageNum() {
        let vm = this;
        vm.$api.getSendedMessagesNum().then(res => {
          vm.iconNum = res.data;
        })
      },
    },
    watch: {
      sendTimeSearch(newVal, oldVal) {
        let vm = this;
        vm.search.startSendTime = null;
        vm.search.endSendTime = null;
        if (newVal) {
          vm.search.startSendTime = newVal[0];
          vm.search.endSendTime = newVal[1];
        }
      },
    },
    sockets: {
      connect() {
        let vm = this;
        vm.$socket.emit('userRegisterEvent', vm.$store.state.userInfo); // 全局刷新时，如果还在登陆状态会给后台发送登录通知
      },
      messageNotify(data) {
        let vm = this;
        vm.$notify.success({
          title: '提示',
          dangerouslyUseHTMLString: true,
          message: '<strong style="font-size:15px">你有一条新的待办任务，请及时处理</strong>',
          duration: 5000
        });
      }
    },
  }
</script>

<style lang='scss' scoped>
  $headerHeight: 60px;
  $headerBackgroundColor: #8D96D7;

  .Header {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    height: $headerHeight;
    width: 100%;
    background: $headerBackgroundColor;

    .left {
      flex: 3;

      img {
        height: 60px;
        float: left;
      }

      .title {
        height: $headerHeight;
        line-height: $headerHeight;
        font-size: 20px;
        margin-left: 20px;
        color: #FFFFFF;
        float: left;
      }
    }

    .center {
      flex: 4;

      /deep/ .el-menu-item {
        font-size: 17px;
      }
    }

    .right {
      /*flex: 4;*/
      text-align: right;
      /*float: right;*/
      display: flex;
      align-self: flex-end;

      .icon {
        height: $headerHeight;
        /*width: 150px;*/
        .iconfont {
          line-height: $headerHeight;
          font-size: 30px;
          color: #FFFFFF;
          margin-right: 20px;
          cursor: pointer;
        }

        .item {
          vertical-align: baseline;

          /deep/ .el-badge__content {
            top: 18px;
            right: 35px;
          }
        }
      }


      .info {
        height: $headerHeight;
        line-height: $headerHeight;
        font-size: 13px;
        color: #FFFFFF;
        margin-right: 20px;
      }
    }


    .search {
      margin-top: 2px;

      /deep/ .el-form-item {
        margin-bottom: 2px;

      }
    }

    .content {
      padding: 5px;

      /deep/ .el-table td {
        padding: 0;
      }
    }
  }
</style>
