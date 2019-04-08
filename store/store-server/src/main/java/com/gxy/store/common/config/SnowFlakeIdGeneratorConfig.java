package com.gxy.store.common.config;

import com.gxy.common.utils.SnowFlakeIdGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 构建SnowFlakeIdGenerator类,为module提供id生成工具
 *
 * @author guoxingyong
 * @since 2019/1/3 20:42
 */
@Configuration
public class SnowFlakeIdGeneratorConfig {

    @Value("${snowFlakeIdGenerator.workerId}")
    private Integer workerId;

    @Value("${snowFlakeIdGenerator.dataCenterId}")
    private Integer dataCenterId;


    @Bean
    public SnowFlakeIdGenerator snowFlakeIdGenerator() {
        return new SnowFlakeIdGenerator(workerId, dataCenterId);
    }
}
