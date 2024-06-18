package io.github.wujun728.search.client.feign;

import io.github.wujun728.search.client.feign.fallback.SearchServiceFallbackFactory;
import io.github.wujun728.common.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * @author jun
 */
@FeignClient(name = ServiceNameConstants.SEARCH_SERVICE+"-aggregationService", fallbackFactory = SearchServiceFallbackFactory.class, decode404 = true)
public interface AggregationService {
    /**
     * 查询文档列表
     * @param indexName 索引名
     * @param routing es的路由
     */
    @GetMapping(value = "/agg/requestStat/{indexName}/{routing}")
    Map<String, Object> requestStatAgg(@PathVariable("indexName") String indexName, @PathVariable("routing") String routing);
}
