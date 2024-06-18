package io.github.wujun728.oauth.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.wujun728.db.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import io.github.wujun728.oauth.model.Client;

/**
 * @author jun
 */
@Mapper
public interface ClientMapper extends SuperMapper<Client> {
    List<Client> findList(Page<Client> page, @Param("params") Map<String, Object> params );
}
