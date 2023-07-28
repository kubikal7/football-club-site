package com.example.springboot001.repository;

import com.example.springboot001.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Post,Long> {
    @Query("Select p From Post p")
    List<Post> findPage(Pageable page);

}
