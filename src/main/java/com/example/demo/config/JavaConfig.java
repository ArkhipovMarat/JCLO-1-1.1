package com.example.demo.config;

import com.example.demo.systemprofile.DevProfile;
import com.example.demo.systemprofile.ProductionProfile;
import com.example.demo.systemprofile.SystemProfile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "true", matchIfMissing = true)
    public SystemProfile developmentProfile() {
       return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "false", matchIfMissing = true)
    public SystemProfile productionProfile() {
        return new ProductionProfile();
    }
}
