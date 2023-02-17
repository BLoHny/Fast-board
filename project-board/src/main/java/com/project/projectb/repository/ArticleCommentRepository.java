package com.project.projectb.repository;

import com.project.projectb.domain.Articlecomment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<Articlecomment, Long> {
}
