package com.example.democonsumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class DemoconsumerApplication {

    @Value("${demo.producerurl}")
    private String producerUrl;

    public static void main(String[] args) {
        SpringApplication.run(DemoconsumerApplication.class, args);
    }

    @GetMapping("/consumeDemo")
    public String consumeDemo() {

        String baseUrl = producerUrl;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> exchange = restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class);
        String answer = exchange.getBody();
        return "From demo, we received " + answer;

    }

}
