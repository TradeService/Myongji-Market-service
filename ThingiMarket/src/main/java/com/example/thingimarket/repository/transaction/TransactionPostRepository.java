package com.example.thingimarket.repository.transaction;

import com.example.thingimarket.domain.transaction.TransactionPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionPostRepository extends JpaRepository<TransactionPost, Long> {
}
