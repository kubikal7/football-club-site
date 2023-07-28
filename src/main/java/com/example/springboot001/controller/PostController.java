package com.example.springboot001.controller;

import com.example.springboot001.model.Player;
import com.example.springboot001.model.Post;
import com.example.springboot001.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PostController {
    public final PostsRepository postsRepository;

    @GetMapping("/post/{id}")
    public String post(@PathVariable("id") long id, Model model){
        Optional<Post> posts = postsRepository.findById(id);
        Post post = posts.get();
        model.addAttribute("post",post);
        return "post";
    }
}
