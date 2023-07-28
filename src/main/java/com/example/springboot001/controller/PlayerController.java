package com.example.springboot001.controller;

import com.example.springboot001.model.Player;
import com.example.springboot001.repository.PlayersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PlayerController {

    private final PlayersRepository playersRepository;

    @GetMapping("/player/{id}")
    public String player(@PathVariable("id") long id, Model model){
        Optional<Player> players = playersRepository.findById(id);
        Player player = players.get();
        model.addAttribute("player",player);
        return "player";
    }
}
