package io.github.wujun728.oauth.service;

import io.github.wujun728.common.model.PageResult;
import io.github.wujun728.oauth.model.TokenVo;

import java.util.Map;

/**
 * @author jun
 */
public interface ITokensService {
    /**
     * 查询token列表
     * @param params 请求参数
     * @param clientId 应用id
     */
    PageResult<TokenVo> listTokens(Map<String, Object> params, String clientId);
}
