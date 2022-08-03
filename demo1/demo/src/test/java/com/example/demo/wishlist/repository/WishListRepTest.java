package com.example.demo.wishlist.repository;

import com.example.demo.wishlist.WishListEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListRepTest {
    @Autowired
    private WishRep wishRep;

    private WishListEntity create(){
        var wishList=new WishListEntity();
        wishList.setTitle("title");
        wishList.setCategory("category");
        wishList.setAddress("Address");
        wishList.setReadAddress("readAddress");
        wishList.setPagelink("");
        wishList.setLastVisitDate(null);
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        return wishList;
    }
    @Test
    public void saveTest(){
        var wishListEntity=create();
        var expected =wishRep.save(wishListEntity);


        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1,expected.getIndex());
    }
    @Test
    public void savenullTest(){
        var wishListEntity=create();
        var expected=wishRep.save(wishListEntity);

        expected.setTitle("test");
        var saveEntity=wishRep.save(expected);

        Assertions.assertEquals("test",saveEntity.getTitle());
        Assertions.assertEquals(1, wishRep.listAll().size());


    }
    @Test
    public void findByIdTest(){

        var wishListEntity=create();
        wishRep.save(wishListEntity);
        var expected=wishRep.findById(1);
        Assertions.assertEquals(true,expected.isPresent());
        Assertions.assertEquals(1,expected.get().getIndex());
    }
    @Test
    public void deleteTest(){
        var wishListEntity=create();
        wishRep.save(wishListEntity);

        wishRep.deleteById(1);
        int count=wishRep.listAll().size();

        Assertions.assertEquals(0,count);


    }
    @Test
    public void listAllTest(){

        var wishListEntity1=create();
        wishRep.save(wishListEntity1);
        var wishListEntity2=create();
        wishRep.save(wishListEntity2);

        int count=wishRep.listAll().size();
        Assertions.assertEquals(2,count);
    }
}
