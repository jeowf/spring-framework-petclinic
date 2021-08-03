/*

import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Register from '@/components/Register'
import HelloWorld from '@/components/HelloWorld'

import Config from '@/components/Config'
import Site from '@/components/Site'
import Favorite from '@/components/Favorite'
import ConfigNew from '@/components/ConfigNew'
import ConfigUpdate from '@/components/ConfigUpdate'
import ConfigView from '@/components/ConfigView'
import SiteNew from '@/components/SiteNew'
import SiteUpdate from '@/components/SiteUpdate'
import FavoriteUpdate from '@/components/FavoriteUpdate'
import FavoriteView from '@/components/FavoriteView'

Vue.use(Router)

export default new Router({
  routes: [
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
    }
  ]
})
*/

import {
    createWebHistory,
    createRouter
  } from 'vue-router'

  import Login from '@/components/Login'
  import Register from '@/components/Register'
  import HelloWorld from '@/components/HelloWorld'
  import Vet from '@/components/Vet'

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
      path: '/vet',
      name: 'Vet',
      component: Vet
    }
]
  
  const router = createRouter({
    history: createWebHistory,
    routes,
  })
  
  export default router