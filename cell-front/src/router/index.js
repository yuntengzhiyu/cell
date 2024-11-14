import Vue from 'vue'
import VueRouter from 'vue-router'
import index from "@/components/index/index";
import login from "@/components/login/login";
import test from "@/components/test/test";
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component:index
  },
  {
    path: '/login',
    component: login
  },
  {
    path: '/test',
    component: test
  }


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
