package io.github.wujun728.search.client.feign.fallback;

import io.github.wujun728.search.client.feign.SearchService;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.wujun728.common.model.PageResult;
import org.springframework.cloud.openfeign.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * searchService降级工场
 *
 * @author jun
 */
@Slf4j
public class SearchServiceFallbackFactory implements FallbackFactory<SearchService> {
    @Override
    public SearchService create(Throwable throwable) {
        return (indexName, searchDto) -> {
            log.error("通过索引{}搜索异常:{}", indexName, throwable);
            return PageResult.<JsonNode>builder().build();
        };
    }
}
