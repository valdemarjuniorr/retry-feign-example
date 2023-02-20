package br.com.valdemarjr.retryfeignexample.controller;

import br.com.valdemarjr.retryfeignexample.client.MockResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/mock")
public class MockController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public MockResponse get() {
        log.info("mock get called");
        return MockResponse.builder()
                .userId(1)
                .title("delectus aut autem")
                .completed(Boolean.FALSE)
                .build();
    }

    @GetMapping("/timeout")
    public ResponseEntity<String> getTimeOut() {
        log.info("request timeout occurs");
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();

    }

    @GetMapping("/internalerror")
    public ResponseEntity<String> getInternalServerError() {
        log.info("Internal server error occurs");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
