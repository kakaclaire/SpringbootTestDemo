package com.claiire.demo.entity;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
//映射语句
@Table(name = "test_user")//表对应的实体类标识
@Data
public class TestUser extends BaseEntityNew {
    /**
     * 主键
     */
    @Id//主键标识
    @GeneratedValue(strategy = GenerationType.IDENTITY)//配置主键为自增策略
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "user_name")//类属性和表字段不符时，用name属性标识表字段
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 自动生成用例job名称 不为空时表示已经创建job
     */
    @Column(name = "auto_create_case_job_name")
    private String autoCreateCaseJobName;

    /**
     * 执行测试job名称 不为空时表示已经创建job
     */
    @Column(name = "start_test_job_name")
    private String startTestJobName;

    /**
     * 默认Jenkins服务器
     */
    @Column(name = "default_jenkins_id")
    private Integer defaultJenkinsId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    @Transient //忽略此字段不进行持久化
    private String projectName;
}