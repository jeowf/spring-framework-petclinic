import { http } from './configClient'

export default {

    listar:()=>{
        return http.get('all')
    },

    salvar:(client) => {
        return http.post('new', client)
    },

    atualizar:(client) =>{
        return http.put('edit', client)
    },

    apagar:(id) =>
    {
        return http.delete('delete/'.concat(id))
    }
}