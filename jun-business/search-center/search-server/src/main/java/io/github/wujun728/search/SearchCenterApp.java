package io.github.wujun728.search;

import io.github.wujun728.search.admin.properties.IndexProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jun
 * @date 2019/5/1
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableConfigurationProperties(IndexProperties.class)
public class SearchCenterApp {
    public static void main(String[] args) {
        SpringApplication.run(SearchCenterApp.class, args);
    }
}
