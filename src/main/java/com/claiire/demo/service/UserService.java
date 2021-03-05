package com.claiire.demo.service;

import com.claiire.demo.common.ResultDto;
import com.claiire.demo.dto.AddTestUserDto;
import com.claiire.demo.dto.UserDto;
import com.claiire.demo.entity.TestUser;

import java.util.List;

public interface UserService {
    public String login(UserDto userDto);

    /**
     * 保存
     * @param testUser
     * @return
     */
    public ResultDto<TestUser> save(TestUser testUser);
    /**
     * 更新
     * @param testUser
     * @return
     */
    public ResultDto<TestUser> update(TestUser testUser);
    /**
     * 根据用户ID或者name名称查询
     * @param testUser
     * @return
     */
    public ResultDto<List<TestUser>> getByName(TestUser testUser);
    /**
     * 根据用户id删除用户信息
     * @param userId
     * @return
     */
    public ResultDto delete(Integer userId);
}
