import { http } from './configPet'

export default {

    listar:(owner_id)=>{
        return http.get('all'.concat(owner_id))
    },

    salvar:(pet) => {
        return http.post('new', pet)
    },

    atualizar:(pet) =>{
        return http.put('edit', pet)
    },

    apagar:(id) =>
    {
        return http.delete('delete/'.concat(id))
    }
}