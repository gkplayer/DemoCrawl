package com.crawl.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
//@PropertySource({"classpath:urlConfig.yaml"})
@ConfigurationProperties(prefix="xue-qiu")
public class XueQiuConfig {

    private String referer;

    private String apiUrl;

    private String cookUrl;

    private String dayOfKline;

    private String minLine;


}
