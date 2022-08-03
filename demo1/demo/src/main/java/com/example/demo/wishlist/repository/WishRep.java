package com.example.demo.wishlist.repository;

import com.example.demo.db.MemoryDB;
import com.example.demo.db.MemoryDBAbstract;
import com.example.demo.wishlist.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WishRep extends MemoryDBAbstract<WishListEntity> {

}
