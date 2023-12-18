package com.example.myongjimarket.domain.UTPComment;
import com.example.myongjimarket.domain.Report.ReportComment;
import com.example.myongjimarket.domain.UsedTransactionPost.UsedTransactionPost;
import com.example.myongjimarket.domain.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UTPComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentid")
    private Long commentID;

    @ManyToOne
    @JoinColumn(name = "postid", nullable = false)
    private UsedTransactionPost post;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name ="writed_date", nullable = true)
    private LocalDateTime writedDate;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user; // 사용자 엔터티 참조 추가

    @OneToMany(mappedBy = "reportedComment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ReportComment> reportComments;
}