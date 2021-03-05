package com.claiire.demo.dao;

import com.claiire.demo.common.MySqlExtensionMapper;
import com.claiire.demo.entity.TestUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TestUserMapper extends MySqlExtensionMapper<TestUser> {
//    TestUser selectTestUser(@Param("id") Integer id);
    int updateUserDemo(@Param("username") String username,@Param("password") String password,@Param("email") String email,@Param("id") Integer id);
    List<TestUser> getByName(@Param("userName") String userName,@Param("userId") Integer userId);
}