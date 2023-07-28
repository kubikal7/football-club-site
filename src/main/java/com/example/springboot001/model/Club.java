package com.example.springboot001.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Club {
    private String name;
    private int points;
    private int rank;
}
