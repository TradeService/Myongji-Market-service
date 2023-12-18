package com.example.myongjimarket.domain.UsedTransactionPost.service;
import com.example.myongjimarket.domain.UTPComment.UTPComment;
import com.example.myongjimarket.domain.UTPComment.repository.CommentRepository;
import com.example.myongjimarket.domain.UsedTransactionPost.UsedTransactionPost;
import com.example.myongjimarket.domain.UsedTransactionPost.dto.request.UTPCreateRequest;
import com.example.myongjimarket.domain.UsedTransactionPost.dto.request.UTPReadAllRequest;
import com.example.myongjimarket.domain.UsedTransactionPost.dto.request.UTPReadByIdRequest;
import com.example.myongjimarket.domain.UsedTransactionPost.dto.request.UTPUpdateRequest;
import com.example.myongjimarket.domain.UsedTransactionPost.repository.UTPRepository;
import com.example.myongjimarket.domain.User.User;
import com.example.myongjimarket.domain.User.repository.UserRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UTPService {
    private final UTPRepository utpRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public UTPService(UTPRepository utpRepository, CommentRepository commentRepository, UserRepository userRepository){
        this.utpRepository = utpRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }
    public void createPost(UTPCreateRequest postDTO) throws IOException {
        UsedTransactionPost post = new UsedTransactionPost();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setTopic(postDTO.getTopic());

        User user = userRepository.findById(2).orElseThrow(() -> new RuntimeException("User not found"));
        post.setUser(user);
        MultipartFile pictureFile = postDTO.getPicture();
        if (pictureFile != null && !pictureFile.isEmpty()) {
            post.setPicture(pictureFile.getBytes());
        }
        post.setPrice(postDTO.getPrice());
        post.setPlace(postDTO.getPlace());
        post.setDeadline(postDTO.getDeadline());
        post.setHeart(postDTO.getHeart());
        this.utpRepository.save(post);
    }
    public List<UTPReadAllRequest> getAllPosts() {
        List<UsedTransactionPost> posts = utpRepository.findAll();
        return posts.stream().map(post -> {
            UTPReadAllRequest dto = new UTPReadAllRequest(post);
            dto.setId(post.getId());
            if (post.getPicture() != null) {
                String base64Encoded = Base64.encodeBase64String(post.getPicture());
                dto.setPictureBase64(base64Encoded);
            }
            return dto;
        }).collect(Collectors.toList());
    }
    public List<UTPReadAllRequest> getPostsByTopic(String topic) {
        List<UsedTransactionPost> posts = utpRepository.findByTopic(topic);
        return posts.stream().map(post -> {
            UTPReadAllRequest dto = new UTPReadAllRequest(post);
            dto.setId(post.getId());
            if (post.getPicture() != null) {
                String base64Encoded = Base64.encodeBase64String(post.getPicture());
                dto.setPictureBase64(base64Encoded);
            }
            return dto;
        }).collect(Collectors.toList());
    }
    public UTPReadByIdRequest getPostById(Long id) {
        Optional<UsedTransactionPost> postOptional = utpRepository.findById(id);
        if (postOptional.isPresent()) {
            UTPReadByIdRequest dto = new UTPReadByIdRequest(postOptional.get());
            dto.setId(postOptional.get().getId());
            if (postOptional.get().getPicture() != null) {
                String base64Encoded = Base64.encodeBase64String(postOptional.get().getPicture());
                dto.setPictureBase64(base64Encoded);
            }
            return dto;
        } else {
            throw new RuntimeException("Post not found with id: " + id);
        }
    }
    public void updatePost(UTPUpdateRequest postDTO) throws IOException {
        Optional<UsedTransactionPost> existingPost = utpRepository.findById(postDTO.getId());
        if (existingPost.isPresent()) {
            UsedTransactionPost post = existingPost.get();
            post.setTitle(postDTO.getTitle());
            post.setContent(postDTO.getContent());
            post.setTopic(postDTO.getTopic());
            post.setPrice(postDTO.getPrice());
            post.setPlace(postDTO.getPlace());
            post.setDeadline(postDTO.getDeadline());
            if (postDTO.getHeart() != null) {
                post.setHeart(postDTO.getHeart());
            }
            MultipartFile pictureFile = postDTO.getPicture();
            if (pictureFile != null && !pictureFile.isEmpty()) {
                post.setPicture(pictureFile.getBytes());
            }
            utpRepository.save(post);
        } else {
            throw new RuntimeException("Post not found with id: " + postDTO.getId());
        }
    }
    public void deletePost(Long id) {
        utpRepository.deleteById(id);
    }
    public UTPReadByIdRequest getPostDetails(Long id) {
        UTPReadByIdRequest postDetails = getPostById(id);
        List<UTPComment> comments = commentRepository.findByPostId(id);
        postDetails.setComments(comments);
        return postDetails;
    }
    public void likePost(Long postId) {
        Optional<UsedTransactionPost> postOptional = utpRepository.findById(postId);
        if (postOptional.isPresent()) {
            UsedTransactionPost post = postOptional.get();
            post.setHeart(post.getHeart() + 1);
            utpRepository.save(post);
        } else {
            throw new RuntimeException("Post not found with id: " + postId);
        }
    }
}