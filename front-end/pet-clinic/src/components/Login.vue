<template>
  <div id="app">
    <div class="container dim">
      <br />
      <br />
      <br />
      
      <form @submit.prevent="login">
        <input type="text" placeholder="Username" v-model="user.username" />
        <input type="password" placeholder="Password" v-model="user.password" />

        <button class="waves-effect waves-light btn-small">
          Login<i class="material-icons left">login</i>
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import Auth from "@/services/auth";

export default {
  data() {
    return {
      user: {
        id: "",
        name: "",
        username: "",
        password: "",
        role: "",
      },
      users: [],
    };
  },

  mounted() {},

  methods: {
    login() {
      Auth.login(this.user).then((resposta) => {
        console.log(resposta.data);
        if (resposta.data) {
          this.$router.push(this.$route.query.redirect || "/");
          localStorage.setItem("user-id", resposta.data.id);
          localStorage.setItem("user-role", resposta.data.role);
          localStorage.setItem("logged", true);
        }
      });
    },
  },
};
</script>

<style>
.dim{
    width: 40% !important;

}
</style>