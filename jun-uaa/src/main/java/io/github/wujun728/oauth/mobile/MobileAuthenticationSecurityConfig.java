package io.github.wujun728.oauth.mobile;

import io.github.wujun728.oauth.service.impl.UserDetailServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * mobile的相关处理配置
 *
 * @author jun
 * <p>
 * Blog: https://jun2000.gitee.io
 * Github: https://github.com/jun2000
 */
@Component
public class MobileAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Resource
    private UserDetailServiceFactory userDetailsServiceFactory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(HttpSecurity http) {
        //mobile provider
        MobileAuthenticationProvider provider = new MobileAuthenticationProvider();
        provider.setUserDetailsServiceFactory(userDetailsServiceFactory);
        provider.setPasswordEncoder(passwordEncoder);
        http.authenticationProvider(provider);
    }
}
