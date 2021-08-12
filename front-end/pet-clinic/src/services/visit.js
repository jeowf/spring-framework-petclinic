import { http } from './configVisit'

export default {

    salvar:(pet) => {
        return http.post('create-visit', pet,{
            headers: {
                'Content-Type': 'application/json'
              }
        })
    },
}