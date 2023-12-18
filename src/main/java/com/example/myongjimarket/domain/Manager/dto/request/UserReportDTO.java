package com.example.myongjimarket.domain.Manager.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserReportDTO {
    private Long userId;
    private String nickname;
    private Long reportCount;
    // Getter and Setter methods
}
