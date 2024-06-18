package io.github.wujun728.user.service;

import io.github.wujun728.user.model.SysRoleUser;
import io.github.wujun728.common.model.SysRole;
import io.github.wujun728.common.service.ISuperService;

import java.util.List;

/**
 * @author jun
 */
public interface ISysRoleUserService extends ISuperService<SysRoleUser> {
	int deleteUserRole(Long userId, Long roleId);

	int saveUserRoles(Long userId, Long roleId);

	/**
	 * 根据用户id获取角色
	 *
	 * @param userId
	 * @return
	 */
	List<SysRole> findRolesByUserId(Long userId);

	/**
	 * 根据用户ids 获取
	 *
	 * @param userIds
	 * @return
	 */
	List<SysRole> findRolesByUserIds(List<Long> userIds);
}
