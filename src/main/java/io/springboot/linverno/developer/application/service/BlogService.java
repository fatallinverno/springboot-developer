package io.springboot.linverno.developer.application.service;

import io.springboot.linverno.developer.domain.entity.Article;
import io.springboot.linverno.developer.dto.ArticleDto.AddArticleRequest;
import io.springboot.linverno.developer.infrastructure.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

}
