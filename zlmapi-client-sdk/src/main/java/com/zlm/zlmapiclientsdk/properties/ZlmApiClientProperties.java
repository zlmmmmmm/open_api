package com.zlm.zlmapiclientsdk.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "zlmapi.client")
public class ZlmApiClientProperties {
    private String accessKey;
    private String secretKey;
}
