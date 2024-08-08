package com.example.myroom.opendata;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;


@Controller
@ResponseBody
public class OpendataController {

    @GetMapping("/opendata")
    public String opendata() throws IOException {

        String serviceKey = "6JUfvlvL1ZWWhdncPz1ouyPEc3zocQOf4m7XgeGfVel81lNmPcAk2%2BIxudY%2BuQVFGW2rvpmOFkhw2QccUGJ%2BcA%3D%3D";
        StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/1230000/BidPublicInfoService04/getBidPblancListInfoServcPPSSrch01"); /*URL*/
        urlBuilder.append("?").append(URLEncoder.encode("serviceKey", "UTF-8")).append("=").append(serviceKey); /*Service Key*/
        urlBuilder.append("&").append(URLEncoder.encode("inqryDiv", "UTF-8")).append("=").append(URLEncoder.encode("1", "UTF-8")); /*검색하고자하는 조회구분 1:공고게시일시, 2:개찰일시 (방위사업청 연계건의 경우 조회구분) 1. 공고게시일시 : 공고일자(pblancDate)*/
        urlBuilder.append("&").append(URLEncoder.encode("inqryBgnDt", "UTF-8")).append("=").append(URLEncoder.encode("202408020000", "UTF-8")); /*검색하고자 하는 조회시작일시*/
        urlBuilder.append("&").append(URLEncoder.encode("inqryEndDt", "UTF-8")).append("=").append(URLEncoder.encode("202408022359", "UTF-8")); /*검색하고자 하는 조회종료일시*/
        urlBuilder.append("&").append(URLEncoder.encode("type", "UTF-8")).append("=").append(URLEncoder.encode("json", "UTF-8")); /*오픈API 리턴 타입을 JSON으로 받고 싶을 경우 'json' 으로 지정*/
        urlBuilder.append("&").append(URLEncoder.encode("bidClseExcpYn", "UTF-8")).append("=").append(URLEncoder.encode("Y", "UTF-8")); /*입찰마감건을 제외하고 검색하고자 하는 경우 Y*/
        urlBuilder.append("&").append(URLEncoder.encode("numOfRows", "UTF-8")).append("=").append(URLEncoder.encode("10", "UTF-8")); /*조회될 목록의 페이지당 데이터 개수 (기본값:10)*/
        urlBuilder.append("&").append(URLEncoder.encode("pageNo", "UTF-8")).append("=").append(URLEncoder.encode("1", "UTF-8")); /*조회될 페이지의 번호 (기본값:1)*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(urlBuilder.toString());

        return sb.toString() ;
    }
}



