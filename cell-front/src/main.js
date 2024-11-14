import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './common/css/index.css'
Vue.config.productionTip = false


Vue.use(ElementUI)
axios.defaults.baseURL = 'http://localhost:8082/'
Vue.prototype.$http = axios


new Vue({
  router,
  store,
  render: function (h) { return h(App) }
}).$mount('#app')






// import './assets/fonts/iconfont'
// import './assets/fonts/iconfont1'
// import './assets/fonts/iconfont2'
// import './common/js/util'
// import 'mavon-editor/dist/css/index.css'
// import NProgress from 'nprogress'
// import 'nprogress/nprogress.css'
// use

// Vue.use(ElementUI)
// // axios.defaults.baseURL = 'http://47.94.218.213:8082//blog/'
// axios.defaults.baseURL = 'http://localhost:8080/'
// // axios.defaults.baseURL=process.env.VUE_APP_API_URL
// //axios.defaults.baseURL = 'http://121.41.122.156:8081/blog/'
// Vue.prototype.$http = axios
