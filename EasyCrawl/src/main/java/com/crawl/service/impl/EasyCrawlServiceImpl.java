package com.crawl.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.crawl.agent.WebAgent;
import com.crawl.config.XueQiuConfig;
import com.crawl.service.EasyCrawlService;
import com.crawl.task.EasyCrawl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EasyCrawlServiceImpl implements EasyCrawlService {

    @Autowired
    private XueQiuConfig xueQiuConfig;

    @Override
    public List getAllCode() {
        return new EasyCrawl<List<JSONObject>>()
                .webAgent(WebAgent.defaultAgent().url(xueQiuConfig.getApiUrl()).referer(xueQiuConfig.getReferer()))
                .analyze(r -> {
                    List<JSONObject> jsonObjects = new ArrayList<>();
                    JSONArray jsonArray = r.getJson().get("data.list", JSONArray.class);
                    for (int j = 0; j < jsonArray.size(); j++) {
                        jsonObjects.add(jsonArray.getJSONObject(j));
                    }
                    return jsonObjects;
                }).executePage(null, "page", "data.count", 200);
    }
}
