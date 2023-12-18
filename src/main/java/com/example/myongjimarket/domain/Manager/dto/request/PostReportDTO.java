package com.example.myongjimarket.domain.Manager.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PostReportDTO {
    private Long postId;
    private String title;
    private Instant createdAt;
    private Integer reportCount;

    // Getter and Setter methods
}
