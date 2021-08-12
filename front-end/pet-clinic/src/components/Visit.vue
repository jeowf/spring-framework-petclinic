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
          <label>Descrição:</label>
          <input type="text" disabled=true :value=testVisit.description>

          <button @click="redirect()" class="waves-effect waves-light btn-small">Confirmar<i class="material-icons left">save</i></button>

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
        cache_payment: {
            id: '',
            visitId: '',
            value: '',
            status: '',
        },
        owner_name: null,
        resposta: null
      }
    },

    mounted(){
      this.cache_pet = localStorage.getItem("cache-pet");
      this.owner_name = localStorage.getItem("owner-name");
      this.resposta = Visit.salvar(this.cache_pet);
      console.log(this.resposta);
      this.testVisit = this.resposta.data.visit;
      this.cache_payment = this.resposta.data.payment
    },

    methods:{

      redirect(){
        localStorage.setItem("payment-cache", this.cache_payment);
        this.$router.push(this.$route.query.redirect || "/");
      }

    }

  }

</script>

<style>

</style>
