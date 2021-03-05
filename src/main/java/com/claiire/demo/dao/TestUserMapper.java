package com.claiire.demo.dao;

import com.claiire.demo.common.MySqlExtensionMapper;
import com.claiire.demo.entity.TestUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestUserMapper extends MySqlExtensionMapper<TestUser> {
//    TestUser selectTestUser(@Param("id") Integer id);
}