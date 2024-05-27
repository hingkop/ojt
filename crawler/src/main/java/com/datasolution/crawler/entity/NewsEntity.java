package com.datasolution.crawler.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "news")
public class NewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String date;
    private String author;
    private String url;
    private String company;
}
