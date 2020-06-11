package com.loan.service.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.loan.framework.service.model.AbsPojoSetPk;
import com.loan.service.enums.UserSex;
import com.loan.service.enums.UserStatus;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author GuoKang
 * @date 2019-04-17 22:27
 */
public class UserInfo extends AbsPojoSetPk implements Serializable {

    private Long userId; // 用户编码
    private String userName; // 用户名称
    private String loginAccount; // 登录账户
    private UserSex userSex; // 性别
    private Date birthDay; // 出生日期
    private String userPw; // 系统密码
    private String birthplace; // 籍贯
    private Long orgId; // 归属组织机构
    private UserStatus status; // 状态
    private Long createUserId; // 创建人ID
    private Date joinDate; // 入司日期
    private String phone; // 移动电话
    private String emailAddress; // 电子邮件
    private Date createTime; // 创建时间
    private Date modifyTime; // 修改时间
    private JSONArray businessUsers = new JSONArray(); // 对应的渠道专员

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

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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

    @Override
    public void setPk(Long pk) {
        setUserId(pk);
    }
}
