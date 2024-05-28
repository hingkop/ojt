package com.datasolution.crawler.service;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class CrawlerService {


    public String crawlData() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sjpde\\biz\\02.tools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        // 웹 페이지 로드를 위한 대기 시간 설정
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String url = "https://n.news.naver.com/mnews/article/629/0000291184";
        driver.get(url);

        // 데이터 수집
        String title = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/h2/span")).getText();
        String content = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/article")).getText();
        String author = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/p/span")).getText();
        String date = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/div[1]/div[1]/div[3]/div[1]/div/span")).getText();
        String articleUrl = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/div[1]/div[1]/div[3]/div[1]/a")).getAttribute("href");
        String mediaName = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/div[1]/div[1]/div[1]/a/img[1]")).getAttribute("title");

        driver.quit();

        // 데이터를 문자열로 반환
        return "제목: " + title + "\n" +
                "내용: " + content + "\n" +
                "작성자: " + author + "\n" +
                "날짜: " + date + "\n" +
                "URL: " + articleUrl + "\n" +
                "언론사: " + mediaName;
    }
}

