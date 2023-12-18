package com.example.myongjimarket.domain.UsedTransactionPost.repository;

import com.example.myongjimarket.domain.UsedTransactionPost.UsedTransactionPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UTPRepository extends JpaRepository<UsedTransactionPost, Long> {
    List<UsedTransactionPost> findByTopic(String topic);
}
