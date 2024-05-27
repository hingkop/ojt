package com.datasolution.crawler.dto.response;

import lombok.Data;

@Data
public class ResNewsDTO {

    private Long id;
    private String title;
    private String content;
    private String date;
    private String author;
    private String url;
    private String company;
}