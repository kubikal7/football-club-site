package com.example.springboot001.service;

import com.example.springboot001.model.Game;
import com.example.springboot001.model.Player;
import com.example.springboot001.model.Post;
import com.example.springboot001.repository.GamesRepository;
import com.example.springboot001.repository.PlayersRepository;
import com.example.springboot001.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AdminService {

    private final PlayersRepository playersRepository;
    private final PostsRepository postsRepository;
    private final GamesRepository gamesRepository;

    public Player addPlayer(Player player){
        return playersRepository.save(player);
    }
    public List<Player> findAllPlayers(){
        return playersRepository.findAll();
    }

    @Transactional
    public Player editPlayer(Player player)  {
        System.out.println(player.getId());
        Player editedPlayer = playersRepository.findById(player.getId()).orElseThrow();
        //if(editedPlayer==null) throw new PlayerNotFoundException("id: "+player.getId());
        //Player editedPlayer = editedPlayerOpt.get();
        editedPlayer.setName(player.getName());
        editedPlayer.setSurname(player.getSurname());
        editedPlayer.setFoot(player.getFoot());
        editedPlayer.setHeight(player.getHeight());
        editedPlayer.setImg(player.getImg());
        editedPlayer.setCountry(player.getCountry());
        editedPlayer.setNumber(player.getNumber());
        editedPlayer.setWeight(player.getWeight());
        editedPlayer.setPosition(player.getPosition());
        return editedPlayer;
    }

    public void deletePlayer(long id) {
        playersRepository.deleteById(id);
    }

    public List<Post> findAllPostsSorted(Sort sort) {
        return postsRepository.findAll(sort);
    }

    public Post addPost(Post post){
        post.setDate(LocalDateTime.now());
        return postsRepository.save(post);
    }

    @Transactional
    public void editPost(Post post,String fullDate, String fullHour) {
        Post EditedPost=postsRepository.findById(post.getId()).orElseThrow();
        EditedPost.setTitle(post.getTitle());
        EditedPost.setDescription(post.getDescription());
        EditedPost.setImg(post.getImg());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String HourWithMinutes = String.join(" ",fullDate,fullHour);
        EditedPost.setDate(LocalDateTime.parse(HourWithMinutes,formatter));
    }

    public void deletePost(long id) {
        postsRepository.deleteById(id);
    }

    public List<Game> findAllGamesSorted(Sort sort) {
        return gamesRepository.findAll(sort);
    }

    public Game addGame(Game game, String fullDate, String fullHour) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String HourWithMinutes = String.join(" ",fullDate,fullHour);
        game.setDate(LocalDateTime.parse(HourWithMinutes,formatter));
        game.setResult(game.getResult()=="" ? null : game.getResult());
        return gamesRepository.save(game);
    }

    @Transactional
    public void editGame(Game game, String fullDate, String fullHour) {
        Game editedGame = gamesRepository.findById(game.getId()).orElseThrow();
        editedGame.setOpponent(game.getOpponent());
        editedGame.setLocation(game.getLocation());
        editedGame.setResult(game.getResult()=="" ? null : game.getResult());
        editedGame.setFinished(game.isFinished());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String HourWithMinutes = String.join(" ",fullDate,fullHour);
        editedGame.setDate(LocalDateTime.parse(HourWithMinutes,formatter));
    }

    public void deleteGame(long id) {
        gamesRepository.deleteById(id);
    }
}


