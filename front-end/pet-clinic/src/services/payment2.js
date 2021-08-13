import { http } from './configPayment2'

export default {

    listar:(id)=>{
        return http.get('/payments/'.concat(id))
    }
}