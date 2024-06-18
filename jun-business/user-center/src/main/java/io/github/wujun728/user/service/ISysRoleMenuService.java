package io.github.wujun728.user.service;

import io.github.wujun728.user.model.SysRoleMenu;
import io.github.wujun728.common.model.SysMenu;
import io.github.wujun728.common.service.ISuperService;

import java.util.List;
import java.util.Set;

/**
 * @author jun
 */
public interface ISysRoleMenuService extends ISuperService<SysRoleMenu> {
	int save(Long roleId, Long menuId);

	int delete(Long roleId, Long menuId);

	List<SysMenu> findMenusByRoleIds(Set<Long> roleIds, Integer type);

	List<SysMenu> findMenusByRoleCodes(Set<String> roleCodes, Integer type);
}
