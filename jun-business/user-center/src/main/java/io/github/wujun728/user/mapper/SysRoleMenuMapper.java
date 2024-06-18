package io.github.wujun728.user.mapper;

import java.util.List;
import java.util.Set;

import io.github.wujun728.user.model.SysRoleMenu;
import io.github.wujun728.common.model.SysMenu;
import io.github.wujun728.db.mapper.SuperMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author jun
 * 角色菜单
 */
@Mapper
public interface SysRoleMenuMapper extends SuperMapper<SysRoleMenu> {
	@Insert("insert into sys_role_menu(role_id, menu_id) values(#{roleId}, #{menuId})")
	int save(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

	int delete(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

	List<SysMenu> findMenusByRoleIds(@Param("roleIds") Set<Long> roleIds, @Param("type") Integer type);

	List<SysMenu> findMenusByRoleCodes(@Param("roleCodes") Set<String> roleCodes, @Param("type") Integer type);
}
