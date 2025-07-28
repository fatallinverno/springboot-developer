package io.springboot.linverno.developer.application.service;

import io.springboot.linverno.developer.domain.entity.Article;
import io.springboot.linverno.developer.dto.articledto.AddArticleRequest;
import io.springboot.linverno.developer.dto.articledto.UpdateArticleRequest;
import io.springboot.linverno.developer.infrastructure.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
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

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {

        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found : " + id));

        article.update(request.getTitle(), request.getContent());

        return article;

    }

}
