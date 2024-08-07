package com.board.api.config;

import com.board.api.properties.CorsProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final CorsProperties corsProperties;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");

        CorsRegistration corsRegistration = registry.addMapping(corsProperties.getPattern())
                .allowedOriginPatterns(corsProperties.getOriginPatterns())
                .allowCredentials(corsProperties.isCredentials())
                .allowedMethods(corsProperties.getMethods())
                .allowedHeaders(corsProperties.getHeaders());

        String[] origins = corsProperties.getOrigins();

        if (Objects.nonNull(origins)) {
            corsRegistration.allowedOrigins(origins);
        }
    }
}

