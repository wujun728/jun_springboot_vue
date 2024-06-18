package io.github.wujun728.oauth.openid;

import io.github.wujun728.oauth.service.impl.UserDetailServiceFactory;
import io.github.wujun728.oauth2.common.token.OpenIdAuthenticationToken;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author jun
 * <p>
 * Blog: https://jun2000.gitee.io
 * Github: https://github.com/jun2000
 */
@Setter
@Getter
public class OpenIdAuthenticationProvider implements AuthenticationProvider {
    private UserDetailServiceFactory userDetailsServiceFactory;

    @Override
    public Authentication authenticate(Authentication authentication) {
        OpenIdAuthenticationToken authenticationToken = (OpenIdAuthenticationToken) authentication;
        String openId = (String) authenticationToken.getPrincipal();
        UserDetails user = userDetailsServiceFactory.getService(authenticationToken).loadUserByUserId(openId);
        if (user == null) {
            throw new InternalAuthenticationServiceException("openId错误");
        }
        OpenIdAuthenticationToken authenticationResult = new OpenIdAuthenticationToken(user, user.getAuthorities());
        authenticationResult.setDetails(authenticationToken.getDetails());
        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return OpenIdAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
