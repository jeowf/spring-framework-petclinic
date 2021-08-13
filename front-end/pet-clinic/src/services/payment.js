import { http } from './configPayment'

export default {

    atualizar:(payment) =>{
        return http.put('edit', payment)
    }
}