package it.naveen.educationapp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "educationapp.corsconfig")
@Getter
@Setter
public class CorsConfigProperties {
    private String[] allowedOrgin;

    private String[] allowedMethods;

    private boolean allowCredentials;

    private long maxAge;
}
