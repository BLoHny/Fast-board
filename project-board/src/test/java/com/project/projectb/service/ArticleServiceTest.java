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
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService sut;

    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글 검색 -> 리스트 반환")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenArticleList() {
        //given

        //when
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword"); // 제목, 본문, id, 닉네임, 해시태그

        //then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 조회, 게시글 반환")
    @Test
    void givenArticleId_whenSearchingArticle_thenreturnArticle() {
        //given

        //when
        ArticleDto articles = sut.searchArticle(1L);

        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글 정보 입력, 게시글 생성")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSavesArticle() {
        //Given
        given(articleRepository.save(any(Article.class))).willReturn(null); //save() 는 willDoNothing()과 쓸 수 없음
        //when
        sut.saveArticle(ArticleDto.of(LocalDateTime.now(), "For", "title", "content", "#java"));
        //then
        then(articleRepository).should().save(any(Article.class)); //save가 호출됬었나
    }

    @DisplayName("게시글 ID와 수정정보 입력, 게시글 수정")
    @Test
    void givenArticleIdAndModifiedInfo_whenUpdatingArticle_thenUpdatesArticle() {
        //Given
        given(articleRepository.save(any(Article.class))).willReturn(null); //save() 는 willDoNothing()과 쓸 수 없음
        //when
        sut.updateArticle(1L, ArticleUpdateDto.of("title", "content", "#java"));
        //then
        then(articleRepository).should().save(any(Article.class)); //save가 호출됬었나
    }
    @DisplayName("게시글 ID를 입력하면, 게시글을 삭제한다.")
    @Test
    void givenArticleId_whenDeletingArticle_thenDeletesArticle() {
        //Given
        willDoNothing().given(articleRepository).delete(any(Article.class));
        //when
        sut.deleteArticle(1L);
        //then
        then(articleRepository).should().delete(any(Article.class)); //delete가 호출됬었나
    }
}