package com.example.myongjimarket.domain.GroupTransaction.Post.Entity;

import com.example.myongjimarket.domain.GroupTransaction.Post.Dto.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class GroupTransactionPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PostID;

    @Column(nullable = false)
    private String Title;

    @Column(nullable = false)
    private String ProductName;

    @Column(nullable = false)
    private String Place;

    @Column()
    private String price;

    @Column()
    private byte[] Picture;

    @Column()
    private String Content;

    @Column(nullable = false)
    private String PhoneNum;

    @Column(nullable = false)
    private int maximumPerson;

    @Column(nullable = false)
    private int nowPerson;

    @Column(nullable=false)
    private Timestamp publishedDate;

    @Column(nullable=false)
    private Timestamp editedDate;

    @PrePersist
    protected void onCreate() {
        publishedDate = Timestamp.from(Instant.now());
    }
    @PreUpdate
    protected void onUpdate() {
        editedDate = Timestamp.from(Instant.now());
    }

    public GroupTransactionPost(Post post) {
        super();
        this.PostID = post.getPostId();
        this.Title = post.getTitle();
        this.ProductName = post.getProductName();
        this.Place = post.getPlace();
        this.Picture = post.getPicture();
        this.Content = post.getContent();
        this.PhoneNum = post.getPhoneNum();
        this.maximumPerson = post.getMaxPerson();
        this.nowPerson = post.getNowPerson();
    }

    public GroupTransactionPost() {

    }
}
