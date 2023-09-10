package com.example.clients;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class PostService {

    private final RestClient restClient;

    public PostService() {
        this.restClient = RestClient.builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .build();
    }
    public Iterable<Posts> getAllPosts() {
        return restClient.get()
            .uri("/posts")
            .retrieve()
            .body(new ParameterizedTypeReference<>() {
            });

    }

    public Posts getPostById(int id) {
        return restClient.get()
            .uri("/posts/{id}", id)
            .retrieve()
            .body(Posts.class);
    }
}
