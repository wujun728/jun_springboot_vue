package io.github.wujun728.oauth.tenant;

import io.github.wujun728.oauth.password.PasswordAuthenticationProvider;
import io.github.wujun728.oauth2.common.token.TenantUsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 增加租户id，解决不同租户单点登录时角色没变化
 *
 * @author jun
 * @date 2020/6/10
 * <p>
 * Blog: https://jun2000.gitee.io
 * Github: https://github.com/jun2000
 */
public class TenantAuthenticationProvider extends PasswordAuthenticationProvider {
    @Override
    protected Authentication createSuccessAuthentication(Object principal,
                                                         Authentication authentication, UserDetails user) {
        TenantUsernamePasswordAuthenticationToken authenticationToken = (TenantUsernamePasswordAuthenticationToken) authentication;
        TenantUsernamePasswordAuthenticationToken result = new TenantUsernamePasswordAuthenticationToken(
                principal, authentication.getCredentials(), user.getAuthorities(), authenticationToken.getClientId());
        result.setDetails(authenticationToken.getDetails());
        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return TenantUsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
