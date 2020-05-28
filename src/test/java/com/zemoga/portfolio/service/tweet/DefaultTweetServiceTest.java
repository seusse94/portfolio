package com.zemoga.portfolio.service.tweet;

import com.zemoga.portfolio.service.tweet.impl.DefaultTweetService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.social.twitter.api.impl.TwitterTemplate;


@SpringBootTest()
public class DefaultTweetServiceTest {


    @Before
    public void setup(){

    }

    @InjectMocks
    private DefaultTweetService defaultTweetService;

    @Mock
    private Environment env;


    @Test
    void getTwitterTemplateTest() {
        Mockito.when(env.getProperty("twitter.consumerKey.val")).thenReturn("testKey");
        Mockito.when(env.getProperty("twitter.consumerSecret.val")).thenReturn("testSecretKey");
        Mockito.when(env.getProperty("twitter.accessToken.val")).thenReturn("testAccessToken");
        Mockito.when(env.getProperty("twitter.accessTokenSecret.val")).thenReturn("testAccessTokenSecret");
        Assert.assertNotNull(defaultTweetService.getTwitterTemplate());
        Assert.assertTrue(defaultTweetService.getTwitterTemplate() instanceof TwitterTemplate);

    }


}
