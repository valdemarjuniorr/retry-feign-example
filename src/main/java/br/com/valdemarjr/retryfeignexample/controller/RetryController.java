package br.com.valdemarjr.retryfeignexample.controller;

import br.com.valdemarjr.retryfeignexample.client.MockResponse;
import br.com.valdemarjr.retryfeignexample.client.MockClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/retry")
@RequiredArgsConstructor
public class RetryController {

    private final MockClient client;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public MockResponse getResponseOk() {
        log.info("getResponseOk called");
        return client.get();
    }

    @GetMapping("/timeout")
    public String getTimeOut() {
        log.info("getTimeOut called");
        return client.getTimeout();
    }

    @GetMapping("/internalerror")
    public String getInternalError() {
        log.info("getInternalError called");
        return client.getInternalError();
    }
}

