package com.example.myongjimarket.domain.GroupTransaction.Post.Service;


import com.example.myongjimarket.domain.GroupTransaction.Post.Dto.Post;
import com.example.myongjimarket.domain.GroupTransaction.Post.Entity.GroupTransactionPost;
import com.example.myongjimarket.domain.GroupTransaction.Post.repository.GroupTransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GroupTransactionService {
    private final GroupTransactionRepository groupTransactionRepository;
    @Autowired
    public GroupTransactionService(GroupTransactionRepository groupTransactionRepository) {
        this.groupTransactionRepository = groupTransactionRepository;
    }
    public List<Post> getAllGroupTransaction() {
        return this.groupTransactionRepository.findAll().stream().map(Post::new).toList();
    }
    @Transactional
    public GroupTransactionPost createPostEntity(Post Post){
        GroupTransactionPost groupTransactionPost = new GroupTransactionPost(Post);
        return groupTransactionPost;
    }

    public void savePost(Post post) {
        groupTransactionRepository.save(createPostEntity(post));
    }

    public Post getPostById(Long id) {
        Post post=new Post (groupTransactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 아이디")));
        return post;
    }
    public void updatePost(Post post){
        Optional<GroupTransactionPost> updatePost = groupTransactionRepository.findById(post.getPostId());
        GroupTransactionPost newPost = updatePost.get();
        newPost.setTitle(post.getTitle());
        newPost.setContent(post.getContent());
        newPost.setPlace(post.getPlace());
        newPost.setMaximumPerson(post.getMaxPerson());
        newPost.setNowPerson(post.getNowPerson());
        newPost.setPhoneNum(post.getPhoneNum());
        newPost.setProductName(post.getProductName());
        groupTransactionRepository.save(newPost);
    }
    public void deletePost(Long id) {
        GroupTransactionPost post = groupTransactionRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        groupTransactionRepository.delete(post);
    }
}
