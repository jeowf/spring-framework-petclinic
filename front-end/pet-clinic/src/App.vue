<template>

  <nav>
    <div class="nav-wrapper">
      <a href="#" class="brand-logo">Pet Clinic</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="sass.html">Sass</a></li>
        <li><a href="badges.html">Components</a></li>
        <li><a href="collapsible.html">JavaScript</a></li>
      </ul>
    </div>
  </nav>



 <div id="app"> 
  <router-view> </router-view>
</div>

</template>

<script>
export default {
  name: 'app'
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
