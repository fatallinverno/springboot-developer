package io.springboot.linverno.developer.presentation.controller;

import io.springboot.linverno.developer.application.service.BlogService;
import io.springboot.linverno.developer.domain.entity.Article;
import io.springboot.linverno.developer.dto.response.ArticleListViewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model) {

        List<ArticleListViewResponse> articles = blogService.findAll().stream().map(ArticleListViewResponse::new).toList();

        model.addAttribute("articles", articles);

        return "articleList";

    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleListViewResponse(article));

        return "article";
    }

}
