package com.project.projectb.service;

import com.project.projectb.domain.Article;
import com.project.projectb.domain.type.SearchType;
import com.project.projectb.dto.ArticleDto;
import com.project.projectb.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService sut;

    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글 검색 -> 리스트 반환")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenArticleList() {
        //given

        //when
        List<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword"); // 제목, 본문, id, 닉네임, 해시태그

        //then
        assertThat(articles).isNotNull();
    }
}