package br.com.valdemarjr.retryfeignexample.client;

import br.com.valdemarjr.retryfeignexample.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "client", url = "${mock.url}", configuration = FeignConfiguration.class)
public interface MockClient {

    @GetMapping
    MockResponse get();

    @GetMapping("/timeout")
    String getTimeout();

    @GetMapping("/internalerror")
    String getInternalError();
}
