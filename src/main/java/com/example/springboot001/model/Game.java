package com.example.springboot001.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "games")
@ToString
public class Game {
    @Id
    @GeneratedValue
    private long id;
    private String opponent;
    private char location;
    private LocalDateTime date;
    private boolean finished;
    private String result;

    public Game(String opponent, char location, LocalDateTime date, boolean finished, String result) {
        this.opponent = opponent;
        this.location = location;
        this.date = date;
        this.finished = finished;
        this.result = result;
    }
}
