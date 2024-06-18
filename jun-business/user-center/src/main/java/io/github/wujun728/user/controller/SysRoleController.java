package io.github.wujun728.user.controller;

import java.util.List;
import java.util.Map;

import io.github.wujun728.common.model.PageResult;
import io.github.wujun728.common.model.Result;
import io.github.wujun728.common.model.SysRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.wujun728.user.service.ISysRoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * 角色管理
 */
@Slf4j
@RestController
@Api(tags = "角色模块api")
public class SysRoleController {
    @Autowired
    private ISysRoleService sysRoleService;

    /**
     * 后台管理查询角色
     * @param params
     * @return
     */
    @ApiOperation(value = "后台管理查询角色")
    @GetMapping("/roles")
    public PageResult<SysRole> findRoles(@RequestParam Map<String, Object> params) {
        return sysRoleService.findRoles(params);
    }

    /**
     * 用户管理查询所有角色
     * @return
     */
    @ApiOperation(value = "后台管理查询角色")
    @GetMapping("/allRoles")
    public Result<List<SysRole>> findAll() {
        List<SysRole> result = sysRoleService.findAll();
        return Result.succeed(result);
    }

    /**
     * 角色新增或者更新
     *
     * @param sysRole
     * @return
     */
    @PostMapping("/roles/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SysRole sysRole) throws Exception {
        return sysRoleService.saveOrUpdateRole(sysRole);
    }

    /**
     * 后台管理删除角色
     * delete /role/1
     *
     * @param id
     */
    @ApiOperation(value = "后台管理删除角色")
    @DeleteMapping("/roles/{id}")
    public Result deleteRole(@PathVariable Long id) {
        try {
            if (id == 1L) {
                return Result.failed("管理员不可以删除");
            }
            sysRoleService.deleteRole(id);
            return Result.succeed("操作成功");
        } catch (Exception e) {
            log.error("role-deleteRole-error", e);
            return Result.failed("操作失败");
        }
    }
}
