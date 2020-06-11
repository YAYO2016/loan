<template>
  <div class='Company'>
    <div class="achievement-detail">
      <el-card>
        <div class="clearfix" slot="header">
          <span>公司业绩概况</span>
        </div>
        <div>
          <el-row>
            <el-col :span="12">

            </el-col>
            <el-col :span="12"></el-col>
          </el-row>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Company",
    mounted(){
      this.$store.state.userInfo?null:this.$router.push('/login');
    },
    data() {
      return {}
    },
    methods: {}
  }
</script>

<style lang='scss' scoped>
  .Company {
    padding: 10px;
  }
</style>
