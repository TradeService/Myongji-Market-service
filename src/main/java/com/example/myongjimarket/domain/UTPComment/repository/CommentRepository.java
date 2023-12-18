package com.example.myongjimarket.domain.UTPComment.repository;

import com.example.myongjimarket.domain.UTPComment.UTPComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<UTPComment, Long> {
    List<UTPComment> findByPostId(Long postId);
}
