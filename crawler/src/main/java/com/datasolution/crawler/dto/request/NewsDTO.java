package com.datasolution.crawler.dto.request;

import lombok.Data;

@Data
public class NewsDTO {

    private String title;
    private String content;
    private String date;
    private String author;
    private String url;
    private String company;
    private String category1;
    private String category2;
}