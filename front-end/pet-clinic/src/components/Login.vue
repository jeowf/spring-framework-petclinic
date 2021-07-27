<template>
  <div id="app">
    <div class="container">
      <form @submit.prevent="login">
        <label>Username</label>
        <input type="text" placeholder="Username" v-model="user.username" />
        <label>Password</label>
        <input type="password" placeholder="Password" v-model="user.password" />

        <button class="waves-effect waves-light btn-small">
          Login<i class="material-icons left">login</i>
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import Auth from '@/services/auth'

export default {

  data(){
    return {
      user: {
        id : '',
        name : '',
        username : '',
        password : '',
        role : ''
      },
      users: []
    }
  },

  mounted(){
    
  },

  methods:{
    login(){
      Auth.login(this.user).then(resposta => {
        console.log(resposta.data)
      })
    }
  }

}

</script>

<style>
</style>