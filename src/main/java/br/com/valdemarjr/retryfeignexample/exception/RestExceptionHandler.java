package br.com.valdemarjr.retryfeignexample.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> exception(Exception ex) {
        log.error("An exception occurs -> {}", ex.getCause());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getCause().getMessage()));
    }

    private record ResponseError(Integer code, String message) {}

}
