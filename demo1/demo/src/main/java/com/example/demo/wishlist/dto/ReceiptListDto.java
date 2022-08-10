package com.example.demo.wishlist.dto;

import com.example.demo.db.DbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReceiptListDto extends DbEntity {
    private String title; //음식명
    private String link;
    private String description;
    private String bloggername;
    private String bloggerlink;
    private String imagelink;//이미지주소

}
