package com.example.demo.wishlist.service;

import com.example.demo.naver.NaverClient;
import com.example.demo.naver.dto.SearchImageRep;
import com.example.demo.naver.dto.SearchLocalRep;
import com.example.demo.wishlist.dto.WishListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final NaverClient naverClient;

    public WishListDto search(String query){
        //search local
        var searchLocalReq=new SearchLocalRep();
        searchLocalReq.setQuery(query);

        var searchLocalRes=naverClient.localSearch(searchLocalReq);
        if(searchLocalRes.getTotal()>0){
            var item=searchLocalRes.getItems().stream().findFirst().get();
            var imageQuery=item.getTitle().replaceAll("<[^>]*>","");
            var searchImageReq=new SearchImageRep();
            searchImageReq.setQuery(imageQuery);

            var searchImageRes= naverClient.imageSearch(searchImageReq);

            if(searchImageRes.getTotal()>0){
                var imageItem=searchImageRes.getItems().stream().findFirst().get();

                var result=new WishListDto();
                result.setTitle(item.getTitle());
                result.setCategory(item.getCategory());
                result.setAddress(item.getAddress());
                result.setPagelink(item.getLink());
                result.setImagelink(imageItem.getLink());

                return result;
               }

        }
        //search image
        return new WishListDto();
    }

}
