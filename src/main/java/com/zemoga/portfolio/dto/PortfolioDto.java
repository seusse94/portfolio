package com.zemoga.portfolio.dto;

public class PortfolioDto {

    private long idportfolio;
    private String description;
    private String twitterUserName;
    private String title;
    private String imageUrl;

    public long getIdportfolio() {
        return idportfolio;
    }

    public void setIdportfolio(long idportfolio) {
        this.idportfolio = idportfolio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTwitterUserName() {
        return twitterUserName;
    }

    public void setTwitterUserName(String twitterUserName) {
        this.twitterUserName = twitterUserName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

