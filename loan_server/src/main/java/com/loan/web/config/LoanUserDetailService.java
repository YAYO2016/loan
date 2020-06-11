package com.loan.web.config;

import com.loan.service.model.UserInfo;
import com.loan.service.service.PrivilegeInfoService;
import com.loan.service.service.UserInfoService;
import com.loan.web.beans.UserDetailBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author GuoKang
 * @date 2019/7/11 15:37
 */
@Component
public class LoanUserDetailService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private PrivilegeInfoService privilegeInfoService;

    @Override
    public UserDetails loadUserByUsername(String loginAccount) throws UsernameNotFoundException {
//        logger.info("登陆用户的用户名: {}", username);
        UserInfo queryUserInfo = new UserInfo();
        queryUserInfo.setLoginAccount(loginAccount);
        List<UserInfo> userInfos = userInfoService.queryEntityList(queryUserInfo);
        if (CollectionUtils.isEmpty(userInfos)) throw new UsernameNotFoundException("当前用户不存在:" + loginAccount);
        UserInfo userInfo = userInfos.get(0);
        UserDetailBean user = new UserDetailBean(userInfo,
                AuthorityUtils.createAuthorityList(
                        privilegeInfoService.getPrivilegesByUserId(userInfo.getUserId()).toArray(new String[]{})));
        return user;
    }
}
