package com.jun.plugin.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jun.plugin.user.mapper.SysMenuMapper;
import com.jun.plugin.user.model.SysRoleMenu;
import com.jun.plugin.user.service.ISysMenuService;
import com.jun.plugin.user.service.ISysRoleMenuService;
import com.jun.plugin.common.model.SysMenu;
import com.jun.plugin.common.service.impl.SuperServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 */
@Slf4j
@Service
public class SysMenuServiceImpl extends SuperServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
 	@Resource
	private ISysRoleMenuService roleMenuService;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void setMenuToRole(Long roleId, Set<Long> menuIds) {
		roleMenuService.delete(roleId, null);

		if (!CollectionUtils.isEmpty(menuIds)) {
			List<SysRoleMenu> roleMenus = new ArrayList<>(menuIds.size());
			menuIds.forEach(menuId -> roleMenus.add(new SysRoleMenu(roleId, menuId)));
			roleMenuService.saveBatch(roleMenus);
		}
	}

	/**
	 * 角色菜单列表
	 * @param roleIds
	 * @return
	 */
	@Override
	public List<SysMenu> findByRoles(Set<Long> roleIds) {
		return roleMenuService.findMenusByRoleIds(roleIds, null);
	}

	/**
	 * 角色菜单列表
	 * @param roleIds 角色ids
	 * @param roleIds 是否菜单
	 * @return
	 */
	@Override
	public List<SysMenu> findByRoles(Set<Long> roleIds, Integer type) {
		return roleMenuService.findMenusByRoleIds(roleIds, type);
	}

	@Override
	public List<SysMenu> findByRoleCodes(Set<String> roleCodes, Integer type) {
		return roleMenuService.findMenusByRoleCodes(roleCodes, type);
	}

    /**
     * 查询所有菜单
     */
	@Override
	public List<SysMenu> findAll() {
		return baseMapper.selectList(
                new QueryWrapper<SysMenu>().orderByAsc("sort")
        );
	}

    /**
     * 查询所有一级菜单
     */
	@Override
	public List<SysMenu> findOnes() {
        return baseMapper.selectList(
                new QueryWrapper<SysMenu>()
                        .eq("type", 1)
                        .orderByAsc("sort")
        );
	}
}
