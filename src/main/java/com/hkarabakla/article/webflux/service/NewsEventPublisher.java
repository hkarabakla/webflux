package com.hkarabakla.article.webflux.service;

import com.hkarabakla.article.webflux.domain.NewsEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.FluxSink;

import java.util.List;

public class NewsEventPublisher {

    static Logger logger = LoggerFactory.getLogger(NewsEventPublisher.class);

    private NewsEventPublisher() {
    }

    public static void publish(FluxSink<NewsEvent> sink, List<NewsEvent> newsEvents) {
        MatchEventPublisherRunnable runnable = new MatchEventPublisherRunnable(sink, newsEvents);
        Thread t = new Thread(runnable);
        t.start();
    }

    public static class MatchEventPublisherRunnable implements Runnable {

        FluxSink<NewsEvent> sink;
        List<NewsEvent> newsEvents;

        public MatchEventPublisherRunnable(FluxSink<NewsEvent> sink, List<NewsEvent> newsEvents) {
            this.sink = sink;
            this.newsEvents = newsEvents;
        }

        public void run() {
            for (NewsEvent newsEvent : newsEvents) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    logger.error("Error occurred during thread sleep", e);
                }
                sink.next(newsEvent);
            }

            sink.complete();
        }
    }
}
