package com.example.thingimarket.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionPostDTO {
    private Long id;
    private String title;
    private String content;
    private String topic;
    private byte[] picture;
    private BigDecimal price;
    private String place;
    private Boolean deadline;
}
