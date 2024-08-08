package com.example.myroom.controller;

import com.example.myroom.apify.ApifyInsta;
import com.example.myroom.apify.ApifyService;
import com.example.myroom.dto.News;
import com.example.myroom.repository.NewsRepository;
import com.example.myroom.service.MainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class newsController {
    private NewsRepository newsRepo;
    private MainService mainService;

    public newsController(NewsRepository newsRepo) {
        this.newsRepo = newsRepo;
    }


    @Autowired
    private ApifyService apifyService;

    @Value("${APIFY_API_URL}")
    private String apify;


    @GetMapping("/news")
    public ModelAndView news(Model model) {
        ModelAndView mav = new ModelAndView();

        try {
            String data = apifyService.fetchData(apify);
            ObjectMapper objectMapper = new ObjectMapper();

            //List안에 map형식으로 받아야 한다. [{"":"","":""},{"":"","":""}]형식이기
            List<Map<String, String>> instaMap = objectMapper.readValue(data, List.class);

            //timestamp(작성 시간) 순서에 따라 정렬
            instaMap.sort(Comparator.comparing(
                    (Map<String,String> map )-> (String)map.get("timestamp")).reversed());

            System.out.println(instaMap.toString());
            model.addAttribute("data", instaMap);
        } catch (HttpClientErrorException e) {
            model.addAttribute("error", "Failed to fetch data from Apify: " + e.getStatusCode() + " " + e.getResponseBodyAsString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }



        mav.setViewName("services/news/newsMain");
        return mav;
    }
    @GetMapping("/news/{id}")
    public ModelAndView newsDetail(News news, @PathVariable("id") int id) throws IOException {

        ModelAndView mav = new ModelAndView();

        String data = apifyService.fetchData(apify);
        ObjectMapper objectMapper = new ObjectMapper();

        //List안에 map형식으로 받아야 한다. [{"":"","":""},{"":"","":""}]형식이기
        List<Map<String, String>> instaMap = objectMapper.readValue(data, List.class);
        instaMap.sort(Comparator.comparing(
                (Map<String,String> map )-> (String)map.get("timestamp")).reversed());

        String input = instaMap.get(id).get("timestamp");


        // 입력 형식의 DateTimeFormatter
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");

        // ZonedDateTime으로 변환
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(input, inputFormatter);

        // 원하는 형식의 DateTimeFormatter
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        // ZonedDateTime을 LocalDateTime으로 변환 (타임존 정보 제거)
        LocalDateTime localDateTime = zonedDateTime.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();

        // 원하는 형식으로 포맷팅
        String formattedDate = localDateTime.format(outputFormatter);


        System.out.println("data is ==" + instaMap.get(id));
        mav.addObject("data", instaMap.get(id));
        mav.addObject("date", formattedDate);
        mav.setViewName("services/news/newsDetail");
        return mav;
    }


    @PostMapping("/news/add")
    public ModelAndView newsAdd(News news) throws IOException {
        ModelAndView mav = new ModelAndView();
        news.setWrittenTime(mainService.nowDate());
        newsRepo.save(news);

        mav.setViewName("index");
        return mav;
    }

}
