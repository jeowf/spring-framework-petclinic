<template>
  <div id="app">

    <div class="container">
      <table>

        <thead>

          <tr>
            <th>ID da Visita</th>
            <th>Valor da visita</th>
            <th>Status do pagamento</th>
          </tr>

        </thead>

        <tbody>

            <tr v-for="payment of payments" :key="payment.id">

            <td>{{ payment.visitId }}</td>
            <td>{{ payment.value }}</td>
            <td>{{ payment.status }}</td>
            <td>
              <button @click="editar(payment)" class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>

    </div>

  </div>
</template>

<script>
  import Payment from '../services/payment'

  export default {

    data(){
      return {
        payments: [],
        owner_id: null
      }
    },

    mounted(){
      this.owner_id = localStorage.getItem("owner-id");
      console.log(this.owner_id)
      this.listar(this.owner_id)
    },

    methods:{

      listar(id){
          Payment.listar(id).then(resposta => {
          this.payments = resposta.data
        })
      },

      editar(payment){
        payment.status = "Ok";
        Payment.atualizar(payment).then(resposta=>{
            resposta.data
            this.listar(this.owner_id)
          })
      },

      redirect(){
        this.$router.push(this.$route.query.redirect || "/Owner");
      },
    }

  }

</script>

<style>

</style>
