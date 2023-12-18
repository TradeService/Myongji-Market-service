package com.example.myongjimarket.domain.UsedTransactionPost.dto.request;

import com.example.myongjimarket.domain.UsedTransactionPost.UsedTransactionPost;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class UTPUpdateRequest {
    private Long id;
    private MultipartFile picture;
    private String title;
    private String content;
    private String topic;
    private BigDecimal price;
    private String place;
    private Byte deadline;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer heart;

    public UTPUpdateRequest(UsedTransactionPost post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.topic = post.getTopic();
        this.price = post.getPrice();
        this.place = post.getPlace();
        this.deadline = post.getDeadline();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
        this.heart = post.getHeart();
    }
}
