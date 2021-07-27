import {http} from './config'

export default {

    all_users:() => {
        return http.get('user/all')
    },

    login:(user) =>{
        return http.post('user/login', user)
    },

    new_user:(user) =>{
        return http.post('user/new', user)
    },

    update_user:(user) =>{
        return http.put('user/update', user)
    },

    get_user:(id) =>{
        return http.get('user/'.concat(id))
    }

}