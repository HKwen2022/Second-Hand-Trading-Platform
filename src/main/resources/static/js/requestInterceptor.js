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