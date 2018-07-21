package com.hkarabakla.article.webflux.domain;

import java.time.LocalDate;

public class NewsEvent {

    private int id;
    private LocalDate timeStamp;
    private String newsText;

    public NewsEvent(int id, LocalDate timeStamp, String newsText) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.newsText = newsText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNewsText() {
        return newsText;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }
}
