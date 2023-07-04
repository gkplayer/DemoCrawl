package com.crawl.agent.interceptor.impl;

import com.crawl.agent.AgentResult;
import com.crawl.agent.WebAgent;
import com.crawl.agent.interceptor.AfterInterceptor;
import com.crawl.helper.http.ResponseAssertHelper;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
/**
 * @author kingschan
 */
@Slf4j
public class StatusPrintInterceptorImpl implements AfterInterceptor {

    @Override
    public AgentResult interceptor(Map<String, Object> data, WebAgent webAgent) {
        AgentResult result = webAgent.getResult();
        log.debug("ContentType : {}", result.getContentType());
        log.debug("编码 {} ",result.getCharset());
        log.debug("Headers : {}", result.getHeaders());
        log.debug("Cookies : {}", result.getCookies());
        log.debug("耗时 {} 毫秒",result.getTimeMillis());
        ResponseAssertHelper.of(result).infer();
        return result;
    }
}
