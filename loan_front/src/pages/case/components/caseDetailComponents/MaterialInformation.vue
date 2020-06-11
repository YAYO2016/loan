<template>
  <div class='MaterialInformation'>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="buttons">
      <el-button size="mini" @click="getData">重置</el-button>
      <el-button size="mini" @click="save">保存</el-button>
      <el-button size="mini" @click="next">下一步</el-button>
    </div>
    <hr style="border: 0.5px solid #D7D7D7">
    <div class="form">
      <el-form ref="form" :model="form" size="mini" label-width="160px">
        <Table
          :tableData="form.materialInfo" style="width: 100%"
        >
          <el-table-column
            width="50">
            <template slot-scope="scope">
              <span>
                <i class="el-icon-remove" style="color: red;font-size: 20px;cursor: pointer"
                   @click="delMaterial(scope.row.materialId)"></i>
              </span>
            </template>
          </el-table-column>
          <el-table-column
            property="materialName"
            label="材料名称"
            width="80"
          ></el-table-column>
          <el-table-column
            property="materialBelong"
            label="材料归属"
          >
            <template slot-scope="scope">
              <el-select size="mini" v-model="form.materialInfo[scope.$index].materialBelong">
                <el-option v-for="item in $store.state.materialBelongOptions" :value="item.code" :label="item.desc"
                           :key="item.code"></el-option>
              </el-select>
            </template>
          </el-table-column>
<!--          <el-table-column-->
<!--            property="materialBelong"-->
<!--            label="材料归属"-->
<!--            width="70px"-->
<!--            :formatter="rowMaterialBelong"-->
<!--          ></el-table-column>-->
          <el-table-column
            property="materialCount"
            label="数量"
            width="70"
          >
            <template slot-scope="scope">
              <el-input size="mini" v-model="form.materialInfo[scope.$index].materialCount"></el-input>
            </template>
          </el-table-column>
          <el-table-column
            property="materialType"
            :formatter="rowMaterialType"
            label="材料类型"
            width="70"
          ></el-table-column>
          <el-table-column
            property="materialStatus"
            label="状态"
            width="110"
          >
            <template slot-scope="scope">
              <el-select size="mini" v-model="form.materialInfo[scope.$index].materialStatus">
                <el-option label="已提供" value="PROVIDED"></el-option>
                <el-option label="未提供" value="NOT_PROVIDED"></el-option>
              </el-select>
            </template>
          </el-table-column>
          <el-table-column
            property="raiseTime"
            label="提出时间"
            width="150"
          >
            <template slot-scope="scope">
              <el-date-picker
                style="width: 100%"
                size="mini"
                value-format="timestamp"
                v-model="form.materialInfo[scope.$index].raiseTime"
                placeholder="选择日期"
              >
              </el-date-picker>
            </template>
          </el-table-column>
          <el-table-column
            property="promiseTime"
            label="承诺时间"
            width="150"
          >
            <template slot-scope="scope">
              <el-date-picker
                style="width: 100%"
                size="mini"
                value-format="timestamp"
                v-model="form.materialInfo[scope.$index].promiseTime"
                placeholder="选择日期"
              >
              </el-date-picker>
            </template>
          </el-table-column>
          <el-table-column
            property="deliveryTime"
            label="送达时间"
            width="150"
          >
            <template slot-scope="scope">
              <el-date-picker
                style="width: 100%"
                size="mini"
                value-format="timestamp"
                v-model="form.materialInfo[scope.$index].deliveryTime"
                placeholder="选择日期"
              >
              </el-date-picker>
            </template>
          </el-table-column>
          <el-table-column
            property="materialRemark"
            label="备注"
            width=""
          >
            <template slot-scope="scope">
              <el-input
                type="textarea"
                size="mini"
                autosize
                v-model="form.materialInfo[scope.$index].materialRemark"
              ></el-input>
            </template>
          </el-table-column>
        </Table>
        <div style="margin-top:10px">
          <el-button @click="addMaterial" size="small">添加新材料</el-button>
        </div>
      </el-form>
    </div>
    <div class="dialog">
      <Dialog
        :title="'请选择材料'"
        :show.sync="formVisible"
        @closedDialog="searchKey.input='';search.input='';">
        <div>
          <el-row>
            <el-col>
              <el-input v-model="search.input" size="small" placeholder="请输入材料名称">
              <el-button slot="append" @click="handleSearch(search.input)">搜索</el-button>
              </el-input>
            </el-col>
          </el-row>
          <Split></Split>
          <el-row>
            <el-col>
              <Table
                :tableData="tableData" style="width: 100%"
              >
                <el-table-column
                  property="materialName"
                  label="材料名称"
                  width="">
                </el-table-column>
