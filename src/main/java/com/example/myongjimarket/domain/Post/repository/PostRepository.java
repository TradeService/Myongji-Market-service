package com.example.myongjimarket.domain.Post.repository;

import com.example.myongjimarket.domain.Post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
