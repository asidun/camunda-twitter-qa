package com.camunda.training.delegate;

import com.camunda.training.service.TwitterService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CreateTweetDelegate implements JavaDelegate {
    TwitterService twitterService = new TwitterService();
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String content = (String) delegateExecution.getVariable("content");
        twitterService.updateStatus(content);

    }
}
