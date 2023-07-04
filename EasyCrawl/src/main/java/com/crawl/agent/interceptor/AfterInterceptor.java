package com.crawl.agent.interceptor;


import com.crawl.agent.AgentResult;
import com.crawl.agent.WebAgent;

import java.util.Map;

public interface AfterInterceptor {

    AgentResult interceptor(Map<String, Object> data, WebAgent webAgent);

}
