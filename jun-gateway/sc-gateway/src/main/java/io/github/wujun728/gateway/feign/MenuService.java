package io.github.wujun728.gateway.feign;

import io.github.wujun728.common.constant.ServiceNameConstants;
import io.github.wujun728.common.model.SysMenu;
import io.github.wujun728.gateway.feign.fallback.MenuServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author zlt
 */
@FeignClient(name = ServiceNameConstants.USER_SERVICE+"menuService", fallbackFactory = MenuServiceFallbackFactory.class, decode404 = true)
public interface MenuService {
	/**
	 * 角色菜单列表
	 * @param roleCodes
	 */
	@GetMapping(value = "/menus/{roleCodes}")
	List<SysMenu> findByRoleCodes(@PathVariable("roleCodes") String roleCodes);
}
