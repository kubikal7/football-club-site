package com.example.springboot001.controller;

import com.example.springboot001.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/")
    String home(Model model){
        model.addAttribute("posts", homeService.getPosts());
        try {
            model.addAttribute("leagueTable", homeService.getLeagueTable());
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("finishedGames",homeService.getFinishedGames());
        model.addAttribute("futuredGames",homeService.getFuturedGames());
        return "home";
    }

}
