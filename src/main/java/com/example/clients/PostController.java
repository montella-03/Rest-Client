package com.example.clients;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/all")
    public Iterable<Posts> getAllPosts() {
        return postService.getAllPosts();
    }
    @GetMapping("/{id}")
    public Posts getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }
}
