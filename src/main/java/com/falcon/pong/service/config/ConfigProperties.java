package com.falcon.pong.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "service.config")
public class ConfigProperties {
    private String pingUrl;

    public String getPingUrl() {
        return pingUrl;
    }

    public void setPingUrl(String pingUrl) {
        this.pingUrl = pingUrl;
    }
}
