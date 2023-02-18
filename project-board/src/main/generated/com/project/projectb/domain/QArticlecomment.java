package com.project.projectb.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArticlecomment is a Querydsl query type for Articlecomment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArticlecomment extends EntityPathBase<Articlecomment> {

    private static final long serialVersionUID = -119183888L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArticlecomment articlecomment = new QArticlecomment("articlecomment");

    public final QAuditingFields _super = new QAuditingFields(this);

    public final QArticle article;

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBY = _super.modifiedBY;

    public QArticlecomment(String variable) {
        this(Articlecomment.class, forVariable(variable), INITS);
    }

    public QArticlecomment(Path<? extends Articlecomment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArticlecomment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArticlecomment(PathMetadata metadata, PathInits inits) {
        this(Articlecomment.class, metadata, inits);
    }

    public QArticlecomment(Class<? extends Articlecomment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.article = inits.isInitialized("article") ? new QArticle(forProperty("article")) : null;
    }

}

