import { http } from './configOwner'

export default {

    listar:()=>{
        return http.get('all')
    },

    salvar:(owner) => {
        return http.post('new', owner)
    },

    atualizar:(owner) =>{
        return http.put('edit', owner)
    },

    apagar:(id) =>
    {
        return http.delete('delete/'.concat(id))
    }
}