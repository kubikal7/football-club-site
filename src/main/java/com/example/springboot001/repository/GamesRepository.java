package com.example.springboot001.repository;

import com.example.springboot001.model.Game;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GamesRepository extends JpaRepository<Game,Long> {

    @Query("Select g From Game g")
    List<Game> findPage(Pageable page);

    @Query("Select g From Game g WHERE g.finished=TRUE")
    List<Game> findPageFinished(Pageable page);

    @Query("Select g From Game g WHERE g.finished=FALSE")
    List<Game> findPageFutured(Pageable page);

    List<Game> findByFinished(boolean finished);
}
