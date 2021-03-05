package com.claiire.demo.controller;

import com.claiire.demo.common.ResultDto;
import com.claiire.demo.common.ServiceExpection;
import com.claiire.demo.dto.UserDto;
import com.claiire.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 * 结合统一响应对象改造
 * @author Claire
 * @create 2021/3/3
 * @since 1.0.0
 */
@Api(tags = "用户管理模块")
@RestController
@RequestMapping("User")//在各个方法前加上定义的字符串，可以放在类和方法前
@Slf4j//java中日志规范
public class UserController1 {

    @Autowired
    private UserService userService;
    @Value("${user.key1}")
    private String userkey1;

    //使用统一响应大对象返回
    @ApiOperation("登录接口")
    @PostMapping("login")
    public ResultDto<UserDto> login(@RequestBody UserDto userDto) {
        String result = userService.login(userDto);

        if (userDto.getName().contains("error2")) {
            throw new NullPointerException();
        }
        if (userDto.getName().contains("error1")) {
            throw new ServiceExpection("error1", new NullPointerException());//含有error2就意味着空指针异常，塞给ServiceException
        }
        //调用静态异常方法便捷的将错误信息抛出
        if (userDto.getName().contains("error")) {
            ServiceExpection.throwEx("用户名中含有error");
        }

//        return ResultDto.success(" 成功 " + result + " userkey1 = " + userkey1);
        return ResultDto.failure(" 失败 " + result + " userkey1 = " + userkey1,userDto);
    }
}
