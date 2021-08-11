<template>
  <div id="app">
    <div class="container">
      <form @submit.prevent="salvar">

          <label>Escolher dono</label>
          <p>{{owner}}</p>
          <select v-model="owner">
            <option value="1">owner A</option>
            <option value="2">owner B</option>
            <option value="3">owner C</option>
          </select>
          <br>

          <!-- <label>Escolher Pet</label>
          <label>Escolher Vet</label>

          <label>Observações do atendimento</label>
          <input type="text" placeholder="Specialty" v-model="testVet.specialty">

          <label>Forma pgt</label>
          <label>Valor a ser pago</label> -->
         
          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left"></i></button>

      </form>

      <!-- <table>

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
      
      </table> -->

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
          owner: ''
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
