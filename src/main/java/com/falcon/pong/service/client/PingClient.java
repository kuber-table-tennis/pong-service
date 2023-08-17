package com.falcon.pong.service.client;

import com.falcon.pong.service.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PingClient {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PingClient.class);

    @Autowired
    private ConfigProperties configProperties;

    @Autowired
    private RestTemplate restTemplate;

    public void pongToPing(){
        log.info("Pong Service: Pong");
    }
}
