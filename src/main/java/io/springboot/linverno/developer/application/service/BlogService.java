package io.springboot.linverno.developer.application.service;

import io.springboot.linverno.developer.domain.entity.Article;
import io.springboot.linverno.developer.dto.request.AddArticleRequest;
import io.springboot.linverno.developer.dto.request.UpdateArticleRequest;
import io.springboot.linverno.developer.infrastructure.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("아이디를 찾을 수 없습니다." + id));
    }

    public Article save(AddArticleRequest request, String username) {
        return blogRepository.save(request.toEntity(username));
    }

    public void delete(Long id) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Fount : " + id));

        authorizeArticleAuthor(article);
        blogRepository.delete(article);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {

        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found : " + id));

        authorizeArticleAuthor(article);
        article.update(request.getTitle(), request.getContent());

        return article;

    }

    private static void authorizeArticleAuthor(Article article) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        if (!article.getAuthor().equals(userName)) {
            throw new IllegalArgumentException("Not Authorized");
        }
    }

}
