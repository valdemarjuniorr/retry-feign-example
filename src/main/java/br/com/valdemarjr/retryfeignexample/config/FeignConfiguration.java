package br.com.valdemarjr.retryfeignexample.config;

import br.com.valdemarjr.retryfeignexample.exception.CustomErrorDecoder;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Value("${feign.client.config.default.connectTimeout}")
    private Long connectTimeout;

    @Value("${retry.maxAttempts}")
    private Integer maxAttempts;

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(1000L, connectTimeout, maxAttempts);
    }
}
