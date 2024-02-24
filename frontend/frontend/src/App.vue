<template>
  <Navbar/>

  
  <div id="router-container">
    <routerView></routerView>
  </div>
  
</template>

<script>

import Navbar from './components/NavbarComponent.vue'

export default {
  name: 'App',
  components: {
    Navbar
  }
}
</script>

<style>

</style>
