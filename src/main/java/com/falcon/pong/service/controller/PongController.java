package com.falcon.pong.service.controller;

import com.falcon.pong.service.business.PongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PongController {

    @Autowired
    private PongService pongService;

    @GetMapping("/pong")
    public void pong(){
        pongService.pong();
    }
}
