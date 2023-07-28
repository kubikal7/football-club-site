package com.example.springboot001.controller;

import com.example.springboot001.model.Game;
import com.example.springboot001.model.Player;
import com.example.springboot001.model.Post;
import com.example.springboot001.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("")
    String admin(){
        return "redirect:/admin/players";
    }

    @GetMapping("/players")
    String adminPlayers(Model model){
        model.addAttribute("players",adminService.findAllPlayers());
        return "admin-players";
    }

    @PostMapping("/players")
    String adminAddPlayer(Player player){
        adminService.addPlayer(player);
        return "redirect:/admin/players";
    }

    @PutMapping("/players")
    String adminEditPlayer(Player player){
        adminService.editPlayer(player);
        return "redirect:/admin/players";
    }

    @DeleteMapping("/players/{id}")
    String adminDeletePlayer(@PathVariable long id){
        adminService.deletePlayer(id);
        return "redirect:/admin/players";
    }


    @GetMapping("/posts")
    String adminPosts(Model model){
        model.addAttribute("posts",adminService.findAllPostsSorted(Sort.by(Sort.Direction.DESC, "date")));
        return "admin-posts";
    }

    @PostMapping("/posts")
    String adminAddPost(Post post){
        adminService.addPost(post);
        return "redirect:/admin/posts";
    }

    @PutMapping("/posts")
    String adminEditPosts(Post post, String fullDate, String fullHour){
        adminService.editPost(post,fullDate,fullHour);
        return "redirect:/admin/posts";
    }

    @DeleteMapping("/posts/{id}")
    String adminDeletePost(@PathVariable long id){
        adminService.deletePost(id);
        return "redirect:/admin/posts";
    }

    @GetMapping("/games")
    String adminGames(Model model){
        model.addAttribute("games",adminService.findAllGamesSorted(Sort.by(Sort.Direction.DESC, "date")));
        return "admin-games";
    }

    @PostMapping("/games")
    String adminAddGame(Game game, String fullDate, String fullHour){
        adminService.addGame(game, fullDate, fullHour);
        return "redirect:/admin/games";
    }

    @PutMapping("/games")
    String adminEditGame(Game game, String fullDate, String fullHour){
        adminService.editGame(game, fullDate, fullHour);
        return "redirect:/admin/games";
    }

    @DeleteMapping("/games/{id}")
    String adminDeleteGame(@PathVariable long id){
        adminService.deleteGame(id);
        return "redirect:/admin/games";
    }
}
