package com.mymarket.pojo;
/*
后端传输到前端的数据格式
 */
public class Result {
    public Integer code; //状态码: 0 失败 | 1 成功
    public String msg; //提示信息
    public Object data; //返回的数据
    public Result(){}
    public Result(Integer code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    //结果：成功
    public static Result success(){
        return new Result(1,"Success.",null);
    }
    public static Result success(Object data){
        return new Result(1,"Success.",data);
    }
    public static Result error(String msg){
        return new Result(0,msg,null);
    }
    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
