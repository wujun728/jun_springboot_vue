package io.github.wujun728.user.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.wujun728.common.model.SysRole;
import io.github.wujun728.db.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author jun
 * 角色
 */
@Mapper
public interface SysRoleMapper extends SuperMapper<SysRole> {
	List<SysRole> findList(Page<SysRole> page, @Param("r") Map<String, Object> params);

	List<SysRole> findAll();
}
