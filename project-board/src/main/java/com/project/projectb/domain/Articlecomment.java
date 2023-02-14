package com.project.projectb.domain;

import java.time.LocalDateTime;

public class Articlecomment {
    private Long id;
    private Article article; // 게시글 id - bigint
    private String content; // 본문 - varchar(2000)

    private LocalDateTime createdAt; // - 생성일시
    private String createdBy; // - 생성자 varchar(100)
    private LocalDateTime modifiedAt; // 수정일시 - datetime
    private String modifiedBY; // 수정자 - varchar(100)
}
