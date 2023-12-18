package com.example.myongjimarket.domain.UTPComment.dto.request;

import com.example.myongjimarket.domain.UsedTransactionPost.UsedTransactionPost;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class CommentCreateRequest {
    private Long commentID;
    private UsedTransactionPost post;
    private String content;
    private LocalDateTime writedDate;

}
