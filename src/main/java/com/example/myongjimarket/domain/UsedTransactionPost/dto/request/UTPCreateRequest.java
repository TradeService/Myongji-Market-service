package com.example.myongjimarket.domain.UsedTransactionPost.dto.request;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.security.Timestamp;
@Setter
@Getter
public class UTPCreateRequest {
    private MultipartFile picture;
    private String title;
    private String content;
    private String topic;
    private BigDecimal price;
    private String place;
    private Byte deadline = 0;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Integer heart = 0;
}