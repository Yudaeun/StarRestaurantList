package com.example.demo.wishlist.service;

import com.example.demo.naver.NaverClient;
import com.example.demo.naver.dto.SearchBlogRep;
import com.example.demo.naver.dto.SearchImageRep;
import com.example.demo.naver.dto.SearchLocalRep;
import com.example.demo.wishlist.WishListEntity;
import com.example.demo.wishlist.dto.WishListDto;
import com.example.demo.wishlist.repository.WishRep;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final NaverClient naverClient;
    private final WishRep wishListRepository;

    public WishListDto searchReceipt() {
        var searchBlogReq=new SearchBlogRep();
        searchBlogReq.setQuery("레시피");

        var searchBlogRes=naverClient.blogSearch(searchBlogReq);
        if(searchBlogRes.getTotal()>0){
            var item=searchBlogRes.getItems().stream().findAny().get();
            System.out.println(item);
            var imageQuery=item.getTitle().replaceAll("<[^>]*>","");
            System.out.println(imageQuery);
            var searchImageReq=new SearchImageRep();
            searchImageReq.setQuery(imageQuery);

            var searchImageRes= naverClient.imageSearch(searchImageReq);

            if(searchImageRes.getTotal()>0){
                var imageItem=searchImageRes.
                        getItems().

                        stream().
                        findAny().
                        get();

                var result=new WishListDto();
                result.setTitle(item.getTitle());
                result.setPagelink(item.getLink());
                result.setImagelink(imageItem.getLink());


                System.out.println(result);
                return result;
            }

        }
        //search image
        return new WishListDto();
    }

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

    public WishListDto add(WishListDto wishListDto) {

        var entity=dtoToEntity(wishListDto);
        var saveEntity=wishListRepository.save(entity);
        return entityToDto(saveEntity);
    }
    private WishListEntity dtoToEntity(WishListDto wishListDto){
        var entity=new WishListEntity();
        entity.setTitle(wishListDto.getTitle());
        entity.setIndex(wishListDto.getIndex());
        entity.setCategory(wishListDto.getCategory());
        entity.setAddress(wishListDto.getAddress());
        entity.setPagelink(wishListDto.getPagelink());
        entity.setImagelink(wishListDto.getImagelink());
        entity.setLastVisitDate(wishListDto.getLastVisitDate());
        entity.setVisit(wishListDto.isVisit());
        entity.setVisitCount(wishListDto.getVisitCount());
        return entity;
    }
    private WishListDto entityToDto(WishListEntity wishListEntity){
        var dto=new WishListDto();
        dto.setTitle(wishListEntity.getTitle());
        dto.setIndex(wishListEntity.getIndex());
        dto.setCategory(wishListEntity.getCategory());
        dto.setAddress(wishListEntity.getAddress());
        dto.setPagelink(wishListEntity.getPagelink());
        dto.setImagelink(wishListEntity.getImagelink());
        dto.setLastVisitDate(wishListEntity.getLastVisitDate());
        dto.setVisit(wishListEntity.isVisit());
        dto.setVisitCount(wishListEntity.getVisitCount());
        return dto;
    }

    public List<WishListDto> findAll(){
        return wishListRepository.listAll()
                .stream()
                .map(it->entityToDto(it))
                .collect(Collectors.toList());
    }
    public List<WishListDto> findone(int index){
        return wishListRepository.findById(index)
                .stream()
                .map(it->entityToDto(it))
                .collect(Collectors.toList());
    }
    public void delete(int index) {
        wishListRepository.deleteById(index);
    }
    public void addVisit(int index){
        var wishItem=wishListRepository.findById(index);
        if(wishItem.isPresent()){
            var item=wishItem.get();
            item.setVisit(true);
            item.setVisitCount(item.getVisitCount()+1);
        }
    }
}
