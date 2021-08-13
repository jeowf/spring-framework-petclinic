import { http } from './configPayment'

export default {

    listar:(id)=>{
        return http.get('all/'.concat(id))
    },

    atualizar:(payment) =>{
        return http.put('edit', payment)
    }
}