package com.zengjie.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zengjie
 * @date 2020/4/17 9:40
 */
@Data
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult (Integer code,String message){
        this(code,message,null);
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
