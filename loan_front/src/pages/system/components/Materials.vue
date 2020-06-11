<template>
  <div class='Materials'>
    <div class="search">
      材料名称：
<!--      <el-select v-model="search.materialBelong" clearable>-->
<!--        <el-option-->
<!--          v-for="item in materialOptions"-->
<!--          :key="item.code"-->
<!--          :label="item.desc"-->
<!--          :value="item.code">-->
<!--        </el-option>-->
<!--      </el-select>-->
      <el-input style="width: 500px" v-model="search.input" placeholder="请输入材料名称" clearable/>
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
          property="materialName"
          label="材料名称"
          width="">
        </el-table-column>
<!--        <el-table-column-->
<!--          property="materialBelong"-->
<!--          label="材料提供方"-->
<!--          :formatter="rowMaterialBelong"-->
<!--          column-key="materialBelong"-->
<!--          width="">-->
<!--        </el-table-column>-->
        <el-table-column
          property="materialType"
          label="材料类型"
          :formatter="rowMaterialType"
          column-key="materialType"
          width="">
        </el-table-column>
        <el-table-column
          property="operator"
          label="操作"
          width="200px">
          <template slot-scope="scope">
            <el-button @click="see(scope.row.materialId)" type="text" size="small">查看</el-button>
            <el-button @click="modify(scope.row.materialId)" type="text" size="small">修改</el-button>
            <el-button @click="del(scope.row.materialId)" type="text" size="small">删除</el-button>
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
                <el-col :span="12">
                  <el-form-item label="材料名称：" prop="materialName" :rules="$rules.NotEmpty">
                    <el-input v-model="Form.materialName"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="材料类型：" prop="materialType" :rules="$rules.NotEmpty">
                    <el-select v-model="Form.materialType">
                      <el-option
                        v-for="item in materialTypeOptions"
                        :key="item.code"
                        :label="item.desc"
                        :value="item.code">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
<!--              <el-row>-->
<!--                <el-col :span="12">-->
<!--                  <el-form-item label="材料提供方：" prop="materialBelong" :rules="$rules.NotEmpty">-->
<!--                    <el-select v-model="Form.materialBelong">-->
<!--                      <el-option-->
<!--                        v-for="item in materialOptions"-->
<!--                        :key="item.code"-->
<!--                        :label="item.desc"-->
<!--                        :value="item.code">-->
<!--                      </el-option>-->
<!--                    </el-select>-->
<!--                  </el-form-item>-->
<!--                </el-col>-->
<!--                <el-col :span="12">-->
<!--                  <el-form-item label="材料类型：" prop="materialType" :rules="$rules.NotEmpty">-->
<!--                    <el-select v-model="Form.materialType">-->
<!--                      <el-option-->
<!--                        v-for="item in materialTypeOptions"-->
<!--                        :key="item.code"-->
<!--                        :label="item.desc"-->
<!--                        :value="item.code">-->
<!--                      </el-option>-->
<!--                    </el-select>-->
<!--                  </el-form-item>-->
<!--                </el-col>-->
<!--              </el-row>-->
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
    </div>

    <Dialog :title="''"
            :show.sync="seeVisible"
            @closedDialog="Form=formDemo()"
    >
      <div>
        <div class="content">
          <el-form ref="seeForm" :model="Form" size="mini" label-width="120px">
            <el-row>
              <el-col :span="12">
                <el-form-item label="材料名称：" prop="materialName">
                  <el-input v-model="Form.materialName" disabled></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="材料类型：" prop="managerPhone">
                  <el-select v-model="Form.materialType" disabled>
                    <el-option
                      v-for="item in materialTypeOptions"
                      :key="item.code"
                      :label="item.desc"
                      :value="item.code">
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
<!--            <el-row>-->
<!--              <el-col :span="12">-->
<!--                <el-form-item label="材料提供方：" prop="managerName">-->
<!--                  <el-select v-model="Form.materialBelong" disabled>-->
<!--                    <el-option-->
<!--                      v-for="item in materialOptions"-->
<!--                      :key="item.code"-->
<!--                      :label="item.desc"-->
<!--                      :value="item.code">-->
<!--                    </el-option>-->
<!--                  </el-select>-->
<!--                </el-form-item>-->
<!--              </el-col>-->
<!--              <el-col :span="12">-->
<!--                <el-form-item label="材料类型：" prop="managerPhone">-->
<!--                  <el-select v-model="Form.materialType" disabled>-->
<!--                    <el-option-->
<!--                      v-for="item in materialTypeOptions"-->
<!--                      :key="item.code"-->
<!--                      :label="item.desc"-->
<!--                      :value="item.code">-->
<!--                    </el-option>-->
<!--                  </el-select>-->
<!--                </el-form-item>-->
<!--              </el-col>-->
<!--            </el-row>-->
          </el-form>
        </div>
        <hr style="border: 0.5px solid #D7D7D7">
        <div class="dialog-footer">
          <el-button @click="seeVisible = false" size="mini">返回</el-button>
        </div>
      </div>
    </Dialog>

  </div>
</template>

<script>
  import Table from '../../../components/table/Table';
  import Dialog from '../../../components/dialog/Dialog';
  import Pagination from '../../../components/pagination/Pagination';

  export default {
    name: "Materials",
    data() {
      return {
        search: {
          input: '',
          bankId: ''
        },
        searchKey: {
          input: '',
          bankId: ''
        },
        pageInfo: {
          pageIndex: "1",
          pageSize: "10",
          totalItems: "0",
          totalPages: "0",
          offSet: "0"
        },
        tableData: [],
        materialOptions: [],
        materialTypeOptions:[],
        addVisible: false,
        Form: this.formDemo(),
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
      // vm.$api.getEnumsMap({enumsType:'MaterialBelong'}).then(res=>{
      //   vm.materialOptions = res.data;
      // });
      vm.$api.getEnumsMap({enumsType:'MaterialType'}).then(res=>{
        vm.materialTypeOptions = res.data;
      });
      vm.getData();
    },
    methods: {
      initFormData() {
        let vm = this;
        vm.Form = vm.formDemo();
        vm.$refs.addForm.resetFields();
      },
      formDemo() {
        return {
          materialId: "",
          materialName: "",
          // materialBelong: "",
          materialType: "",
          createUser: ""
        }
      },
      //获取数据
      getData(currentPage = '1') {
        let vm = this;
        vm.pageInfo.pageIndex = currentPage;
        vm.$api.materialsList({
          // materialBelong: vm.searchKey.materialBelong,
          materialName: vm.searchKey.input,
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
      filterHandler(value, row, column){
        const property = column['property'];
        return row[property] === value;
      },
      //搜索
      handleSearch(input) {
        let vm = this;
        vm.searchKey.input = input;
        // vm.searchKey.materialBelong = materialBelong;
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
          vm.$api.addOrUpdateSingleMaterial(vm.Form).then(res => {
            vm.$message.success(res.msg);
            vm.addVisible = false;
            vm.getData(this.pageInfo.pageIndex);
          })
        }
      },
      see(materialId) {
        let vm = this;
        vm.$api.getSingleMaterial({materialId}).then(res => {
          vm.Form = res.data;
          vm.seeVisible = true;
        })
      },
      modify(materialId) {
        let vm = this;
        vm.$api.getSingleMaterial({materialId}).then(res => {
          vm.Form = res.data;
          vm.addVisible = true;
        })
      },
      del(materialId) {
        let vm = this;
        vm.$confirm('此操作将永久删除该条数据, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          vm.$api.deleteMaterial({materialId}).then(res => {
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
  .Materials {
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
