package com.jun.plugin.search.client.feign;

import com.jun.plugin.search.client.feign.fallback.SearchServiceFallbackFactory;
import com.jun.plugin.search.model.SearchDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.jun.plugin.common.constant.ServiceNameConstants;
import com.jun.plugin.common.model.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author zlt
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
