<template>
  <div id="app">

    <div class="container">
      <form @submit.prevent="salvar">

          <label>Name</label>
          <input type="text" placeholder="Name" v-model="testVet.name">
          <label>Specialty</label>
          <input type="text" placeholder="Specialty" v-model="testVet.specialty">

          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

      </form>

      <table>

        <thead>

          <tr>
            <th>Name</th>
            <th>Specialty</th>
            <th>Actions</th>
          </tr>

        </thead>

        <tbody>

            <tr v-for="vet of vets" :key="vet.id">

            <td>{{ vet.name }}</td>
            <td>{{ vet.specialty }}</td>
            <td>
              <button @click="editar(vet)" class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button @click="remover(vet)" class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>

    </div>

  </div>
</template>

<script>
  import Vet from '../services/vet'

  export default {

    data(){
      return {
        testVet: {
          id: '',
          name: '',
          specialty: '',
        },
        vets: []
      }
    },

    mounted(){
      this.listar()
    },

    methods:{

      listar(){
          Vet.listar().then(resposta => {
          this.vets = resposta.data
        })
      },

      salvar(){
        if(!this.testVet.id){
            Vet.salvar(this.testVet).then(resposta=>{
            this.testVet = {}
            resposta.data
            this.listar()
          })
        }else{
          Vet.atualizar(this.testVet).then(resposta=>{
            this.testVet = {}
            resposta.data
            this.listar()
          })
        }
      },

      editar(vet){
        this.testVet = vet
      },

      remover(vet){

        if(confirm('Deseja excluir o veterinário '.concat(vet.name) + '?')){
          Vet.apagar(vet.id).then(resposta=>{
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
