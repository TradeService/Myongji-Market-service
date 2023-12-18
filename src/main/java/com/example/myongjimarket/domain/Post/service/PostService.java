package com.example.myongjimarket.domain.Post.service;


import com.example.myongjimarket.domain.Post.Post;
import com.example.myongjimarket.domain.Post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public Post savePostWithImage(Post post, MultipartFile imageFile) throws IOException {
        if (!imageFile.isEmpty()) {
            post.setImage(imageFile.getBytes());
        }
        return postRepository.save(post);
    }
}

