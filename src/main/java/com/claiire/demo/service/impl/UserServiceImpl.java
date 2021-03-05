package com.claiire.demo.service.impl;

import com.claiire.demo.dto.UserDto;
import com.claiire.demo.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Claire
 * @create 2021/3/3
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String login(UserDto userDto) {
        System.out.println("userDto.getName()" + userDto.getName());
        System.out.println("userDto.getPwd()" + userDto.getPwd());
        return userDto.getName() + "-" + userDto.getPwd();
    }
}
