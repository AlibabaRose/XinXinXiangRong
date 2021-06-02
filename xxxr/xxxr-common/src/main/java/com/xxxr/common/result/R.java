package com.xxxr.common.result;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

@Data
@Accessors(chain = true)
public class R {

    private Integer code;
    private String message;
    private Map<String,Object> data=new HashMap<>();

    private R(){

    }

    public static R ok(){
        R result = new R();
        result.setCode(ResponseEnum.SUCCESS.getCode())
                .setMessage(ResponseEnum.SUCCESS.getMessage());
        return result;
    }

    public static R error(){
        R result = new R();
        result.setCode(ResponseEnum.ERROR.getCode())
                .setMessage(ResponseEnum.ERROR.getMessage());
        return result;
    }

    public static R setResult(ResponseEnum responseEnum){
        R result = new R();
        result.setCode(responseEnum.getCode())
                .setMessage(responseEnum.getMessage());
        return result;
    }

    public R data(String key, Object value){
        this.data.put(key,value);
        return this;
    }

    /**
     * 设置特定的响应详细
     * @param message
     * @return
     */
    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    /**
     * 方法重载，根据具体的Map数据返回前端JSON字符串
     * @param map
     * @return
     */
    public R data(Map<String,Object> map){
        this.setData(map);
        return this;
    }
}
