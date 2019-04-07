package ru.gernik.stackexchange.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.singletonList;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Value("${swagger.context.root}")
    private String contextRoot;
    @Value("${spring.application.name}")
    private String appName;
    @Value("${spring.application.description}")
    private String appDescription;

    @Bean
    public Docket apiInfo() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title(appName)
                        .description(appDescription)
                        .build())
                .useDefaultResponseMessages(false)
                .pathMapping(contextRoot)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build()
                .globalResponseMessage(RequestMethod.POST,
                        newArrayList(new ResponseMessageBuilder()
                                .code(500)
                                .message("500 message")
                                .responseModel(new ModelRef("Error"))
                                .build()))
                .produces(new HashSet<>(singletonList(APPLICATION_JSON_VALUE)))
                .consumes(new HashSet<>(singletonList(APPLICATION_JSON_VALUE)));
    }
}
