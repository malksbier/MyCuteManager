<template>

  <nav class="navbar bg-body-tertiary">
      <div class="row">
        <div class="col">
          <router-link to="/" class="nav-link active">Home</router-link>
        </div>
        <div class="col">
          <router-link to="/topics" class="nav-link active">Topics</router-link>
        </div>
        <div class="col">
          <router-link to="/rules" class="nav-link active">Rules</router-link>
        </div>
        <div class="col-3 float-end">
          <router-link to="/about" class="nav-link active ">About</router-link>
        </div>
        
      </div>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      
    }
  }
}
</script>
