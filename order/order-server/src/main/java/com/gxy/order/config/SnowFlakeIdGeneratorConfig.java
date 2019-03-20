package com.gxy.order.config;

import com.gxy.common.utils.SnowFlakeIdGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
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
