package com.example.springboot001.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    private long id;
    @NonNull
    private String title;
    @NonNull
    @Column(length = 2000)
    private String description;
    @NonNull
    private String img;
    @NonNull
    private LocalDateTime date;
}
