package com.hkarabakla.article.webflux;

import com.hkarabakla.article.webflux.controller.NewsController;
import com.hkarabakla.article.webflux.domain.NewsEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@RunWith(SpringRunner.class)
@WebFluxTest(NewsController.class)
public class WebfluxApplicationTests {

    @Test
    public void contextLoads() {

        WebClient client = WebClient.builder().baseUrl("http://localhost:8080").build();

        client.get()
                .uri("/news/stream")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .exchange()
                .publishOn(Schedulers.single())
                .flatMapMany(response -> response.bodyToFlux(NewsEvent.class))
                .delayElements(Duration.ofMillis(3000))
                .subscribe(System.out::println);
    }

}
