package ru.gernik.stackexchange.service.client.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ClientException extends RuntimeException {

    private Integer status;
    private String responseBody;
}
