package com.hkarabakla.article.webflux.controller;

import com.hkarabakla.article.webflux.domain.NewsEvent;
import com.hkarabakla.article.webflux.service.NewsEventPublisher;
import com.hkarabakla.article.webflux.service.NewsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/news")
public class NewsController {

    @GetMapping(path = "/stream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<NewsEvent> getNewsStream() {

        Flux<NewsEvent> dynamicFlux = Flux.create(sink -> {
            NewsEventPublisher.publish(sink, NewsService.getEvents());
        });
        return dynamicFlux;
    }
}
