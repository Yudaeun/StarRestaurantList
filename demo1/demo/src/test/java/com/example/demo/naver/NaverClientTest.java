package com.example.demo.naver;

import com.example.demo.naver.dto.SearchBlogRep;
import com.example.demo.naver.dto.SearchBlogResult;
import com.example.demo.naver.dto.SearchImageRep;
import com.example.demo.naver.dto.SearchLocalRep;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NaverClientTest {
    @Autowired
    private NaverClient naverClient;

    @Test
    public void searchLocalTest(){
        var search=new SearchLocalRep();
        search.setQuery("치킨");

        var result=naverClient.localSearch(search);
        System.out.println(result);
    }

    @Test
    public void searchImageTest(){
        var search=new SearchImageRep();
        search.setQuery("치킨");

        var result=naverClient.imageSearch(search);
        System.out.println(result);
    }

    @Test
    public void searchBlogTest(){
        var search=new SearchBlogRep();
        search.setQuery("라자냐");

        var result=naverClient.blogSearch(search);
        System.out.println(result);
    }
}
