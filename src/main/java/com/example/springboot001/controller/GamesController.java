package com.example.springboot001.controller;

import com.example.springboot001.model.Game;
import com.example.springboot001.repository.GamesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class GamesController {
    private final GamesRepository gamesRepository;

    @GetMapping("/games")
    String home(Model model){
        List<Game> all = gamesRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
        List<Game> finished = all.stream().filter(Game::isFinished).toList();
        List<Game> futured = all.stream().filter(game -> !game.isFinished()).toList();
        model.addAttribute("finishedGames",finished);
        model.addAttribute("futuredGames",futured);
        return "games";
    }
}
