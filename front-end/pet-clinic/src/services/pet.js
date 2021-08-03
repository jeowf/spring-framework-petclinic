import { http } from './configPet'

export default {

    listar:()=>{
        return http.get('all')
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