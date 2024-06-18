package io.github.wujun728.oauth.openid;

import io.github.wujun728.oauth.service.impl.UserDetailServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.stereotype.Component;

/**
 * openId的相关处理配置
 *
 * @author jun
 * <p>
 * Blog: https://jun2000.gitee.io
 * Github: https://github.com/jun2000
 */
@Component
public class OpenIdAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Autowired
    private UserDetailServiceFactory userDetailsServiceFactory;

    @Override
    public void configure(HttpSecurity http) {
        //openId provider
        OpenIdAuthenticationProvider provider = new OpenIdAuthenticationProvider();
        provider.setUserDetailsServiceFactory(userDetailsServiceFactory);
        http.authenticationProvider(provider);
    }
}
