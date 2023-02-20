package br.com.valdemarjr.retryfeignexample.client;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MockResponse {
    private Integer userId;
    private String title;
    private Boolean completed;
}