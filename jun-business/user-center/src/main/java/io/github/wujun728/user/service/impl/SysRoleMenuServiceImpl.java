package io.github.wujun728.user.service.impl;

import io.github.wujun728.user.mapper.SysRoleMenuMapper;
import io.github.wujun728.user.model.SysRoleMenu;
import io.github.wujun728.user.service.ISysRoleMenuService;
import io.github.wujun728.common.model.SysMenu;
import io.github.wujun728.common.service.impl.SuperServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author jun
 */
@Slf4j
@Service
public class SysRoleMenuServiceImpl extends SuperServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {
 	@Resource
	private SysRoleMenuMapper sysRoleMenuMapper;

	@Override
	public int save(Long roleId, Long menuId) {
		return sysRoleMenuMapper.save(roleId, menuId);
	}

	@Override
	public int delete(Long roleId, Long menuId) {
		return sysRoleMenuMapper.delete(roleId, menuId);
	}

	@Override
	public List<SysMenu> findMenusByRoleIds(Set<Long> roleIds, Integer type) {
		return sysRoleMenuMapper.findMenusByRoleIds(roleIds, type);
	}

	@Override
	public List<SysMenu> findMenusByRoleCodes(Set<String> roleCodes, Integer type) {
		return sysRoleMenuMapper.findMenusByRoleCodes(roleCodes, type);
	}
}
