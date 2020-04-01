package com.yyl.Zivi.Model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "Person")
public class Person {
    /**
     * id 自动增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    /**
     * 用户登录名
     */
    @Column(length = 16)
    @NotNull
    private String loginName;

    /**
     * 用户姓名
     */
    @Column(length = 50)
    private String name;

    /**
     * 用户生日
     */
    @Column(length = 20)
    private String birth;

    /**
     * 用户密码
     */
    @Column(length = 20)
    @NotNull
    private String password;

    /**
     * 最后登录时间
     */
    @Column(length = 20)
    private String lastLoginTime;

    /**
     * 注册时间
     */
    @Column(length = 20)
    private String registTime;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }
}
