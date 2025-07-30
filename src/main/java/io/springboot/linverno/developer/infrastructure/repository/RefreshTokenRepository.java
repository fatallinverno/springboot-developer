package io.springboot.linverno.developer.infrastructure.repository;

import io.springboot.linverno.developer.domain.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByUserId(Long Id);
    Optional<RefreshToken> findByRefreshToken(String refreshToken);

}
