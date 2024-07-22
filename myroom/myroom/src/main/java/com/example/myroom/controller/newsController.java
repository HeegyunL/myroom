package com.example.myroom.controller;

import com.example.myroom.apify.ApifyInsta;
import com.example.myroom.apify.ApifyService;
import com.example.myroom.dto.News;
import com.example.myroom.repository.NewsRepository;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class newsController {
    private NewsRepository newsRepo;

    public newsController(NewsRepository newsRepo) {
        this.newsRepo = newsRepo;
    }

    @Autowired
    private ApifyService apifyService;


    @GetMapping("/news")
    public ModelAndView news(Model model,@Value("${APIFY_API_URL}") String apify) {
        ModelAndView mav = new ModelAndView();

        try {
            String data = apifyService.fetchData(apify);
            ObjectMapper objectMapper = new ObjectMapper();

            //List안에 map형식으로 받아야 한다. [{"":"","":""},{"":"","":""}]형식이기
            List<Map<String, String>> instaMap = objectMapper.readValue(data, List.class);

            //timestamp(작성 시간) 순서에 따라 정렬
            instaMap.sort(Comparator.comparing(
                    (Map<String,String> map )-> (String)map.get("timestamp")).reversed());
//          여러 컬럼을 조건으로 정렬
//            list.sort(
//                    Comparator.comparing(
//                            (Map<String, Object> map) -> (String)map.get("username")
//                    ).thenComparing(
//                            (Map<String, Object> map) -> (String)map.get("ID")
//                    ).reversed()
//            );
//

            model.addAttribute("data", instaMap);
        } catch (HttpClientErrorException e) {
            model.addAttribute("error", "Failed to fetch data from Apify: " + e.getStatusCode() + " " + e.getResponseBodyAsString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }



        mav.setViewName("services/news/newsMain");
        return mav;
    }



    @PostMapping("/news/add")
    public ModelAndView newsAdd(News news) throws IOException {
        ModelAndView mav = new ModelAndView();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowDate = new Date();
        news.setWrittenTime(dateFormat.format(nowDate));


        News addNews = newsRepo.save(news);

        mav.setViewName("index");
        return mav;
    }

}
