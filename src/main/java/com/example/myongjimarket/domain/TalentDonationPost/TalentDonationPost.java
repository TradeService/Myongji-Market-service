package com.example.myongjimarket.domain.TalentDonationPost;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TalentDonationPost {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String title;
    private String content;
    private String topic;

    @Lob
    private byte[] picture;

    private String place;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String person;
    private String plan;
    private Long UserID;
}
