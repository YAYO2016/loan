package com.loan.web.config;

import com.loan.framework.utils.HttpUtil;
import com.loan.framework.utils.MD5Util;
import com.loan.web.common.CommonData;
import com.loan.web.common.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * @author GuoKang
 * @date 2019/7/11 15:26
 */
@Configuration
public class LoanSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoanUserDetailService loanUserDetailService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/static/**", "/");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()//配置安全策略
                .antMatchers("/common/getEnumsMap", "/common/getBatchEnumsMap").permitAll() // 免登陆接口配置
                .anyRequest().authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(new AccessDecisionManager() {
                            @Override
                            public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
                                if (authentication instanceof AnonymousAuthenticationToken) {
                                    throw new AccessDeniedException("未登录");
                                }
                                // 没有配置权限时
                                if (CollectionUtils.isEmpty(authentication.getAuthorities())) {
                                    throw new AccessDeniedException("权限不足!");
                                }
                            }

                            @Override
                            public boolean supports(ConfigAttribute attribute) {
                                return true;
                            }

                            @Override
                            public boolean supports(Class<?> clazz) {
                                return true;
                            }
                        });

                        return o;
                    }
                })
                .and()
                .formLogin()
                .failureHandler((httpServletRequest, httpServletResponse, e) -> {
                    HttpUtil.sendResponse(httpServletResponse,
                            JsonData.getResult(CommonData.StatusCode.STATUS_CODE_301));
//                    if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
//                        // 用户名不存在或认证失败
//                    } else if (e instanceof DisabledException) {
//                        // 无法认证
//                    } else {
//                        // 其它
//                    }
                })
                .successHandler((httpServletRequest, httpServletResponse, authentication) ->
                        HttpUtil.sendResponse(httpServletResponse, JsonData.getSucceed()))
                .and()
                .logout()
                .permitAll()
                .deleteCookies("JSESSIONID").invalidateHttpSession(true)
                .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) ->
                        HttpUtil.sendResponse(httpServletResponse, JsonData.getSucceed()))
                .and()
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((httpServletRequest, httpServletResponse, e) ->
                        HttpUtil.sendResponse(httpServletResponse,
                                JsonData.getResult(CommonData.StatusCode.STATUS_CODE_300)))
                .accessDeniedHandler((httpServletRequest, httpServletResponse, e) ->
                        HttpUtil.sendResponse(httpServletResponse,
                                JsonData.getResult(CommonData.StatusCode.STATUS_CODE_320)))
        ;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loanUserDetailService).passwordEncoder(new PasswordEncoder() {
            // TODO 自定义加密方式，需要和数据库中登录密码加密方式保持一致
            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.MD5Encode((String) rawPassword, null);
//                return MD5Util.MD5Encode((String) rawPassword, null);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                // 不采用任何加密方式，明文密码
                return encodedPassword.contentEquals(rawPassword);
//                return encodedPassword.equals(MD5Util.MD5Encode((String) rawPassword, null));
            }
        });
    }

}
