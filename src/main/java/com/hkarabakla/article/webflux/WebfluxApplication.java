package com.hkarabakla.article.webflux;

import com.hkarabakla.article.webflux.domain.NewsEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;

@SpringBootApplication
public class WebfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxApplication.class, args);

        WebClient client = WebClient.create("http://localhost:8080");

        Flux<NewsEvent> newsEventFlux = client.get().uri("/news/stream").accept(APPLICATION_STREAM_JSON).retrieve().bodyToFlux(NewsEvent.class);

        newsEventFlux.subscribe(System.out::println);
    }

}
