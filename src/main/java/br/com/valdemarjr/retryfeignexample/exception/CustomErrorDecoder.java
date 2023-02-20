package br.com.valdemarjr.retryfeignexample.exception;

import feign.FeignException;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String method, Response response) {
        var exception = FeignException.errorStatus(method, response);
        var status = HttpStatus.resolve(response.status());
        switch (status) {
            case REQUEST_TIMEOUT, BAD_GATEWAY, GATEWAY_TIMEOUT, SERVICE_UNAVAILABLE:
                return createRetryException(exception, response);
            default:
                return new Exception("Generic Exception");
        }
    }

    private FeignException createRetryException(FeignException exception, Response response) {
        return new RetryableException(
                response.status(),
                exception.getMessage(),
                response.request().httpMethod(),
                exception,
                null,
                response.request());
    }
}
