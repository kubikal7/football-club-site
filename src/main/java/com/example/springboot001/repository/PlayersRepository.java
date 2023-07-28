package com.example.springboot001.repository;

import com.example.springboot001.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayersRepository extends JpaRepository<Player,Long> {
    List<Player> findByPosition(char position);
}
