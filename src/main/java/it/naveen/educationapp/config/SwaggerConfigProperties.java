package it.naveen.educationapp.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration("swaggerConfigProperties")
public class SwaggerConfigProperties {
    @Value("${educationapp.version}")
    private String apiVersion;
    @Value("${educationapp.swagger.enabled}")
    private String enabled = "false";
    @Value("${educationapp.swagger.title}")
    private String title;
    @Value("${educationapp.swagger.description}")
    private String description;
    @Value("${educationapp.swagger.useDefaultResponseMessages}")
    private String useDefaultResponseMessages;
    @Value("${educationapp.swagger.enableUrlTemplating}")
    private String enableUrlTemplating;
    @Value("${educationapp.swagger.deepLinking}")
    private String deepLinking;
    @Value("${educationapp.swagger.defaultModelsExpandDepth}")
    private String defaultModelsExpandDepth;
    @Value("${educationapp.swagger.defaultModelExpandDepth}")
    private String defaultModelExpandDepth;
    @Value("${educationapp.swagger.displayOperationId}")
    private String displayOperationId;
    @Value("${educationapp.swagger.displayRequestDuration}")
    private String displayRequestDuration;
    @Value("${educationapp.swagger.filter}")
    private String filter;
    @Value("${educationapp.swagger.maxDisplayedTags}")
    private String maxDisplayedTags;
    @Value("${educationapp.swagger.showExtensions}")
    private String showExtensions;
}
