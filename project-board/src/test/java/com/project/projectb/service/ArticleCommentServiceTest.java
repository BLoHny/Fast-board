package com.project.projectb.service;

import com.project.projectb.domain.Article;
import com.project.projectb.dto.ArticlecommentDto;
import com.project.projectb.repository.ArticleCommentRepository;
import com.project.projectb.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

@DisplayName("댓글")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {

    @InjectMocks private ArticleCommentService sut;

    @Mock private ArticleCommentRepository articleCommentRepository;
    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글 ID 조회 댓글 리스트 반환")
    @Test
    void givenArticleId_whenSearchingArticleComments_thenReturnsComments() {
        //Given
        Long articleId = 1L;
        BDDMockito.given(articleRepository.findById(articleId)).willReturn(Optional.of(
                Article.of("title", "content", "#java"))
        );
        //when
        List<ArticlecommentDto> articleComments = sut.searchArticleComment(articleId);
        //then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }

    @DisplayName("댓글 정보를 입력하면 댓글을 저장")
    @Test
    void givenCommentsInfo_whenSavingComment_thenSavedComments() {
        //Given
        Long articleId = 1L;
        BDDMockito.given(articleRepository.findById(articleId)).willReturn(Optional.of(
                Article.of("title", "content", "#java"))
        );
        //when
        List<ArticlecommentDto> articleComments = sut.searchArticleComment(articleId);
        //then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }
}