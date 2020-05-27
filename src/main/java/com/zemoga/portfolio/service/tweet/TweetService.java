package com.zemoga.portfolio.service.tweet;

import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

public interface TweetService {
    Twitter getTwitterTemplate();
}
