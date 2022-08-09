package com.example.demo.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SearchBlogRep {
    Random random=new Random();
    private String query="";
    private int display=5;
    private int start=random.nextInt(500);
    private String sort="sim";

    public MultiValueMap<String,String> toMultiValueMap(){
        var map=new LinkedMultiValueMap<String,String>();
        map.add("query",query);
        map.add("display",String.valueOf(display));
        map.add("start",String.valueOf(start));
        map.add("sort",sort);

        return map;
    }

}
