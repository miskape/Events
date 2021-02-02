package com.backend.demo;


import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;


public class EventJsonReader {

    // Getting data from MyHelsinki Open API
    public static String simpleHttpRequest(){
        try{
            RestTemplate restTemplate = new RestTemplate();
            String obj = restTemplate.getForObject("http://open-api.myhelsinki.fi/v1/events/", String.class);
            JSONObject jsonObject = new JSONObject(obj);
            String json = jsonObject.get("data").toString();
            String formattedJson = json;
            return formattedJson;
        }catch (Exception e){
            return "";
        }
    }
}
