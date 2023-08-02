//document.write("<script src="+"https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"+"></script>")
//<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
//import axios from 'https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js'
//import axios from 'axios'
//export const {service} = axios.create()
//const axios = require('axios');
export const service = axios.create()
// request拦截器
service.interceptors.request.use(
    config => {
        config.headers.token = localStorage.token
        if (!localStorage.token){
            location.href="/html/123.html"
        }
        return config
    }
)

const token = localStorage.token
if(!token) location.href = '/html/123.html'