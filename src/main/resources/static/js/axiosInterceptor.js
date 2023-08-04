export const service = axios.create()
// request拦截器
service.interceptors.request.use(request => {
    // if(request.url === '/html/index.html'  || request.url === '/html/register02.html'
    // || request.url === '/html/manager_login.html' || request.url === '/html/manager_register.html'
    // || request.url === '/' || request.url === '/html/123.html' || request.url === '/html/register_success.html')
    //     return request
    request.headers.token = localStorage.token
    if (!localStorage.token){
        location.href = '/html/123.html'
    }
    return request
    }
)
// response拦截器
service.interceptors.response.use(
    response => {
        if(response.data.code === 1) return response
        else if(response.data.msg !== null && response.data.msg === 'NOT_LOGIN'){
            alert('未登录或登录已失效！')
            localStorage.clear()
            location.href = '/html/123.html'
        }
        else if(response.data.msg !== null && response.data.msg === 'ADMIN_NOT_LOGIN'){
            return Promise.reject(new Error('管理员未登录或登录已失效！'))
        }
        else{
            return Promise.reject(new Error(response.data.msg))
        }
    },
    error => {
        return Promise.reject(error)
    }
)