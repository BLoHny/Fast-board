package com.project.projectb.domain;

import java.time.LocalDateTime;
public class Article {
    private Long id; // - bigint
    private String title; // - 제목 varchar(255)
    private String content; // - 내용 varchar(65535)
    private String hashtag; // - 해시태그 varchar(255)

    private LocalDateTime createdAt; // - 생성일시
    private String createdBy; // - 생성자 varchar(100)
    private LocalDateTime modifiedAt; // 수정일시 - datetime
    private String modifiedBY; // 수정자 - varchar(100)
}
