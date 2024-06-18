package io.github.wujun728.search.service;

import io.github.wujun728.search.model.SearchDto;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.wujun728.common.model.PageResult;

import java.io.IOException;

/**
 * @author jun
 * @date 2019/4/24
 */
public interface ISearchService {
    /**
     * StringQuery通用搜索
     * @param indexName 索引名
     * @param searchDto 搜索Dto
     * @return
     */
    PageResult<JsonNode> strQuery(String indexName, SearchDto searchDto) throws IOException;
}
