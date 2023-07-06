package com.crawl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.crawl.entity.CrawlCode;
import com.crawl.service.EasyCrawlService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EasyCrawlApplicationTests {

    @Autowired
    private EasyCrawlService easyCrawlService;
    @Test
    void contextLoads() {
    }


    @Test
    void getAllCodeTest(){
        List<JSONObject> allCode = easyCrawlService.getAllCode();
        System.out.println(JSON.toJSONString(allCode));

    }


    @Test
    void getCode() throws IOException {
        ClassPathResource resource = new ClassPathResource("allCode.json");

        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

        char[] chars = new char[1024];
        StringBuilder builder = new StringBuilder();
        int len;
        while ( (len=reader.read(chars, 0, chars.length))>0){
            builder.append(chars,0,len);
        }
        JSONArray array = JSONArray.parseArray(builder.toString());

        ArrayList<CrawlCode> list = new ArrayList<>();
        array.forEach(item->{
            if (item instanceof JSONObject){
                CrawlCode crawlCode = new CrawlCode();
                String symbol = ((JSONObject) item).getString("symbol");
                String name = ((JSONObject) item).getString("name");
                crawlCode.setCode(symbol);
                crawlCode.setName(name);
                list.add(crawlCode);
            }
        });
        System.out.println(JSON.toJSONString(list));
    }
}
