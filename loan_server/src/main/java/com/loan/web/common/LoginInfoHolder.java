package com.loan.web.common;

import com.loan.service.model.UserInfo;
import com.loan.service.model.dto.UserInfoDto;
import com.loan.service.service.UserInfoService;
import com.loan.web.beans.UserDetailBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author GuoKang
 * @date 2019/4/22 14:50
 */
@Component
public class LoginInfoHolder {
    private static Logger logger = LoggerFactory.getLogger(LoginInfoHolder.class);

    private static String serverSessionName;

    private static WebApplicationContext webApplicationContext;

    /**
     * 获取当前登录人的信息
     */
    public static UserInfoDto getUserInfoDto() {
        ApplicationContext context = getApplicationContext();

        if (null == context) return null;
        UserDetailBean casUser = getUserDetailBean();
        if (null == casUser) return null;
        UserInfoService service = context.getBean(UserInfoService.class);

        HttpSession session = getServletRequest().getSession();
        Object attribute = session.getAttribute(serverSessionName);
        UserInfoDto userInfoDto = null == attribute ? null : (UserInfoDto) attribute;
        logger.debug("Load UserInfo from Session:{}", userInfoDto);
        if (null == userInfoDto) {
            UserInfo userInfo = casUser.getUserInfo();
            userInfoDto = service.getUserInfoDtoById(userInfo.getUserId());
            session.setAttribute(serverSessionName, userInfoDto);
        }

        return userInfoDto;
    }

    /**
     * 获取当前登录人的ID
     */
    public static Long getUserId() {
        UserInfoDto userInfoDto = getUserInfoDto();
        return userInfoDto.getUserId();
    }

    /**
     * 获取当前登录人的权限集合
     */
    public static List<String> getUserRoles() {
        UserInfoDto userInfoDto = getUserInfoDto();
        return userInfoDto.getRoles();
    }

    @Value("${server.session.name}")
    public void setServerSessionName(String sessionName) {
        serverSessionName = sessionName;
    }

    private static ApplicationContext getApplicationContext() {
        if (null == LoginInfoHolder.webApplicationContext) {
            HttpServletRequest request = getServletRequest();
            LoginInfoHolder.webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        }
        return LoginInfoHolder.webApplicationContext;
    }

    public static UserDetailBean getUserDetailBean() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null == authentication) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetailBean) {
            return (UserDetailBean) principal;
        }
        return null;
    }

    private static HttpServletRequest getServletRequest() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        if (null != attributes && attributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) attributes).getRequest();

            return request;
        }
        return null;
    }
}
