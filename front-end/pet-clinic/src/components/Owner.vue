<template>
  <div id="app">

    <div class="container">
      <form @submit.prevent="salvar">

          <label>First Name</label>
          <input type="text" placeholder="First Name" v-model="testOwner.firstName">
          <label>Last Name</label>
          <input type="text" placeholder="Last Name" v-model="testOwner.lastName">
          <label>Address</label>
          <input type="text" placeholder="Address" v-model="testOwner.address">
          <label>City</label>
          <input type="text" placeholder="City" v-model="testOwner.city">
          <label>Telephone</label>
          <input type="text" placeholder="Telephone" v-model="testOwner.telephone">

          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

      </form>

      <table>

        <thead>

          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th>City</th>
            <th>Telephone</th>
          </tr>

        </thead>

        <tbody>

            <tr v-for="owner of owners" :key="owner.id">

            <td>{{ owner.firstName }}</td>
            <td>{{ owner.lastName }}</td>
            <td>{{ owner.address }}</td>
            <td>{{ owner.city }}</td>
            <td>{{ owner.telephone }}</td>
            <td>
              <button @click="editar(owner)" class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button @click="remover(owner)" class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
              <button @click="redirect(owner)" class="waves-effect btn-small black darken-1"><i class="material-icons">pets</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>

    </div>

  </div>
</template>

<script>
  import Owner from '../services/owner'

  export default {

    data(){
      return {
        testOwner: {
          id: '',
          firstName: '',
          lastName: '',
          address: '',
          city: '',
          telephone: ''
        },
        owners: []
      }
    },

    mounted(){
      this.listar()
    },

    methods:{

      listar(){
          Owner.listar().then(resposta => {
          this.owners = resposta.data
        })
      },

      salvar(){
        if(!this.testOwner.id){
            Owner.salvar(this.testOwner).then(resposta=>{
            this.testOwner = {}
            resposta.data
            this.listar()
          })
        }else{
          Owner.atualizar(this.testOwner).then(resposta=>{
            this.testOwner = {}
            resposta.data
            this.listar()
          })
        }
      },

      editar(owner){
        this.testOwner = owner
      },

      remover(owner){

        if(confirm('Deseja excluir o owner '.concat(owner.firstName) + '?')){
          Owner.apagar(owner.id).then(resposta=>{
            resposta.data
            this.listar()
          })
        }
      },

      redirect(owner){
        localStorage.setItem("owner-id", owner.id);
        localStorage.setItem("owner-name", owner.firstName);
        this.$router.push(this.$route.query.redirect || "/pet");
      }

    }

  }

</script>

<style>

</style>
