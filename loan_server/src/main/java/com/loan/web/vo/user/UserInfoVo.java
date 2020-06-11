package com.loan.web.vo.user;

import com.alibaba.fastjson.JSONArray;
import com.loan.service.enums.UserSex;
import com.loan.service.enums.UserStatus;

import java.util.Date;
import java.util.List;

/**
 * @author GuoKang
 * @date 2019-04-22 22:25
 */
public class UserInfoVo {
    private Long userId; // 用户编码
    private String userName; // 用户名称
    private String loginAccount; // 登陆账户
    private UserSex userSex; // 性别
    private Date birthDay; // 出生日期
    private String userPw; // 系统密码
    private String birthplace; // 籍贯
    private Long orgId; // 归属组织机构
    private Date joinDate; // 入司日期
    private String phone; // 移动电话
    private String emailAddress; // 电子邮件
    private UserStatus userStatus; // 用户状态
    private JSONArray businessUsers; // 对应渠道专员

    private List<String> roles;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public UserSex getUserSex() {
        return userSex;
    }

    public void setUserSex(UserSex userSex) {
        this.userSex = userSex;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public JSONArray getBusinessUsers() {
        return businessUsers;
    }

    public void setBusinessUsers(JSONArray businessUsers) {
        this.businessUsers = businessUsers;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }
}
