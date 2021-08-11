Guardar Consulta<template>
  <div id="app">

    <div class="container">
      <form @submit.prevent="salvar">
          <label>Owner Name</label>
          <input type="text" disabled=true :value=owner_name>
          <label>Pet Name</label>
          <input type="text" placeholder="Pet Name" v-model="testPet.name">
          <label>Birthdate</label>
          <input type="text" placeholder="yyyy-mm-dd" v-model="testPet.birthDate">
          <label>Type</label>
          <input type="text" placeholder="Cat" v-model="testPet.type">

          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

      </form>

      <table>

        <thead>

          <tr>
            <th>Pet Name</th>
            <th>Birthdate</th>
            <th>Type</th>
          </tr>

        </thead>

        <tbody>

            <tr v-for="pet of pets" :key="pet.id">

            <td>{{ pet.name }}</td>
            <td>{{ pet.birthDate }}</td>
            <td>{{ pet.type }}</td>
            <td>
              <button @click="editar(pet)" class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button @click="remover(pet)" class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>

    </div>

  </div>
</template>

<script>
  import Pet from '../services/pet'

  export default {

    data(){
      return {
        testPet: {
          id: '',
          name: '',
          birthDate: '',
          type: '',
          ownerId: ''
        },
        pets: [],
        owner_id: null,
        owner_name: null
      }
    },

    mounted(){
      this.owner_id = localStorage.getItem("owner-id");
      this.owner_name = localStorage.getItem("owner-name");
      this.listar(this.owner_id)
    },

    methods:{

      listar(){
          Pet.listar(this.owner_id).then(resposta => {
          this.pets = resposta.data
        })
      },

      salvar(){
        this.testPet.ownerId = this.owner_id
        if(!this.testPet.id){
            Pet.salvar(this.testPet).then(resposta=>{
            this.testPet = {}
            resposta.data
            this.listar(this.owner_id)
          })
        }else{
          Pet.atualizar(this.testPet).then(resposta=>{
            this.testPet = {}
            resposta.data
            this.listar(this.owner_id)
          })
        }
      },

      editar(pet){
        this.testPet = pet
      },

      remover(pet){

        if(confirm('Deseja excluir o pet '.concat(pet.name) + '?')){
          Pet.apagar(pet.id).then(resposta=>{
            resposta.data
            this.listar(this.owner_id)
          })
        }
      }

    }

  }

</script>

<style>

</style>
