package com.project.projectb.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class Articlecomment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // -> 자동으로 Autoincrement 생성
    private Long id;

    @Setter @ManyToOne(optional = false) private Article article; // 게시글 id - bigint #Article을 바라보기위해 @ManyToOne 사용
    @Setter @Column(nullable = false, length = 2000) private String content; // 본문 - varchar(2000)

    @CreatedDate @Column(nullable = false) private LocalDateTime createdAt; // - 생성일시
    @CreatedBy @Column(nullable = false, length = 100) private String createdBy; // - 생성자 varchar(100)
    @LastModifiedDate @Column(nullable = false) private LocalDateTime modifiedAt; // 수정일시 - datetime
    @LastModifiedBy @Column(nullable = false, length = 100) private String modifiedBY; // 수정자 - varchar(100)

    protected Articlecomment() {}

    private Articlecomment(Article article, String content) {
        this.article = article;
        this.content = content;
    }

    public static Articlecomment of(Article article, String content) {
        return new Articlecomment(article, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Articlecomment that)) return false;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
