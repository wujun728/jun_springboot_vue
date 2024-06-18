package io.github.wujun728.file.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

//import io.github.wujun728.file.model.FileInfo;
import io.github.wujun728.db.mapper.SuperMapper;
import io.github.wujun728.file.model.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 上传存储db
 *
 * @author jun
 */
@Mapper
public interface FileMapper extends SuperMapper<FileInfo> {
    List<FileInfo> findList(Page<FileInfo> page, @Param("f") Map<String, Object> params);
}
