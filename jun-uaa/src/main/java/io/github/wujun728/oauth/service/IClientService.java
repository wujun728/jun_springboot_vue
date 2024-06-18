package io.github.wujun728.oauth.service;

import io.github.wujun728.common.model.PageResult;
import io.github.wujun728.common.model.Result;
import io.github.wujun728.common.service.ISuperService;
import io.github.wujun728.oauth.model.Client;

import java.util.Map;

/**
 * @author jun
 * <p>
 * Blog: https://jun2000.gitee.io
 * Github: https://github.com/jun2000
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
