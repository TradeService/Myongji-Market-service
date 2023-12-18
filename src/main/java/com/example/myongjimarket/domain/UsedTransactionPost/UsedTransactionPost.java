package com.example.myongjimarket.domain.UsedTransactionPost;
import com.example.myongjimarket.domain.Report.ReportPost;
import com.example.myongjimarket.domain.UTPComment.UTPComment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UsedTransactionPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 255)
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    @Column(nullable = false, length = 255)
    private String topic;
    @Lob
    private byte[] picture;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    @Column(nullable = false, length = 255)
    private String place;
    @Column(nullable = false)
    private Byte deadline = 0;
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;

    @Column(nullable = false)
    private Integer heart = 0;
    public UsedTransactionPost(Long postId) {
    }
    @PrePersist
    protected void onCreate() {
        createdAt = Timestamp.from(Instant.now());
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = Timestamp.from(Instant.now());
    }

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UTPComment> comments;

    @OneToMany(mappedBy = "reportedPost", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ReportPost> reportPosts;
}
