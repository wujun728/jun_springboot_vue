package io.github.wujun728.user.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.wujun728.common.context.LoginUserContextHolder;
import io.github.wujun728.common.lock.DistributedLock;
import io.github.wujun728.common.model.PageResult;
import io.github.wujun728.common.model.Result;
import io.github.wujun728.common.model.SysRole;
import io.github.wujun728.common.service.impl.SuperServiceImpl;
import io.github.wujun728.user.mapper.SysRoleMapper;
import io.github.wujun728.user.mapper.SysRoleMenuMapper;
import io.github.wujun728.user.mapper.SysUserRoleMapper;
import io.github.wujun728.user.service.ISysRoleService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 */
@Slf4j
@Service
public class SysRoleServiceImpl extends SuperServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    private final static String LOCK_KEY_ROLECODE = "rolecode:";

    @Resource
    private SysUserRoleMapper userRoleMapper;

    @Resource
    private SysRoleMenuMapper roleMenuMapper;

    @Autowired
    private DistributedLock lock;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveRole(SysRole sysRole) throws Exception {
        String roleCode = sysRole.getCode();
        super.saveIdempotency(sysRole, lock
                , LOCK_KEY_ROLECODE+roleCode, new QueryWrapper<SysRole>().eq("code", roleCode), "角色code已存在");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteRole(Long id) {
        baseMapper.deleteById(id);
        roleMenuMapper.delete(id, null);
        userRoleMapper.deleteUserRole(null, id);
    }

    @Override
    public PageResult<SysRole> findRoles(Map<String, Object> params) {
        Integer curPage = MapUtils.getInteger(params, "page");
        Integer limit = MapUtils.getInteger(params, "limit");
        Page<SysRole> page = new Page<>(curPage == null ? 0 : curPage, limit == null ? -1 : limit);
        List<SysRole> list = baseMapper.findList(page, params);
        return PageResult.<SysRole>builder().data(list).code(0).count(page.getTotal()).build();
    }

    @Override
    @Transactional
    public Result saveOrUpdateRole(SysRole sysRole) throws Exception {
        if (sysRole.getId() == null) {
            sysRole.setCreatorId(LoginUserContextHolder.getUser().getId());
            this.saveRole(sysRole);
        } else {
            baseMapper.updateById(sysRole);
        }
        return Result.succeed("操作成功");
    }

    @Override
    public List<SysRole> findAll() {
        return baseMapper.findAll();
    }
}
