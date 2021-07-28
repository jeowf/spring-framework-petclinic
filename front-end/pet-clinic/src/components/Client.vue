<template>
  <div id="app">

    <div class="container">
      <form @submit.prevent="salvar">

          <label>First Name</label>
          <input type="text" placeholder="First Name" v-model="testClient.firstName">
          <label>Last Name</label>
          <input type="text" placeholder="Last Name" v-model="testClient.lastName">
          <label>CPF</label>
          <input type="text" placeholder="nnn.nnn.nnn-nn" v-model="testClient.cpf">
          <label>Birth Date</label>
          <input type="text" placeholder="yyyy-mm-dd" v-model="testClient.birthdate">

          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

      </form>

      <table>

        <thead>

          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>CPF</th>
            <th>Brithdate</th>
          </tr>

        </thead>

        <tbody>

            <tr v-for="cliente of clients" :key="cliente.id">

            <td>{{ cliente.firstName }}</td>
            <td>{{ cliente.lastName }}</td>
            <td>{{ cliente.cpf }}</td>
            <td>{{ cliente.birthdate }}</td>
            <td>
              <button @click="editar(cliente)" class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button @click="remover(cliente)" class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>

    </div>

  </div>
</template>

<script>
  import Client from '../services/client'

  export default {

    data(){
      return {
        testClient: {
          id: '',
          firstName: '',
          lastName: '',
          cpf: '',
          birthdate: ''
        },
        clients: []
      }
    },

    mounted(){
      this.listar()
    },

    methods:{

      listar(){
          Client.listar().then(resposta => {
          this.clients = resposta.data
        })
      },

      salvar(){
        if(!this.testClient.id){
            Client.salvar(this.testClient).then(resposta=>{
            this.testClient = {}
            resposta.data
            this.listar()
          })
        }else{
          Client.atualizar(this.testClient).then(resposta=>{
            this.testClient = {}
            resposta.data
            this.listar()
          })
        }
      },

      editar(client){
        this.testClient = client
      },

      remover(client){

        if(confirm('Deseja excluir o cliente '.concat(client.firstName) + '?')){
          Client.apagar(client.id).then(resposta=>{
            resposta.data
            this.listar()
          })
        }
      }

    }

  }

</script>

<style>

</style>
