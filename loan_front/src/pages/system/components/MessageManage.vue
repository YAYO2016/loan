<template>
  <div class='MessageManage'>
    <div class="search">
      <el-form ref="form" :model="search" size="mini" label-width="110px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="关键字：" prop="keyWord">
              <el-input v-model="search.keyWord" placeholder="请输入关键字" clearable/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="">
              <el-button @click="getData()" class="search-button">查询</el-button>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="发起人：" prop="createUserName">
              <el-input v-model="search.createUserName" placeholder="请输入发起人名字" clearable/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
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
          <el-col :span="12">
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
        <el-row>
          <el-col :span="12">
            <el-form-item label="发送状态：" prop="msgStatus">
              <el-select v-model="search.msgStatus" clearable>
                <el-option
                  v-for="item in msgStatusOptions"
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
    <div class="button">
      <el-button @click="dialogVisible = true; dialogView = false" size="small">创建通知</el-button>
    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="content">
      <Table :tableData="tableData" style="width: 100%">
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
          property="createUserName"
          label="创建人"
          width="80">
        </el-table-column>
        <el-table-column
          property="msgLevel"
          label="通知等级"
          width="90">
          <div slot-scope="scope">
            {{$util.StorageFn.getEnumDesc(msgLevelOptions,scope.row.msgLevel)}}
          </div>
        </el-table-column>
        <el-table-column
          property="msgStatus"
          label="发送状态"
          width="80">
          <div slot-scope="scope">
            {{$util.StorageFn.getEnumDesc(msgStatusOptions,scope.row.msgStatus)}}
          </div>
        </el-table-column>
        <el-table-column
          property="createTime"
          label="创建时间"
          width="140">
          <div slot-scope="scope">
            {{timeFormat(scope.row.createTime)}}
          </div>
        </el-table-column>
        <el-table-column
          property="sendTime"
          label="发送时间"
          width="140">
          <div slot-scope="scope">
            {{timeFormat(scope.row.sendTime)}}
          </div>
        </el-table-column>
        <el-table-column
          property="operator"
          label="操作"
          width="150px">
          <template slot-scope="scope">
            <el-button @click="view(scope.row.msgId)" type="text" size="small">查看</el-button>
            <el-button
              v-if="$store.state.userInfo.userId === scope.row.createUser && 'WAIT_SEND' === scope.row.msgStatus"
              @click="modify(scope.row.msgId)" type="text" size="small">修改
            </el-button>
            <el-button
              v-if="$store.state.userInfo.userId === scope.row.createUser && 'WAIT_SEND' === scope.row.msgStatus"
              @click="send(scope.row.msgId)" type="text" size="small">发送
            </el-button>
          </template>
        </el-table-column>
      </Table>
      <Pagination :total="pageInfo.totalItems"
                  @changePage="currentChange"
                  :currentPage="pageInfo.pageNum"
                  :pageSize="pageInfo.pageSize"/>
    </div>


    <div class="dialog">
      <!--  新增 + 修改-->
      <Dialog :title="'通知管理'"
              :show.sync="dialogVisible"
              @closedDialog="clearFormData"
      >
        <div>
          <div class="content">
            <el-form ref="addForm" :model="Form" size="mini" label-width="140px">
              <el-row>
                <el-col :span="24">
                  <el-form-item label="通知标题：" prop="msgTitle" :rules="$rules.NotEmpty">
                    <el-input v-model="Form.msgTitle" maxlength="50"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="通知内容：" prop="msgContent" :rules="$rules.NotEmpty">
                    <el-input type="textarea" v-model="Form.msgContent" maxlength="300"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="通知级别：" prop="msgLevel" :rules="$rules.NotEmpty">
                    <el-select v-model="Form.msgLevel" clearable>
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
          <div class="dialog-footer">
            <el-button @click="dialogVisible = false" size="mini">取消</el-button>
            <el-button v-if="!dialogView" @click="save('addForm')" size="mini">保存</el-button>
            <el-button v-if="!dialogView" @click="saveAndSend('addForm')" size="mini">发送</el-button>
            <el-button v-if="!dialogView" @click="initFormData" size="mini">重置</el-button>
          </div>
        </div>
      </Dialog>
    </div>
  </div>
