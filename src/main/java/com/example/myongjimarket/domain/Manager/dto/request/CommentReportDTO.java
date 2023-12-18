package com.example.myongjimarket.domain.Manager.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CommentReportDTO {
    private Long commentId;
    private String content;
    private LocalDateTime createdAt;
    private Integer reportCount;

}
