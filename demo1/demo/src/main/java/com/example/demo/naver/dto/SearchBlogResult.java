package com.example.demo.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SearchBlogResult {
    private String lastBuildDate;//검색결과를 생성한 시간
    private int total;//검색결과문서의 총개수
    private int start;//검색결과 문서중 문서의 시작점
    private int display;//검색결과의개수
    private List<SearchImageItem> items;//JSON 포멧으로 items 속성으로 표현. 개별 검색결과

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class SearchImageItem{
        private String title;
        private String link;
        private String description;
        private String bloggername;
        private String bloggerlink;

    }
}
