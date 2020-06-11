<template>
  <div class='Feels'>
    <div class="search">
      费用科目名称：
      <el-input style="width: 500px" v-model="search.input" placeholder="请输入费用科目名称" clearable/>
      <el-button @click="handleSearch(search.input)">查询</el-button>
    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="button">
      <el-button @click="addVisible = true">新增</el-button>
    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="content">
      <Table :tableData="tableData" style="width: 100%">
        <el-table-column
          property="itemName"
          label="费用科目名称"
          width="100">
        </el-table-column>
        <el-table-column
          property="itemDesc"
          label="费用科目说明"
          width="">
        </el-table-column>
        <el-table-column
          property="itemPrice"
          label="费用科目单价"
          :formatter="rowItemNoPoint"
          width="">
        </el-table-column>
        <el-table-column
          property="itemRate"
          label="成本扣点率"
          :formatter="rowItemRate"
          width="">
        </el-table-column>
        <el-table-column
          property="operator"
          label="操作"
          width="200px">
          <template slot-scope="scope">
            <el-button @click="see(scope.row.itemId)" type="text" size="small">查看</el-button>
            <el-button @click="modify(scope.row.itemId)" type="text" size="small">修改</el-button>
            <el-button @click="del(scope.row.itemId)" type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </Table>
      <Pagination :total="pageInfo.totalItems"
                  @changePage="currentChange"
                  :currentPage="pageInfo.pageIndex"
                  :pageSize="pageInfo.pageSize"/>
    </div>


    <div class="dialog">
      <!--  新增 + 修改-->
      <Dialog :title="''"
              :show.sync="addVisible"
              @closedDialog="initFormData"
      >
        <div>
          <div class="content">
            <el-form ref="addForm" :model="Form" size="mini" label-width="140px">
              <el-row>
                <el-col :span="24">
                  <el-form-item label="费用科目名称：" prop="itemName"  :rules="$rules.NotEmpty">
                    <el-input v-model="Form.itemName"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="费用科目说明：" prop="itemDesc" :rules="$rules.NotEmpty">
                    <el-input type="textarea" v-model="Form.itemDesc"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="12">
                  <el-form-item label="费用科目单价：" prop="itemPrice" :rules="$rules.NotEmpty">
                    <el-input type="number" v-model.number="Form.itemPrice"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="费用科目扣点率：" prop="itemRate" :rules="$rules.NotEmpty">
                    <el-input type="number" v-model.number="Form.itemRate" style="width: 100px"></el-input>&nbsp;%
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="是否必选：" prop="optional" :rules="$rules.NotEmpty">
                  <el-select v-model="Form.optional">
                    <el-option
                      v-for="item in optionalOptions"
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
            <el-button @click="addVisible = false" size="mini">取消</el-button>
            <el-button @click="save('addForm')" size="mini">保存</el-button>
            <el-button @click="initFormData" size="mini">重置</el-button>
          </div>
        </div>
      </Dialog>

      <!-- 查看 -->
      <Dialog :title="''"
              :show.sync="seeVisible"
              @closedDialog="Form=feelsForm()"
      >
        <div>
          <div class="content">
            <el-form ref="seeForm" :model="Form" size="mini" label-width="140px">
              <el-row>
                <el-col :span="24">
                  <el-form-item label="费用科目名称：" prop="itemName">
                    <el-input v-model="Form.itemName" disabled></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="费用科目说明：" prop="itemDesc">
                    <el-input type="textarea" v-model="Form.itemDesc" disabled></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="12">
                  <el-form-item label="费用科目单价：" prop="itemPrice">
                    <el-input v-model="Form.itemPrice" disabled></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="费用科目扣点率：" prop="itemRate">
                    <el-input v-model="Form.itemRate" style="width: 100px" disabled></el-input>&nbsp;%
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24">
                  <el-form-item label="是否必选：" prop="optional">
                    <el-select v-model="Form.optional" disabled>
                      <el-option
                        v-for="item in optionalOptions"
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
            <el-button @click="seeVisible = false" size="mini">返回</el-button>
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
    name: "Feels",
    data() {
      return {
        search: {
          input: ''
        },
        searchKey: {
          input: ''
        },
        pageInfo: {
          pageIndex: "1",
          pageSize: "10",
          totalItems: "0",
          totalPages: "0",
          offSet: "0"
        },
        tableData: [],
        optionalOptions:[],
        addVisible: false,
        Form: this.feelsForm(),
        //查看渠道
        seeVisible: false,
        //修改渠道
        modifyVisible: false
      }
    },
    components: {
      Table, Dialog, Pagination
    },
    mounted() {
      let vm = this;
      vm.$api.getEnumsMap({enumsType:'FeeItemOptional'}).then(res=>{
        vm.optionalOptions = res.data;
      });
      vm.getData();
    },
    methods: {
      initFormData() {
        let vm = this;
        vm.Form = vm.feelsForm();
        vm.$refs.addForm.resetFields();
      },
      feelsForm(){
        return {
          itemId: '',
          itemName: '',
          itemDesc: '',
          itemPrice: '',
          itemRate: '',
          optional: '',
        }
      },
      //获取数据
      getData(currentPage = '1') {
        let vm = this;
        vm.pageInfo.pageIndex = currentPage;
        vm.$api.feelsList({
          itemName: vm.searchKey.input,
          pageNum: vm.pageInfo.pageIndex,
          pageSize: vm.pageInfo.pageSize,
        }).then(res => {
          if (vm.pageInfo.pageIndex !== '1' && res.data === null && res.data === []) {
            vm.getData('1');
          }
          vm.tableData = res.data;
          vm.pageInfo = res.pageInfo;
        })
      },
      //搜索
      handleSearch(input) {
        let vm = this;
        vm.searchKey.input = input;
        vm.getData();
      },
      //翻页
      currentChange(currentPage) {
        let vm = this;
        vm.getData(currentPage)
      },
      //新增 -- 保存
      save(formName) {
        let vm = this;
        if (vm.validateRules(formName, vm)) {
          vm.$api.addOrUpdateSingleFeeItem(vm.Form).then(res => {
            vm.$message.success(res.msg);
            vm.addVisible = false;
            this.$refs.addForm.resetFields();
            vm.getData(this.pageInfo.pageIndex);
          })
        }
      },
      see(itemId) {
        let vm = this;
        vm.$api.getSingleFeeItem({itemId}).then(res => {
          vm.Form = res.data;
          vm.seeVisible = true;
        })
      },
      modify(itemId) {
        let vm = this;
        vm.$api.getSingleFeeItem({itemId}).then(res => {
          vm.Form = res.data;
          vm.addVisible = true;
        })
      },
      del(itemId) {
        let vm = this;
        vm.$confirm('此操作将永久删除该条数据, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          vm.$api.deleteFeeItem({itemId}).then(res => {
            vm.$message.success(res.msg);
            vm.getData(this.pageInfo.pageIndex);
          });
        }).catch(() => {

        });
      },
    }
  }
</script>

<style lang='scss' scoped>
  .Feels {
    .search {
      height: 60px;
      line-height: 60px;
      margin-left: 20px;
    }

    .button {
      height: 60px;
      line-height: 60px;
      margin-left: 20px;
    }

    .content {
      padding: 20px;
    }
  }
</style>