<!--                <el-table-column-->
<!--                  property="materialBelong"-->
<!--                  label="材料归属"-->
<!--                  :formatter="rowMaterialBelong"-->
<!--                  width="">-->
<!--                </el-table-column>-->
                <el-table-column
                  property="materialType"
                  label="材料类型"
                  :formatter="rowMaterialType"
                  width="">
                </el-table-column>
                <el-table-column
                  property="operator"
                  label="操作"
                  width="70">
                  <template slot-scope="scope">
                    <el-button @click="select(scope.row.materialId)" type="text" size="small">选择</el-button>
                  </template>
                </el-table-column>
              </Table>
            </el-col>
          </el-row>
        </div>
      </Dialog>
    </div>
  </div>
</template>

<script>
  import Dialog from '../../../../components/dialog/Dialog';
  import Table from '../../../../components/table/Table';
  import Split from '../../../../components/split/Split';

  export default {
    name: "MaterialInformation",
    components: {Dialog, Table, Split},
    data() {
      return {
        form: this.formDemo(),
        search: {
          input: '',
        },
        searchKey: {
          input: '',
        },
        formVisible: false,
        tableData: []
      }
    },
    mounted() {
      let vm = this;
      //初始化数据
      vm.$refs.form.resetFields();
      this.getData();
    },
    methods: {
      getData() {
        let vm = this;
        vm.$refs.form.resetFields();
        vm.$api.getCaseMaterialCfgInfo({caseId: this.$route.params.caseId}).then(res => {
          vm.form = {...vm.form, ...res.data};
          if (vm.form.materialInfo === null) {  //初始数据
            vm.form.materialInfo = this.formDemo().materialInfo;
          }
        });
      },
      formDemo() {
        return {
          caseId: "",
          materialInfo: []
        }
      },
      addMaterial() {
        let vm = this;
        vm.$api.materialsList({
          materialName: vm.searchKey.input,
          // materialBelong: "",
          pageNum: 1,
          pageSize: 99999,
        }).then(res => {
          vm.tableData = res.data;
          vm.formVisible = true;
        })
      },
      handleSearch(input) {
        let vm = this;
        vm.searchKey.input = input;
        vm.addMaterial();
      },
      select(materialId) {
        let vm = this;
        vm.$api.getSingleMaterial({materialId}).then(res => {
          // let lenOld = vm.form.materialInfo.length;
          vm.form.materialInfo.push(res.data);
          // vm.form.materialInfo = vm.$util.ArrayFn.arrObjUnique(vm.form.materialInfo, 'materialId');
          // let lenNew = vm.form.materialInfo.length;
          // if (lenOld == lenNew) {
          //   vm.$message.info('该材料已存在！');
          // }
        });
        vm.formVisible = false;
      },
      delMaterial(materialId) {
        let vm = this;
        vm.form.materialInfo = vm.$util.ArrayFn.delObjArr(vm.form.materialInfo, materialId, 'materialId');
      },
      save() {
        let vm = this;
        this.$api.saveCaseMaterialCfgInfo(this.form).then(res => {
          this.$router.push(
            {
              path: `/case/caseDetail/materialInformation/${this.$route.params.caseId}`,
              query: {
                caseSubType: vm.$route.query.caseSubType
              }
            }
          );
          this.$message.success(res.msg);
          this.getData();
        })
      },
      next() {
        let vm = this;
        this.$api.saveCaseMaterialCfgInfo(this.form).then(res => {
          this.$router.push({
            path: `/case/caseDetail/feelInformation/${this.$route.params.caseId}`,
            query: {
              caseSubType: vm.$route.query.caseSubType
            }
          });
          this.$message.success(res.msg);
        })
      }
    }
  }
</script>

<style lang='scss' scoped>
  .MaterialInformation {
    .buttons {
      margin: 10px 20px;
    }

    .form {
      margin: 10px;

      /deep/ .el-input, .el-select ,.el-textarea{
        vertical-align: middle;
      }
    }
  }
</style>
