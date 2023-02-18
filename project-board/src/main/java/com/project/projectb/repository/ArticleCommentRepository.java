package com.project.projectb.repository;

import com.project.projectb.domain.Articlecomment;
import com.project.projectb.domain.QArticle;
import com.project.projectb.domain.QArticlecomment;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleCommentRepository extends
        JpaRepository<Articlecomment, Long>,
        QuerydslPredicateExecutor<Articlecomment>,
        QuerydslBinderCustomizer<QArticlecomment> {

    @Override
    default void customize(QuerydslBindings bindings, QArticlecomment root) {
        bindings.excludeUnlistedProperties(true); // 이것을 설정하지않은 필드는 검색 불가
        bindings.including(root.content,root.createdAt, root.createdBy);
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase); //likeIgnoreCase -> %를 일일이 너야함 '${v}'
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
    }
}
