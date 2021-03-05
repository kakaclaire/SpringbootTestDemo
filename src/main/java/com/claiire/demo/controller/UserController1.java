package com.claiire.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.claiire.demo.common.ResultDto;
import com.claiire.demo.common.ServiceExpection;
import com.claiire.demo.dto.AddTestUserDto;
import com.claiire.demo.dto.UpdateTestUserDto;
import com.claiire.demo.dto.UserDto;
import com.claiire.demo.entity.TestUser;
import com.claiire.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 * 结合统一响应对象改造
 *
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
        return ResultDto.failure(" 失败 " + result + " userkey1 = " + userkey1, userDto);
    }

    @ApiOperation("用户注册")
    @PostMapping("register")
    public ResultDto<TestUser> register(@RequestBody AddTestUserDto addTestUserDto) {
        TestUser testUser = new TestUser();
//        直接注入
//        testUser.setUserName(addTestUserDto.getUserName());
//        testUser.setPassword(addTestUserDto.getPassword());
//       便捷操作
        BeanUtils.copyProperties(addTestUserDto, testUser);
        if (StringUtils.isEmpty(addTestUserDto.getUserName())) {
            return ResultDto.failure("用户名不能为空");
        }
        if (StringUtils.isEmpty(addTestUserDto.getPassword())) {
            return ResultDto.failure("密码不能为空");
        }
        log.info("用户注册 请求入参" + JSONObject.toJSON(testUser));
        return userService.save(testUser);

    }

    @ApiOperation("用户信息修改接口")
    @PutMapping()
    public ResultDto<TestUser> updateUser(@RequestBody UpdateTestUserDto updateTestUserDto) {
        TestUser testUser = new TestUser();
        BeanUtils.copyProperties(updateTestUserDto, testUser);
        if (StringUtils.isEmpty(updateTestUserDto.getUserName())) {
            return ResultDto.failure("用户名不能为空");
        }
        if (StringUtils.isEmpty(updateTestUserDto.getPassword())) {
            return ResultDto.failure("密码不能为空");
        }
        log.info("用户注册 请求入参" + JSONObject.toJSON(testUser));
        return userService.update(testUser);

    }

    @ApiOperation("根据用户名模糊查询接口")
    @GetMapping("byName")
    public ResultDto<List<TestUser>> getByName(@RequestParam(value = "userId", required = false) Integer userId, @RequestParam(value = "userName", required = false) String userName) {
        log.info("根据用户名模糊查询 入参" + userName);
        TestUser testUser = new TestUser();
        testUser.setId(userId);
        testUser.setUserName(userName);
        log.info("根据用户名模糊查询 请求入参" + JSONObject.toJSON(testUser));
        return userService.getByName(testUser);
    }

    @ApiOperation("根据用户id删除用户信息")
    @DeleteMapping("{userId}")
    public ResultDto delete(@PathVariable("userId") Integer userId) {
       log.info("根据用户id删除用户信息" + userId);

        return userService.delete(userId);
    }


}
