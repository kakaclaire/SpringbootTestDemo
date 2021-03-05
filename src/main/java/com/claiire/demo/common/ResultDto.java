package com.claiire.demo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈统一响应大对象〉
 *
 * @author Claire
 * @create 2021/3/4
 * @since 1.0.0
 */
@ApiModel(value = "基础返回类", description = "基础返回类")
public class ResultDto<T> implements Serializable {//实现的一个序列化接口，这个类可以序列化和反序列化
    private static final long serialVersionUID = -77777L;
    @ApiModelProperty(value = "返回结果码 1 成功 0 失败", required = true, example = "1", allowableValues = "1,0")
    private Integer resultCode;

    @ApiModelProperty(value = "提示信息",example = "成功", allowableValues = "成功，失败")
    private String message;

    @ApiModelProperty(value = "响应结果数据")
    private T data = null;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public Integer getResultCode(){
        return resultCode;
    }

    public static ResultDto newInstance(){
        return new ResultDto();
    }

    /**
     * 设置为成功状态
     */
    public void setAsSuccess(){
        this.resultCode=1;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    //提供便捷方法
    public static ResultDto success(String message){
        ResultDto resultDto=new ResultDto();
        resultDto.setAsSuccess();
        resultDto.setMessage(message);
        return resultDto;
    }
    //提供重载方法
    public static <T> ResultDto<T> success(String message,T data){
        ResultDto<T> resultDto=new ResultDto<>();
        resultDto.setAsSuccess();
        resultDto.setMessage(message);
        resultDto.setData(data);
        return resultDto;
    }
    /**
     * 设置为失败状态
     */
    public void setAsFailure(){
        this.resultCode=0;
    }

    public static ResultDto failure(String message){
        ResultDto resultDto=new ResultDto();
        resultDto.setAsFailure();
        resultDto.setMessage(message);
        return resultDto;
    }
    public static <T> ResultDto<T> failure(String message, T data){
        ResultDto<T> resultDto=new ResultDto<>();
        resultDto.setAsFailure();
        resultDto.setMessage(message);
        resultDto.setData(data);
        return resultDto;

    }

    public static ResultDto main(String[] args) {
        return ResultDto.failure("密码不对",new HashMap<>());
    }





}
