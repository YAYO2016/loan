<template>
  <div class="m-pagination">
    <el-pagination
      background
      layout="prev,pager,next,total"
      :total="Number(total)"
      @current-change="currentChange"
      :current-page="Number(currentPage)"
      :page-size="Number(pageSize)">
    </el-pagination>
  </div>
</template>

<script>
  export default {
    name: 'Pagination',
    data() {
      return {}
    },
    props: {
      total: {
        type: String,
        default: "0"
      },
      currentPage: {
        type: String,
        default: "1"
      },
      pageSize: {
        type: String,
        default: "10"
      }
    },
    methods: {
      currentChange(page) {
        let vm = this;
        vm.$emit('changePage', page);
      }
    }
  }
</script>

<style lang="scss" scoped>
  .m-pagination {
    text-align: center;
    margin-top: 20px;
  }
</style>
