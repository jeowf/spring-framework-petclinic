<template>
  <div class="container">
    <a> <router-link to="/login"> Login </router-link> </a>
    <a> <router-link to="/register"> Register </router-link> </a>
    <a> <router-link to="/vet"> Veterinário </router-link> </a>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data: function () {
    return {
      user_id: localStorage.getItem('user-id')
    }
  },
  

}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
