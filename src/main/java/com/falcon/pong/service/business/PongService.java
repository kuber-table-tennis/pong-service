package com.falcon.pong.service.business;

import com.falcon.pong.service.client.PingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PongService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PongService.class);


    @Autowired
    private PingClient pingClient;

    public void pong(){
        log.info("Pong Service: Pong");
    }
    public void sendPong(){
        try{
            pingClient.pongToPing();
        }catch(Exception e){
            log.info(e.getMessage());
        }
    }
}
