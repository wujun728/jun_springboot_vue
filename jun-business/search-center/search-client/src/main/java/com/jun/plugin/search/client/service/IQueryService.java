package com.jun.plugin.search.client.service;

import com.jun.plugin.search.model.LogicDelDto;
import com.jun.plugin.search.model.SearchDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.jun.plugin.common.model.PageResult;

import java.util.Map;

/**
 * 搜索客户端接口
 *
 * @author zlt
 * @date 2019/4/24
 */
public interface IQueryService {
    /**
     * 查询文档列表
     * @param indexName 索引名
     * @param searchDto 搜索Dto
     */
    PageResult<JsonNode> strQuery(String indexName, SearchDto searchDto);

    /**
     * 查询文档列表
     * @param indexName 索引名
     * @param searchDto 搜索Dto
     * @param logicDelDto 逻辑删除Dto
     */
    PageResult<JsonNode> strQuery(String indexName, SearchDto searchDto, LogicDelDto logicDelDto);

    /**
     * 访问统计聚合查询
     * @param indexName 索引名
     * @param routing es的路由
     */
    Map<String, Object> requestStatAgg(String indexName, String routing);
}
