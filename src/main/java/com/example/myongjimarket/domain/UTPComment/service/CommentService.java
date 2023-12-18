package com.example.myongjimarket.domain.UTPComment.service;
import com.example.myongjimarket.domain.UTPComment.UTPComment;
import com.example.myongjimarket.domain.UTPComment.repository.CommentRepository;
import com.example.myongjimarket.domain.UsedTransactionPost.UsedTransactionPost;
import com.example.myongjimarket.domain.UsedTransactionPost.repository.UTPRepository;
import com.example.myongjimarket.domain.User.User;
import com.example.myongjimarket.domain.User.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UTPRepository utpRepository;
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, UTPRepository utpRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.utpRepository = utpRepository;
        this.userRepository = userRepository;
    }
    public void addComment(Long postId, String content) {
        UsedTransactionPost post = utpRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));

        User user = userRepository.findById(2).orElseThrow(() -> new RuntimeException("User not found"));

        UTPComment comment = new UTPComment();
        comment.setPost(post);
        comment.setContent(content);
        comment.setWritedDate(LocalDateTime.now());
        comment.setUser(user);
        commentRepository.save(comment);
    }
}