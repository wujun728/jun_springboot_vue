package com.jun.plugin.user.service;

import com.jun.plugin.user.model.SysRoleMenu;
import com.jun.plugin.common.model.SysMenu;
import com.jun.plugin.common.service.ISuperService;

import java.util.List;
import java.util.Set;

/**
 * @author zlt
 */
public interface ISysRoleMenuService extends ISuperService<SysRoleMenu> {
	int save(Long roleId, Long menuId);

	int delete(Long roleId, Long menuId);

	List<SysMenu> findMenusByRoleIds(Set<Long> roleIds, Integer type);

	List<SysMenu> findMenusByRoleCodes(Set<String> roleCodes, Integer type);
}
