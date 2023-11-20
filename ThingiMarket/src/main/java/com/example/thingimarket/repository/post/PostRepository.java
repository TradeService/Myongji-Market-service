package com.example.thingimarket.repository.post;

import com.example.thingimarket.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
