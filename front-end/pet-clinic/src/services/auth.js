import {http} from './config'

export default {

    all:() => {
        return http.get('/user/all')
    }

}