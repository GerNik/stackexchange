package ru.gernik.stackexchange.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

@Component
@EnableFeignClients("ru.gernik.stackexchange.service.client")
public class FeignConfiguration {
}