</template>

<script>
  import Table from '../../../components/table/Table';
  import Dialog from '../../../components/dialog/Dialog';
  import Pagination from '../../../components/pagination/Pagination';

  export default {
    name: "MessageManage",
    data() {
      return {
        sendTimeSearch: [],
        msgLevelOptions: [],
        msgStatusOptions: [],

        search: {
          keyWord: '',
          createUserName: '',
          startSendTime: null,
          endSendTime: null,
          msgLevel: '',
          msgStatus: '',
        },

        tableData: [],
        pageInfo: {
          pageNum: "1",
          pageSize: "10",
          totalItems: "0",
          totalPages: "0",
          offSet: "0"
        },
        dialogVisible: false,
        dialogView: false,

        Form: {
          msgId: '',
          msgTitle: '',
          msgContent: '',
          msgLevel: '',
          msgStatus: '',
        },
      }
    },
    components: {
      Table, Dialog, Pagination
    },
    mounted() {
      let vm = this;
      vm.getData();
      vm.initEnums();
    },
    methods: {
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
        })
      },

      //翻页
      currentChange(currentPage) {
        let vm = this;
        vm.getData(currentPage)
      },

      initFormData() {
        let vm = this;
        vm.Form.msgTitle = '';
        vm.Form.msgContent = '';
        vm.Form.msgLevel = '';
      },

      clearFormData() {
        let vm = this;
        vm.Form.msgId = '';
        vm.Form.msgTitle = '';
        vm.Form.msgContent = '';
        vm.Form.msgLevel = '';
        vm.Form.msgStatus = '';
      },

      view(msgId) {
        let vm = this;
        vm.$api.getSingleMessage({msgId}).then(res => {
          vm.Form = res.data;
          vm.dialogView = true;
          vm.dialogVisible = true;
        })
      },
      modify(msgId) {
        let vm = this;
        vm.$api.getSingleMessage({msgId}).then(res => {
          vm.Form = res.data;
          vm.dialogView = false;
          vm.dialogVisible = true;
        })
      },
      send(msgId) {
        let vm = this;
        vm.$confirm('此操作不可撤销，确定发送消息吗？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          vm.$api.sendMessage({msgId}).then(res => {
            vm.$message.success(res.msg);
            vm.getData(this.pageInfo.pageIndex);
          });
        }).catch(() => {

        });
      },

      save(formName) {
        let vm = this;
        vm.$api.addOrUpdateSingleMessage(vm.Form).then(res => {
          if (200 === parseInt(res.status)) {
            vm.dialogVisible = false;
            vm.getData();
          }
        });
      },

      saveAndSend(formName) {
        let vm = this;
        vm.$confirm('此操作不可撤销，确定发送消息吗？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          vm.$api.addOrUpdateSingleMessage(vm.Form).then(res => {
            if (200 === parseInt(res.status)) {
              vm.dialogVisible = false;
              vm.$api.sendMessage({"msgId": res.data.msgId}).then(res => {
                vm.$message.success(res.msg);
                vm.getData(this.pageInfo.pageIndex);
              });
              vm.getData();
            }
          });
        }).catch(() => {

        });
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
    }
  }
</script>

<style lang='scss' scoped>
  .MessageManage {
    .search {
      margin-top: 2px;

      /deep/ .el-form-item {
        margin-bottom: 2px;

      }
    }

    .button {
      height: 35px;
      line-height: 35px;
      padding-left: 20px;
    }

    .content {
      padding: 5px;

      /deep/ .el-table td {
        padding: 0;
      }
    }
  }
</style>
