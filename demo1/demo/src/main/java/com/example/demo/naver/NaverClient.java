package com.example.demo.naver;

import com.example.demo.naver.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NaverClient {
    @Value("${naver.client.id}")
    private String naverClientId;
    @Value("${naver.client.secret}")
    private String naversecret;
    @Value("${naver.url.search.local}")
    private String naverlocalSearchUrl;
    @Value("${naver.url.search.image}")
    private String naverimage;
    @Value("${naver.url.search.blog}")
    private String naverblog;

    public SearchLocalResult localSearch(SearchLocalRep searchLocalRep){
        var uri= UriComponentsBuilder.fromUriString(naverlocalSearchUrl)
                .queryParams(searchLocalRep.toMultiValueMap())
                .build()
                .encode()
                .toUri();
        var headers=new HttpHeaders();
        headers.set("X-Naver-Client-Id",naverClientId);
        headers.set("X-Naver-Client-Secret",naversecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity=new HttpEntity<>(headers);
        var responseType=new ParameterizedTypeReference<SearchLocalResult>(){};

        var responseEntity=new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );
        return responseEntity.getBody();


    }
    public SearchImageResult imageSearch(SearchImageRep searchImageRep){
        var uri= UriComponentsBuilder.fromUriString(naverimage)
                .queryParams(searchImageRep.toMultiValueMap())
                .build()
                .encode()
                .toUri();
        var headers=new HttpHeaders();
        headers.set("X-Naver-Client-Id",naverClientId);
        headers.set("X-Naver-Client-Secret",naversecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity=new HttpEntity<>(headers);
        var responseType=new ParameterizedTypeReference<SearchImageResult>(){};

        var responseEntity=new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );
        return responseEntity.getBody();
    }
    public SearchBlogResult blogSearch(SearchBlogRep searchBlogRep){
        var uri= UriComponentsBuilder.fromUriString(naverblog)
                .queryParams(searchBlogRep.toMultiValueMap())
                .build()
                .encode()
                .toUri();
        var headers=new HttpHeaders();
        headers.set("X-Naver-Client-Id",naverClientId);
        headers.set("X-Naver-Client-Secret",naversecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity=new HttpEntity<>(headers);
        var responseType=new ParameterizedTypeReference<SearchBlogResult>(){};

        var responseEntity=new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );
        return responseEntity.getBody();
    }
}
