package com.example.myongjimarket.domain.Report;
import com.example.myongjimarket.domain.UTPComment.UTPComment;
import com.example.myongjimarket.domain.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Setter
@Getter
@Entity
public class ReportComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportID;

    @ManyToOne
    @JoinColumn(name = "ReportedCommentID", nullable = false)
    private UTPComment reportedComment;

    @Column(nullable = false, length = 1)
    private String type;

    @Column(nullable = false)
    private Integer reportCount;

    public ReportComment() {
    }

}

