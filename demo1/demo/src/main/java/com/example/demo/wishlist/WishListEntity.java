package com.example.demo.wishlist;

import com.example.demo.db.DbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WishListEntity extends DbEntity {
    private String title; //음식명
    private String category;//카테고리
    private String address;//주소
    private String readAddress;//도로명
    private String pagelink;//홈페이지주소
    private String imagelink;//이미지주소
    private boolean isVisit;//방문여부
    private int visitCount;//방문카운트
    private LocalDateTime lastVisitDate;//마지막 방문일자
}
