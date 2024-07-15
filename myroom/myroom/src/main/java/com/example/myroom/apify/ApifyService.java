package com.example.myroom.apify;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ApifyService {


    public String fetchData(@Value("${APIFY_API_URL}") String apify){
        RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.getForObject(apify, String.class);
        } catch (HttpClientErrorException e) {
            // 예외 처리
            System.out.println("Error occurred while fetching data from Apify: " + e.getMessage());
            throw e; // 다시 예외를 던져 컨트롤러에서 처리할 수 있도록 함
        }
    }
}
