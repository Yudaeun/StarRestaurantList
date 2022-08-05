package com.example.demo.wishlist.repository.service;

import com.example.demo.wishlist.service.WishListService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListTest {

    @Autowired
    private WishListService wishListService;

    @Test
    public void searchTest(){
        var result=wishListService.search("치킨");
        System.out.println(result);
        Assertions.assertNotNull(result);

    }
}
