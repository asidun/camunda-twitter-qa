package com.camunda.training.service;

import lombok.extern.java.Log;

@Log
public class TwitterService {
    public void updateStatus(String content){
        log.info("TWEET: " + content);
    }
}
