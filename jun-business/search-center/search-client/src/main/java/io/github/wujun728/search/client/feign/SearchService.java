package io.github.wujun728.search.client.feign;

import io.github.wujun728.search.client.feign.fallback.SearchServiceFallbackFactory;
import io.github.wujun728.search.model.SearchDto;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.wujun728.common.constant.ServiceNameConstants;
import io.github.wujun728.common.model.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author jun
 */
@FeignClient(name = ServiceNameConstants.SEARCH_SERVICE, fallbackFactory = SearchServiceFallbackFactory.class, decode404 = true)
public interface SearchService {
    /**
     * 查询文档列表
     * @param indexName 索引名
     * @param searchDto 搜索Dto
     */
    @PostMapping(value = "/search/{indexName}")
    PageResult<JsonNode> strQuery(@PathVariable("indexName") String indexName, @RequestBody SearchDto searchDto);
}
