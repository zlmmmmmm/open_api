package com.zlm.zlmapiclientsdk.config;

import com.zlm.zlmapiclientsdk.client.ZlmApiClient;
import com.zlm.zlmapiclientsdk.properties.ZlmApiClientProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ZlmApiClientProperties.class)
@Data
@ComponentScan
public class ZlmApiClientConfig {

    @Autowired private ZlmApiClientProperties zlmApiClientProperties;

    @Bean
    public ZlmApiClient zlmApiClient() {
        return new ZlmApiClient(zlmApiClientProperties.getAccessKey(), zlmApiClientProperties.getSecretKey());
    }
}
