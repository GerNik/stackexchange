package ru.gernik.stackexchange.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import ru.gernik.stackexchange.exception.ErrorResponse;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class ServiceErrorHandler {

    @ExceptionHandler(value = {Throwable.class})
    public ResponseEntity<Object> exception(ServletWebRequest request, Throwable exception) {
        return new ResponseEntity<>(
                createResponse(exception.getMessage(), INTERNAL_SERVER_ERROR.getReasonPhrase(), request.getRequest().getPathInfo()),
                new HttpHeaders(), INTERNAL_SERVER_ERROR);
    }

    public ErrorResponse createResponse(String message, String errorCode, String path) {
        return ErrorResponse.builder()
                .errorCode(errorCode)
                .message(message)
                .path(path)
                .build();
    }
}
