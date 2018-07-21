package com.hkarabakla.article.webflux.service;

import com.hkarabakla.article.webflux.domain.NewsEvent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NewsService {

    public static List<NewsEvent> getEvents() {

        List<NewsEvent> events = new ArrayList<>();
        events.add(new NewsEvent(1, LocalDate.now(), "News event #1"));
        events.add(new NewsEvent(2, LocalDate.now(), "News event #2"));
        events.add(new NewsEvent(3, LocalDate.now(), "News event #3"));
        events.add(new NewsEvent(4, LocalDate.now(), "News event #4"));
        events.add(new NewsEvent(5, LocalDate.now(), "News event #5"));
        events.add(new NewsEvent(6, LocalDate.now(), "News event #6"));
        events.add(new NewsEvent(7, LocalDate.now(), "News event #7"));
        events.add(new NewsEvent(8, LocalDate.now(), "News event #8"));
        events.add(new NewsEvent(9, LocalDate.now(), "News event #9"));
        events.add(new NewsEvent(10, LocalDate.now(), "News event #10"));
        return events;
    }
}
