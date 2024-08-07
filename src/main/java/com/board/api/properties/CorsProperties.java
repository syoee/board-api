package com.board.api.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "cors.allowed")
public class CorsProperties {
    private String pattern;
    private String[] origins;
    private String[] originPatterns;
    private boolean credentials;
    private String[] methods;
    private String[] headers;
}
