package io.github.wujun728;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jun
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "io.github.wujun728")
@SpringBootApplication
public class CodeGeneratorApp {
    public static void main(String[] args) {
        SpringApplication.run(CodeGeneratorApp.class, args);
    }
}
