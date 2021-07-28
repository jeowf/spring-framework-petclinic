<template>
  <div id="app">
    <div class="container">
      <form @submit.prevent="salvar">
        <label>Name</label>
        <input type="text" placeholder="Name" v-model="user.name"/>
        <label>Username</label>
        <input type="text"  placeholder="Username" v-model="user.username"/>
        <label>Password</label>
        <input type="password" placeholder="Address" v-model="user.password" />
        <button class="waves-effect waves-light btn-small"> Register <i class="material-icons left">save</i> </button>
      </form>
    </div>
  </div>
</template>

<script>
import User from '../services/user'

  export default {

    data(){
      return {
        user: {
          id: '',
          name: '',
          username: '',
          password: '',
          role: ''
        },
        users: []
      }
    },

    mounted(){
      this.listar()
    },

    methods:{

      listar(){
          User.listar().then(resposta => {
          this.users = resposta.data
        })
      },

      salvar(){
            this.user.role = "client"
            User.salvar(this.user).then(resposta=>{
            resposta.data
            this.$router.push(this.$route.query.redirect || "/login");
          })
      },
    }

  }
</script>

<style>
</style>