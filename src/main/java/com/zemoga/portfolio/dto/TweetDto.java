package com.zemoga.portfolio.dto;

public class TweetDto {

    private String text;
    private String toUserId;
    private String inReplyToScreenName;
    private TwitterProfileDto user;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setFromUser(String fromUser) {
        this.toUserId = fromUser;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public TwitterProfileDto getUser() {
        return user;
    }

    public void setUser(TwitterProfileDto user) {
        this.user = user;
    }

    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public void setInReplyToScreenName(String inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }
}
