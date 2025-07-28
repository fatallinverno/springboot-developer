package io.springboot.linverno.developer.dto.response;

import io.springboot.linverno.developer.domain.entity.Article;
import lombok.Getter;

@Getter
public class ArticleResponse {

    private final String title;
    private final String content;

    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }

}
