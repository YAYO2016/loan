<template>
  <div class='Home'>
    <div class="header">
      <Header></Header>
    </div>
    <div class="main">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
  import Header from '../../components/header/Header'

  export default {
    name: "Home",
    data(){
      return {

      }
    },
    components:{
      Header
    }
  }
</script>

<style lang="scss" scoped>
  $mainWidth: 1200px;
  .Home{
    display: flex;
    flex-direction: column;
    align-items: center;
    height: 100%;

    .header {
      width: 100%;
      min-width: $mainWidth;
    }
    .main {
      min-width: $mainWidth;
      width: 100%;
      /*border: 1px solid #D7D7D7;*/
      flex: 1 1 auto;
      position: relative;
    }

  }
</style>
