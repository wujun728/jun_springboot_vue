package io.github.wujun728.generator.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.wujun728.db.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author jun
 */
@Component
@Mapper
public interface SysGeneratorMapper extends SuperMapper {
    List<Map<String, Object>> queryList(Page<Map<String, Object>> page, @Param("p") Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
}
