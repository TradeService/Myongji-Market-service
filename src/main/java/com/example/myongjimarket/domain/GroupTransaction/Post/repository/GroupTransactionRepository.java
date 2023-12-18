package com.example.myongjimarket.domain.GroupTransaction.Post.repository;


import com.example.myongjimarket.domain.GroupTransaction.Post.Entity.GroupTransactionPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupTransactionRepository extends JpaRepository<GroupTransactionPost, Long> {
    Optional<GroupTransactionPost> findById(long PostID);
}
