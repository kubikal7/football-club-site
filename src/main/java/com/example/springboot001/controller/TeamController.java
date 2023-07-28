package com.example.springboot001.controller;

import com.example.springboot001.model.Player;
import com.example.springboot001.repository.PlayersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TeamController {
    private final PlayersRepository playersRepository;

    @GetMapping("/team")
    String team(Model model){
        List<Player> all = playersRepository.findAll();
        List<Player> goalkeepers = all.stream().filter(player->player.getPosition()=='B').toList();
        List<Player> defenders = all.stream().filter(player->player.getPosition()=='O').toList();
        List<Player> midfielders = all.stream().filter(player->player.getPosition()=='P').toList();
        List<Player> attackers = all.stream().filter(player->player.getPosition()=='N').toList();
        model.addAttribute("goalkeepers",goalkeepers);
        model.addAttribute("defenders",defenders);
        model.addAttribute("midfielders",midfielders);
        model.addAttribute("attackers",attackers);
        return "team";
    }
}
