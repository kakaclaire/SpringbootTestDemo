package com.claiire.demo.service.impl;

import com.claiire.demo.common.ResultDto;
import com.claiire.demo.dao.TestUserMapper;
import com.claiire.demo.dto.UserDto;
import com.claiire.demo.entity.TestUser;
import com.claiire.demo.service.UserService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Autowired
    private TestUserMapper testUserMapper;

    @Override
    public String login(UserDto userDto) {
        System.out.println("userDto.getName()" + userDto.getName());
        System.out.println("userDto.getPwd()" + userDto.getPwd());
        return userDto.getName() + "-" + userDto.getPwd();
    }
    /**
     * 保存
     * @param testUser
     * @return
     */
    @Override
    public ResultDto<TestUser> save(TestUser testUser) {
        testUser.setCreateTime(new Date());
        testUser.setUpdateTime(new Date());
        testUserMapper.insertUseGeneratedKeys(testUser);
        return ResultDto.success("成功",testUser);
    }
    /**
     * 更新
     * @param testUser
     * @return
     */
    @Override
    public ResultDto<TestUser> update(TestUser testUser) {
        testUser.setCreateTime(new Date());
        testUser.setUpdateTime(new Date());
        testUserMapper.updateByPrimaryKey(testUser);
//        testUserMapper.updateUserDemo(testUser.getUserName(),testUser.getPassword(),testUser.getEmail(),testUser.getId());
        return ResultDto.success("更新成功",testUser);
    }
    /**
     * 根据用户ID或者name名称查询
     * @param testUser
     * @return
     */
    @Override
    public ResultDto<List<TestUser>> getByName(TestUser testUser) {
//        testUser.setCreateTime(new Date());
//        testUser.setUpdateTime(new Date());
//        List<TestUser> testUserList=testUserMapper.getByName(testUser.getUserName(),testUser.getId());//模糊查询用原标签
        List<TestUser> testUserList=testUserMapper.select(testUser);//使用tk.Mybatis进行精确匹配
        return ResultDto.success("查询成功",testUserList);

    }
    /**
     * 根据用户id删除用户信息
     * @param userId
     * @return
     */
    @Override
    public ResultDto delete(Integer userId) {
        TestUser testUser=new TestUser();
        testUser.setId(userId);
        testUserMapper.delete(testUser);
//        testUserMapper.deleteByPrimaryKey(userId);
        return ResultDto.success("删除成功",testUser);
    }
}
