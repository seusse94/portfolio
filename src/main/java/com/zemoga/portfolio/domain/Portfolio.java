package com.zemoga.portfolio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    private long idportfolio;
    @Column
    private String description;
    @Column
    private String imageUrl;
    @Column
    private String twitterUserName;
    @Column
    private String title;

    public Portfolio() {

    }

    public Portfolio(long idportfolio, String description, String imageUrl, String twitterUserName, String title) {
        this.idportfolio = idportfolio;
        this.description = description;
        this.imageUrl = imageUrl;
        this.twitterUserName = twitterUserName;
        this.title = title;
    }

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


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

}
