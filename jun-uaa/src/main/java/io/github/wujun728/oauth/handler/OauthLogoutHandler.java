package io.github.wujun728.oauth.handler;

import cn.hutool.core.util.StrUtil;
import io.github.wujun728.oauth.utils.UsernameHolder;
import io.github.wujun728.oauth2.common.properties.SecurityProperties;
import io.github.wujun728.oauth2.common.util.AuthUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jun
 * @date 2018/10/17
 * <p>
 * Blog: https://jun2000.gitee.io
 * Github: https://github.com/jun2000
 */
@Slf4j
public class OauthLogoutHandler implements LogoutHandler {
	@Resource
	private TokenStore tokenStore;

	@Resource
	private SecurityProperties securityProperties;

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		Assert.notNull(tokenStore, "tokenStore must be set");
		String token = request.getParameter("token");
		if (StrUtil.isEmpty(token)) {
			token = AuthUtils.extractToken(request);
		}
		if(StrUtil.isNotEmpty(token)){
			if (securityProperties.getAuth().getUnifiedLogout()) {
				OAuth2Authentication oAuth2Authentication = tokenStore.readAuthentication(token);
				UsernameHolder.setContext(oAuth2Authentication.getName());
			}

			OAuth2AccessToken existingAccessToken = tokenStore.readAccessToken(token);
			OAuth2RefreshToken refreshToken;
			if (existingAccessToken != null) {
				if (existingAccessToken.getRefreshToken() != null) {
					log.info("remove refreshToken!", existingAccessToken.getRefreshToken());
					refreshToken = existingAccessToken.getRefreshToken();
					tokenStore.removeRefreshToken(refreshToken);
				}
				log.info("remove existingAccessToken!", existingAccessToken);
				tokenStore.removeAccessToken(existingAccessToken);
			}
		}
	}
}
