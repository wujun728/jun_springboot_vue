package io.github.wujun728.user.config;

import io.github.wujun728.common.config.DefaultAsycTaskConfig;
import org.springframework.context.annotation.Configuration;

/**
 * @author jun
 * 线程池配置、启用异步
 * @Async quartz 需要使用
 */
@Configuration
public class AsycTaskExecutorConfig extends DefaultAsycTaskConfig {

}
