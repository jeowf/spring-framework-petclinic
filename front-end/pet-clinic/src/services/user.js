import { http } from './configUser'

export default {

    listar:()=>{
        return http.get('all')
    },

    salvar:(user) => {
        return http.post('new', user)
    },

    atualizar:(user) =>{
        return http.put('update', user)
    },
}