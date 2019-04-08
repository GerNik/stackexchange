package ru.gernik.stackexchange.configuration;

import feign.httpclient.ApacheHttpClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@EnableFeignClients("ru.gernik.stackexchange.service.client")
public class FeignConfiguration {

    @Bean
    public ApacheHttpClient apacheHttpClient() {
        return new ApacheHttpClient();
    }
}
