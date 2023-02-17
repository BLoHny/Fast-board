package com.project.projectb.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Table(indexes = {
        // -> 검색 Index 설정
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@EntityListeners(AuditingEntityListener.class) // -> 꼭 너넣아함
@Entity // -> JPA Entity를 사용할때 hibernate를 기준으로 기본생성자를 갖춰야함
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // -> 자동으로 Autoincrement 생성
    private Long id; // - bigint

    @Setter @Column(nullable = false) private String title; // - 제목 varchar(255) 수정가능 -> Setter 클래스에는 ID 같은것이 수정될수없도록 제약 걸기
    @Setter @Column(nullable = false, length = 10000) private String content; // - 본문 varchar(65535)

    @Setter private String hashtag; // - 해시태그 varchar(255)-> NULL 가능

    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)// -> articleTable로 오는것 cascade{경우}
    private final Set<Articlecomment> articlecomments = new LinkedHashSet<>(); // -> 이아티클에 연동덴 comment는 collection으로 모아서본다

    @CreatedDate @Column(nullable = false) private LocalDateTime createdAt; // - 생성일시
    @CreatedBy @Column(nullable = false, length = 100) private String createdBy; // - 생성자 varchar(100)
    @LastModifiedDate @Column(nullable = false) private LocalDateTime modifiedAt; // 수정일시 - datetime
    @LastModifiedBy @Column(nullable = false, length = 100) private String modifiedBY; // 수정자 - varchar(100)

    protected Article() {}

    private Article(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }
    public static Article of(String title, String content, String hashtag) { // -> 필수값
        return new Article(title, content, hashtag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return id != null && id.equals(article.id); // -> 아직 영속화 되지 않은 Id는 탈락
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
