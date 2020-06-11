<template>
  <div class='Department'>
    <div class="achievement-detail">
      <el-card>
        <div class="clearfix" slot="header">
          <span>部门业绩概况</span>
        </div>
        <div>
          <el-row>
            <el-col :span="10" :offset="1">
              <div style="display: inline-block;text-align: center;position: relative;top: -10px;">
                <i class="iconfont icon-drxx45"></i>
              </div>
              <div style="margin-left: 30px;display: inline-block;line-height: 20px;">
                <div>部门名称：{{$store.state.userInfo.orgName}}</div>
                <div>负责人：{{}}</div>
                <div>电话：{{}}</div>
              </div>
            </el-col>
            <el-col :span="12">
              <el-col :span="5">
                <div class="item-detail" style="background: #999999;">
                  <div>员工数</div>
                  <div>20</div>
                </div>
              </el-col>
              <el-col :span="5">
                <div class="item-detail" style="background: #36A9CE">
                  <div>总签单数</div>
                  <div>20</div>
                </div>
              </el-col>
              <el-col :span="5">
                <div class="item-detail" style="background: #EF5AA1">
                  <div>总收入</div>
                  <div>20</div>
                </div>
              </el-col>
              <el-col :span="5">
                <div class="item-detail" style="background: #FFDF25">
                  <div>处理中案子数</div>
                  <div>20</div>
                </div>
              </el-col>
            </el-col>
          </el-row>
        </div>
      </el-card>
    </div>
    <div class="business-overview">
      <el-card>
        <div class="clearfix" slot="header">
          <span>业务概况--签单/收入</span>
        </div>
        <div>
          <el-form ref="form" :model="signRevenueForm" label-width="80px" size="mini">
            <el-form-item label="周期：">
              <el-radio-group v-model="signRevenueForm.period">
                <el-radio label="1">日</el-radio>
                <el-radio label="2">周</el-radio>
                <el-radio label="3">月</el-radio>
                <el-radio label="4">季度</el-radio>
                <el-radio label="5">年</el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="月份：">
              <el-date-picker
                v-model="signRevenueForm.time"
                value-format="yyyy-MM-dd HH:mm:ss"
                type="monthrange"
                align="right"
                unlink-panels
                range-separator="~"
                start-placeholder="开始月份"
                end-placeholder="结束月份"
                :picker-options="pickerOptions">
              </el-date-picker>
              <el-button @click="statistics">统计</el-button>
            </el-form-item>
          </el-form>
        </div>
        <div class="chart">
          <div id="signRevenueChart" :style="{width: '80%', height: '200px'}"></div>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Department",
    data() {
      return {
        signRevenueForm: {
          period: '3',
          time: [],
        },
        signRevenueFormSearch: {
          period: '',
          time: [],
        },
        pickerOptions: {
          shortcuts: [
          //   {
          //   text: '最近一周',
          //   onClick(picker) {
          //     const end = new Date();
          //     const start = new Date();
          //     start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
          //     picker.$emit('pick', [start, end]);
          //   }
          // },
            {
            text: '最近一个月',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
              picker.$emit('pick', [start, end]);
            }
          }, {
            text: '最近三个月',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
              picker.$emit('pick', [start, end]);
            }
          }]
        },
        initSignRevenueChartData: {},
      }
    },
    mounted() {
      let vm = this;
      vm.initSignRevenueChart();

    },
    methods: {
      initSignRevenueChart() {
        let vm = this;
        vm.signRevenueFormSearch = vm.signRevenueForm;
        vm.$api.departmentCasesCount({
          type: 2,
          period: vm.signRevenueFormSearch.period,
          startDate: vm.signRevenueFormSearch.time[0]
            ? vm.signRevenueFormSearch.time[0]
            : vm.$util.DateFn.formatTime(new Date().setMonth(new Date().getMonth() - 1), '{y}-{m}-{d} {h}:{i}:{s}'),
          endDate: vm.signRevenueFormSearch.time[1]
            ? vm.signRevenueFormSearch.time[1]
            : vm.$util.DateFn.formatTime(new Date().getTime(), '{y}-{m}-{d} {h}:{i}:{s}'),
        }).then(res => {
          vm.initSignRevenueChartData = res.data;
          vm.drawLine();
        })
      },
      drawLine() {
        let vm = this;
        // 基于准备好的dom，初始化echarts实例
        let signRevenueChart = this.$echarts.init(document.getElementById('signRevenueChart'));
        // 绘制图表
        signRevenueChart.setOption({
          // title: {text: '在Vue中使用echarts'},
          backgroundColor: {
            type: 'radial',
            x: 0.5,
            y: 0.5,
            r: 2.5,
            colorStops: [{
              offset: 0, color: '#595959' // 0% 处的颜色
            }, {
              offset: 1, color: '#292929' // 100% 处的颜色
            }],
            global: false // 缺省为 false
          },
          color: ['#3398DB'],
          grid: {
            x: '60px',
            x2: '20px',
            y: '30px',
            y2: '20px'
          },
          // legend: {
          //   data:["案子数"]
          // },
          xAxis: [{
            data: vm.initSignRevenueChartData.map(item => {
              switch (vm.signRevenueFormSearch.period) {
                case "1":  //日
                  return `${item.time.substring(0,4)}年${item.time.substring(4,6)}月${item.time.substring(6)}日`;
                case "2":  //周
                  return `${item.time.substring(0,4)}年第${item.time.substring(4,6)}周`;
                case "3":  //月
                  return `${item.time.substring(0,4)}年${item.time.substring(4)}月`;
                case "4":  //季度
                  return `${item.time.substring(0,4)}年第${item.time.substring(4)}季度`;
                case "5":  //年
                  return `${item.time.substring(0,4)}年`;
              }
            }),
            axisLine: {
              lineStyle: {
                color: '#FFFFFF',
                width: 1
              }
            }
          }],
          yAxis: [{
            type: 'value',
            axisLine: {
              lineStyle: {
                color: '#FFFFFF',
                width: 1
              }
            },
            name: '案子数',
            nameLocation: 'center'
          }],
          series: [{
            barWidth : 30,//柱图宽度
            type: 'bar',
            data: vm.initSignRevenueChartData.map(item => item.caseCount),
            itemStyle: {
              normal: {
                //柱子颜色渐变
                color: new this.$echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                  offset: 0,
                  color: '#5C81CB' //上面
                }, {
                  offset: 1,
                  color: '#2F62BB'  //下面
                }]),
                label: {
                  show: true, //开启显示
                  position: 'top', //在上方显示
                  textStyle: { //数值样式
                    color: '#FFFFFF',
                    fontSize: 12
                  }
                }
              },
            }
          }]
        });
      },
      statistics() {
        let vm = this;
        vm.initSignRevenueChart();
      }
    }
  }
</script>

<style lang='scss' scoped>
  .Department {
    padding: 10px;

    .iconfont {
      font-size: 40px;
      display: inline-block;
    }

    .business-overview {
      margin-top: 10px;
    }

    .chart {
      padding: 10px;
    }

    .item-detail {
      height: 80px;
      text-align: center;
      /*font-weight: 700;*/
      box-sizing: border-box;
      padding-top: 25px;
    }
  }
</style>
