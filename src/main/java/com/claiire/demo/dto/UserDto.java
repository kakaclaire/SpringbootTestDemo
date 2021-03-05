package com.claiire.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Claire
 * @create 2021/3/3
 * @since 1.0.0
 */
@ApiModel(value = "用户登录类",description = "请求类")
@Data
public class UserDto {

    @ApiModelProperty(value = "用户名",example = "claire",required = true)
    private String name;
    @ApiModelProperty(value = "用户密码",example = "claire12122",required = true)
    private String pwd;
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setPwd(String pwd) {
//        this.pwd = pwd;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getPwd() {
//        return pwd;
//    }


}
