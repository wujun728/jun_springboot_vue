package io.github.wujun728.user.service;

import io.github.wujun728.common.model.PageResult;
import io.github.wujun728.common.model.Result;
import io.github.wujun728.common.model.SysRole;
import io.github.wujun728.common.service.ISuperService;

import java.util.List;
import java.util.Map;


/**
 * @author jun
 * <p>
 * Blog: https://jun2000.gitee.io
 * Github: https://github.com/jun2000
 */
public interface ISysRoleService extends ISuperService<SysRole> {
	void saveRole(SysRole sysRole) throws Exception;

	void deleteRole(Long id);

	/**
	 * 角色列表
	 * @param params
	 * @return
	 */
	PageResult<SysRole> findRoles(Map<String, Object> params);

	/**
	 * 新增或更新角色
	 * @param sysRole
	 * @return Result
	 */
	Result saveOrUpdateRole(SysRole sysRole) throws Exception;

	/**
	 * 查询所有角色
	 * @return
	 */
	List<SysRole> findAll();
}
