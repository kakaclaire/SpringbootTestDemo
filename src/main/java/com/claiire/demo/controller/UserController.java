//package com.claiire.demo.controller;
//
//import com.claiire.demo.common.ResultDto;
//import com.claiire.demo.common.ServiceExpection;
//import com.claiire.demo.dto.UserDto;
//import com.claiire.demo.service.UserService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.metrics.StartupStep;
//import org.springframework.web.bind.annotation.*;
//
//*
// * 〈一句话功能简述〉<br>
// * 〈〉
// *
// * @author Claire
// * @create 2021/3/3
// * @since 1.0.0
//
//
//@Api(tags = "用户管理模块")
//@RestController
//@RequestMapping("User")//在各个方法前加上定义的字符串，可以放在类和方法前
//@Slf4j//java中日志规范
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//    @Value("${user.key1}")
//    private String userkey1;
//
//
//    //    @RequestMapping(value = "login", method = RequestMethod.POST)
//
//    @ApiOperation("登录接口")
//    @PostMapping("login")
//    public String login(@RequestBody UserDto userDto) {
//        String result = userService.login(userDto);
//        if (userDto.getName().contains("error2")) {
//            throw new NullPointerException();
//        }
//        if (userDto.getName().contains("error1")) {
//            throw new ServiceExpection("error1", new NullPointerException());//含有error2就意味着空指针异常，塞给ServiceException
//        }
//        //调用静态异常方法便捷的将错误信息抛出
//        if (userDto.getName().contains("error")) {
//            ServiceExpection.throwEx("用户名中含有error");
//        }
//        return " 成功 " + result + " userkey1 = " + userkey1;
//    }
//
//    //    @RequestMapping(value = "login", method = RequestMethod.GET)
//    @GetMapping("login1")
//    public String login1() {
//        return "成功";
//    }
//
//    @PutMapping()
//    public String update(@RequestBody UserDto userDto) {
//        System.out.println("userDto.getName()" + userDto.getName());
//        System.out.println("userDto.getPwd()" + userDto.getPwd());
//        return "成功";
//    }
//
//    @DeleteMapping()
//    public String Detele(@RequestBody UserDto userDto) {
//        System.out.println("userDto.getName()" + userDto.getName());
//        System.out.println("userDto.getPwd()" + userDto.getPwd());
//        return "成功";
//    }
//
//    //动态参数的传参接口
//    @RequestMapping(value = "byId/{userId}/{id}", method = RequestMethod.GET)
//    public String getById(@PathVariable("userId") Long userId, @PathVariable("id") Long id) {
//        System.out.println("userId" + userId);
//        System.out.println("id" + id);
//        return "成功" + userId + " id=" + id;
//    }
//
//    //    @RequestMapping(value = "byId", method = RequestMethod.GET)
//    @GetMapping("byId")
//    public String getById2(@RequestParam("userId") Long userId, @RequestParam("id") Long id) {
//        System.out.println("userId" + userId);
//        System.out.println("id" + id);
//        return "成功 RequestParam " + userId + " id=" + id;
//    }
//
//
//}
