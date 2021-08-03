import { http } from './configVet'

export default {

    listar:()=>{
        return http.get('all')
    },

    salvar:(vet) => {
        return http.post('/', vet)
    },

    atualizar:(vet) =>{
        return http.put('/', vet)
    },

    apagar:(id) =>
    {
        return http.delete('delete/'.concat(id))
    }
}