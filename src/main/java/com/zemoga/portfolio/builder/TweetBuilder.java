package com.zemoga.portfolio.builder;

import com.zemoga.portfolio.dto.TweetDto;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;

@Component
public class TweetBuilder extends AbstractBuilder<Tweet, TweetDto> {

    public TweetBuilder() {
        super();
        this.setClassD(TweetDto.class);
        this.setClassE(Tweet.class);
    }




}
