package io.github.wujun728.oauth.service.impl;

import io.github.wujun728.common.constant.SecurityConstants;
import io.github.wujun728.common.feign.UserService;
import io.github.wujun728.oauth.service.ZltUserDetailsService;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.stereotype.Service;

import io.github.wujun728.common.model.LoginAppUser;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * @author jun
 * <p>
 * Blog: https://jun2000.gitee.io
 * Github: https://github.com/jun2000
 */
@Slf4j
@Service
public class UserDetailServiceImpl implements ZltUserDetailsService {
    private static final String ACCOUNT_TYPE = SecurityConstants.DEF_ACCOUNT_TYPE;

    @Resource
    private UserService userService;

    @Override
    public boolean supports(String accountType) {
        return ACCOUNT_TYPE.equals(accountType);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        LoginAppUser loginAppUser = userService.findByUsername(username);
        if (loginAppUser == null) {
            throw new InternalAuthenticationServiceException("用户名或密码错误");
        }
        return checkUser(loginAppUser);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String openId) {
        LoginAppUser loginAppUser = userService.findByOpenId(openId);
        return checkUser(loginAppUser);
    }

    @Override
    public UserDetails loadUserByMobile(String mobile) {
        LoginAppUser loginAppUser = userService.findByMobile(mobile);
        return checkUser(loginAppUser);
    }

    private LoginAppUser checkUser(LoginAppUser loginAppUser) {
        if (loginAppUser != null && !loginAppUser.isEnabled()) {
            throw new DisabledException("用户已作废");
        }
        return loginAppUser;
    }
}
