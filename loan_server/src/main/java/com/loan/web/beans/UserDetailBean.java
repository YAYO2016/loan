package com.loan.web.beans;

import com.loan.service.model.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author GuoKang
 * @date 2019/7/11 21:05
 */
public class UserDetailBean extends User {
    private UserInfo userInfo;

    public UserDetailBean(UserInfo userInfo, Collection<? extends GrantedAuthority> authorities) {
        super(userInfo.getLoginAccount(), userInfo.getUserPw(), authorities);
        this.setUserInfo(userInfo);
    }

    public UserDetailBean(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserDetailBean(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
