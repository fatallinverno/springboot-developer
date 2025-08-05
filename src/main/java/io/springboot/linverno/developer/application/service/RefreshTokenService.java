package io.springboot.linverno.developer.application.service;

import io.springboot.linverno.developer.config.jwt.TokenProvider;
import io.springboot.linverno.developer.domain.entity.RefreshToken;
import io.springboot.linverno.developer.infrastructure.repository.RefreshTokenRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {

        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Refresh token not found"));

    }

}
