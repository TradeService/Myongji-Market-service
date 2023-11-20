package com.example.thingimarket.service.transaction;

import com.example.thingimarket.dto.transaction.TransactionPostDTO;
import com.example.thingimarket.repository.transaction.TransactionPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionPostService {
    private final TransactionPostRepository repository;
    @Autowired
    public TransactionPostService(TransactionPostRepository repository) {
        this.repository = repository;
    }
    public TransactionPostDTO createPost(TransactionPostDTO postDTO) {
        return null;
    }
}