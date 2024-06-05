package com.jun.plugin.search.service;

import com.jun.plugin.search.model.SearchDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.jun.plugin.common.model.PageResult;

import java.io.IOException;

/**
 * @author zlt
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
