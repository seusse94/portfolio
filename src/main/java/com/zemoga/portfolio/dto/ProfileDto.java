package com.zemoga.portfolio.dto;

import java.util.List;

public class ProfileDto {

    private PortfolioDto portfolioDto;
    private List<TweetDto> tweets;

    public ProfileDto(PortfolioDto portfolioDto, List<TweetDto> tweets) {
        this.portfolioDto = portfolioDto;
        this.tweets = tweets;
    }

    public PortfolioDto getPortfolioDto() {
        return portfolioDto;
    }

    public List<TweetDto> getTweets() {
        return tweets;
    }
}
