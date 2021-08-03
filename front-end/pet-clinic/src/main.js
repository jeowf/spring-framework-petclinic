/*import { createApp } from 'vue'
import App from './App.vue'

createApp(App).mount('#app')
*/

/*
import Vue from 'vue'
import App from './App.vue'
import router from './router'

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
*/

/*
import { createApp } from 'vue'
import App from './App.vue'
import router from './router/index'

const app = createApp(App)
app.use(router)

app.mount('#app')
*/

import { createApp } from 'vue'
import App from './App.vue'

import {createRouter, createWebHistory} from 'vue-router'  

import Login from '@/components/Login'
import Register from '@/components/Register'
import HelloWorld from '@/components/HelloWorld'
import Owner from '@/components/Owner'
import Client from '@/components/Client'
import Vet from '@/components/Vet'
import Pet from '@/components/Pet'

const routes = [
    {
      path: '/',
      name: 'Hello',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/Owner',
      name: 'Owner',
      component: Owner
    },
    {
      path: '/Client',
      name: 'Client',
      component: Client
    },
    {
      path: '/Vet',
      name: 'Vet',
      component: Vet
    },
    {
      path: '/pet',
      name: 'Pet',
      component: Pet
    }
]

const router = createRouter({
  history: createWebHistory(process.env.baseURL),
  routes
})
createApp(App).use(router).mount('#app')