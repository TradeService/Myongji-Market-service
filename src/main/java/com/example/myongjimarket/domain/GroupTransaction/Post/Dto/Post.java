package com.example.myongjimarket.domain.GroupTransaction.Post.Dto;


import com.example.myongjimarket.domain.GroupTransaction.Post.Entity.GroupTransactionPost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post{
    public Long postId;
    public String title;
    public String productName;
    public String place;
    public byte[] picture;
    public String price;
    public String content;
    public String phoneNum;
    public int maxPerson;
    public int nowPerson;
    public LocalDateTime publishedDate;
    public LocalDateTime editedDate;
    public void setDate(){
        this.publishedDate = LocalDateTime.now();
        this.editedDate = LocalDateTime.now();
    }
    public Post(GroupTransactionPost groupTransactionPost) {
        this.postId = groupTransactionPost.getPostID();
        this.title = groupTransactionPost.getTitle();
        this.productName = groupTransactionPost.getProductName();
        this.place = groupTransactionPost.getPlace();
        this.picture= groupTransactionPost.getPicture();
        this.price = groupTransactionPost.getPrice();
        this.content = groupTransactionPost.getContent();
        this.phoneNum = groupTransactionPost.getPhoneNum();
        this.maxPerson = groupTransactionPost.getMaximumPerson();
        this.nowPerson = groupTransactionPost.getNowPerson();
    }

    public void setId(Long id) {
        this.postId=id;
    }
}

