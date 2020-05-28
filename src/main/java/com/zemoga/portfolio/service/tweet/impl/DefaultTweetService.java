package com.zemoga.portfolio.service.tweet.impl;

import com.zemoga.portfolio.service.tweet.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;

@Service
public class DefaultTweetService implements TweetService {

    @Autowired
    private Environment env;

    @Override
    public Twitter getTwitterTemplate() {
        String consumerKey = env.getProperty("twitter.consumerKey.val");
        String consumerSecret = env.getProperty("twitter.consumerSecret.val");
        String accessToken = env.getProperty("twitter.accessToken.val");
        String accessTokenSecret = env.getProperty("twitter.accessTokenSecret.val");
        return new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
    }
}
