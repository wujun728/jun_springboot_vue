package io.github.wujun728.search.annotation;

import io.github.wujun728.search.client.feign.fallback.SearchServiceFallbackFactory;
import io.github.wujun728.search.client.service.impl.QueryServiceImpl;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 控制是否加载搜索中心客户端的Service
 *
 * @author jun
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@EnableFeignClients(basePackages = "io.github.wujun728")
@Import({SearchServiceFallbackFactory.class, QueryServiceImpl.class})
public @interface EnableSearchClient {

}
