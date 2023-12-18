package com.example.myongjimarket.domain.Report;

import com.example.myongjimarket.domain.UsedTransactionPost.UsedTransactionPost;
import com.example.myongjimarket.domain.User.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ReportPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportID;

    @ManyToOne
    @JoinColumn(name = "ReportedPostID", nullable = false)
    private UsedTransactionPost reportedPost;

    @Column(nullable = false, length = 1)
    private String type;

    @Column(nullable = false)
    private Integer reportCount;
}
