package com.jun.plugin.oauth.service;

import com.jun.plugin.common.model.PageResult;
import com.jun.plugin.common.model.Result;
import com.jun.plugin.common.service.ISuperService;
import com.jun.plugin.oauth.model.Client;

import java.util.Map;

/**
 * @author zlt
 * <p>
 * Blog: https://zlt2000.gitee.io
 * Github: https://github.com/zlt2000
 */
public interface IClientService extends ISuperService<Client> {
    Result saveClient(Client clientDto) throws Exception;

    /**
     * 查询应用列表
     * @param params
     * @param isPage 是否分页
     */
    PageResult<Client> listClient(Map<String, Object> params, boolean isPage);

    void delClient(long id);

    Client loadClientByClientId(String clientId);
}
