package com.jun.plugin.user.service;

import static org.assertj.core.api.Assertions.*;

import com.jun.plugin.common.model.LoginAppUser;
import com.jun.plugin.common.model.PageResult;
import com.jun.plugin.common.model.SysUser;
import com.jun.plugin.user.service.ISysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * SysUserServiceTest单元测试用例
 *
 * @author zlt
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceTest {
	@Autowired
	private ISysUserService sysUserService;

	@Test
	public void testFindByUsername() {
		LoginAppUser loginAppUser = sysUserService.findByUsername("admin");
		assertThat(loginAppUser).isNotNull();
	}

	@Test
	public void testFindUsers() {
		Map<String, Object> params = new HashMap<>(2);
		params.put("page", 1);
		params.put("limit", 10);
		PageResult<SysUser> page = sysUserService.findUsers(params);
		assertThat(page).isNotNull();
		assertThat(page.getCount()).isGreaterThan(0);
	}
}
