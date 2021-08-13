<template>
  <div id="app">

    <div class="container">
      <form>

          <label>Owner Name:</label>
          <input type="text" disabled=true :value=owner_name>
          <label>Pet Name:</label>
          <input type="text" disabled=true :value=cache_pet.name>
          <label>Date:</label>
          <input type="text" disabled=true :value=testVisit.date>

          <button @click="redirect()" class="waves-effect waves-light btn-small">Voltar para owners<i class="material-icons left">assignment_return</i></button>

      </form>
    </div>

  </div>
</template>

<script>
  import Visit from '../services/visit'

  export default {

    data(){
      return {
        cache_pet: {
            id: '',
            name: '',
            birthDate: '',
            type: '',
            ownerId: ''
        },
        testVisit: {
            id: '',
            ownerId: '',
            petId: '',
            vetId: '',
            date: '',
            description: '',
            status: ''
        },
        owner_name: null,
      }
    },

    mounted(){
      this.cache_pet = JSON.parse(localStorage.getItem("cache-pet"));
      this.owner_name = localStorage.getItem("owner-name");
      Visit.salvar(this.cache_pet).then(resposta=>{
          this.testVisit = resposta.data;
      });   
    },

    methods:{

      redirect(){
        this.$router.push(this.$route.query.redirect || "/Owner");
      }

    }

  }

</script>

<style>

</style>
