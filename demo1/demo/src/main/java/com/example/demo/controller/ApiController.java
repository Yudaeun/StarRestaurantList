package com.example.demo.controller;

import com.example.demo.wishlist.dto.WishListDto;
import com.example.demo.wishlist.service.WishListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class ApiController {
    private final WishListService wishListService;


    @GetMapping("/search")
    public WishListDto search(@RequestParam String query){

        return wishListService.search(query);
    }

    @PostMapping("")
    public WishListDto add(@RequestBody WishListDto wishListDto) {
        log.info("{}", wishListDto);
        return wishListService.add(wishListDto);
    }

    @GetMapping("/all")
    public List<WishListDto> findAll(){
        return wishListService.findAll();
    }

    @DeleteMapping("/{index}")
    public void delete(@PathVariable int index){

        //System.out.println(wishListService.findone(index));
        wishListService.delete(index);
        //System.out.println(index);


    }

    @PostMapping("/{index}")
    public void addVisit(@PathVariable int index){
         wishListService.addVisit(index);

    }

    @GetMapping("/recommend")
    public WishListDto receipt(){
        return wishListService.searchReceipt();
    }
}


