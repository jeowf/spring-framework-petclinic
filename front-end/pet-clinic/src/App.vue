<template>

  <nav>
    <div class="nav-wrapper">
      <a href="#" class="brand-logo"> <router-link to="/"> Pet Clinic </router-link></a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a> <router-link to="/Owner"> Owner </router-link> </a></li>
        <li><a> <router-link to="/Client"> Client </router-link> </a></li>
        <li><a> <router-link to="/Vet"> Vet </router-link> </a></li>
      </ul>
    </div>
  </nav>



 <div id="app"> 
  <router-view> </router-view>
</div>

</template>

<script>
export default {
  name: 'app',
  data() {
    return {
      //logged: localStorage.getItem("logged")
    };
  },
  methods: {
    loggout: function () {
      localStorage.setItem("logged", false)
      localStorage.removeItem("user-id")
      localStorage.removeItem("user-role")
    },
    loggoutcheck: function () {
      return this.$router.history.current["path"].includes("login");
    }
  }
}
/*
import Auth from './services/auth'

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
    Auth.all().then(resposta => {
      console.log(resposta.data)
    })
  },

  methods:{
    login(){
      Auth.login(this.user).then(resposta => {
        console.log(resposta.data.role)
      })
    }
  }

}
*/
</script>

<style>

nav{
  background-color:rgb(54, 184, 162)
}

</style>
