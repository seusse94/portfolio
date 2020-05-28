package com.zemoga.portfolio.controller;

import com.zemoga.portfolio.builder.PortfolioBuilder;
import com.zemoga.portfolio.builder.TweetBuilder;
import com.zemoga.portfolio.constant.PortfolioConstants;
import com.zemoga.portfolio.dto.PortfolioDto;
import com.zemoga.portfolio.dto.PortfolioEditedDto;
import com.zemoga.portfolio.dto.ProfileDto;
import com.zemoga.portfolio.dto.TweetDto;
import com.zemoga.portfolio.exception.PortfolioException;
import com.zemoga.portfolio.service.portfolio.PortfolioService;
import com.zemoga.portfolio.service.tweet.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PortfolioController {

    public static final int PAGE_SIZE_TWEETS = 5;
    @Autowired
    private TweetBuilder tweetBuilder;
    @Autowired
    private PortfolioBuilder portfolioBuilder;
    @Autowired
    private PortfolioService portfolioService;
    @Autowired
    private TweetService tweetService;


    @GetMapping(value = "user/{username}/tweets", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TweetDto> getUserTweets(@PathVariable String username) {
        Twitter twitter = tweetService.getTwitterTemplate();
        return tweetBuilder.listEntitiesToListDTOs(twitter.timelineOperations().getUserTimeline(username, PAGE_SIZE_TWEETS));

    }

    @GetMapping(value = "user/{username}/profile", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProfileDto getUserProfile(@PathVariable String username) {
        List<TweetDto> userTweets = getUserTweets(username);
        PortfolioDto portfolioDto = portfolioBuilder.entityToDTO(portfolioService.findAllByTwitterUserName(username).stream().findFirst().orElseThrow(()-> new PortfolioException(PortfolioConstants.THE_USER_DOES_NOT_EXIST)));
        return new ProfileDto(portfolioDto, userTweets);
    }

    @PutMapping(value = "user/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public void getUserProfile(@RequestBody PortfolioEditedDto portfolioEditedDto) {
        portfolioService.updateUserInformation(portfolioEditedDto);
    }


}
