package com.example.myroom.apify;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ApifyService {
    private static final String APIFY_API_URL = "https://api.apify.com/v2/datasets/pvcdbmi3YLtjgf4Qk/items?token=apify_api_6GQEPmak13Y0FbepwfMWQpkYdzl7j70xYT2J";

    public String fetchData(){
        RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.getForObject(APIFY_API_URL, String.class);
        } catch (HttpClientErrorException e) {
            // 예외 처리
            System.out.println("Error occurred while fetching data from Apify: " + e.getMessage());
            throw e; // 다시 예외를 던져 컨트롤러에서 처리할 수 있도록 함
        }
    }
}
