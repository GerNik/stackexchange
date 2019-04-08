package ru.gernik.stackexchange.service.client.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class ClientErrorDecoder implements ErrorDecoder {

    private ErrorDecoder decoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {

        String responseBody;
        try {
            responseBody = IOUtils.toString(response.body().asInputStream());
        } catch (IOException e) {
            return new RuntimeException(e);
        }
        if (response.status() >= 400) {
            log.error("Response status {}, Response body {}", response.status(), responseBody);
            return new ClientException(response.status(), responseBody);
        }
        return decoder.decode(methodKey, response);
    }
}
