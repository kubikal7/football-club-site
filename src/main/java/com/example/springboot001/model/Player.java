package com.example.springboot001.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String surname;
    private String country;
    private char position;
    private float height;
    private float weight;
    private String foot;
    private int number;
    private String img;

    public Player(String name, String surname, String country, char position, float height, float weight, String foot, int number) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.foot = foot;
        this.number = number;
    }
    public Player(String name, String surname, String country, char position, float height, float weight, String foot, int number,String img) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.foot = foot;
        this.number = number;
        this.img=img;
    }
}
