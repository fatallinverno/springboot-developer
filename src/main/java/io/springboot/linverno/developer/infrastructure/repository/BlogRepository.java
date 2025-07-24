package io.springboot.linverno.developer.infrastructure.repository;

import io.springboot.linverno.developer.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long> {
}
