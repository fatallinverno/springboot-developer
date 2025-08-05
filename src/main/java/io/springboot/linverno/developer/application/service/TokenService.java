package io.springboot.linverno.developer.application.service;

import io.springboot.linverno.developer.config.jwt.TokenProvider;
import io.springboot.linverno.developer.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(String refreshToken) {

        if (!tokenProvider.validateToken(refreshToken)) {
            throw new IllegalArgumentException("Invalid refresh token");
        }

        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getId();
        User user = userService.findById(userId);

        return tokenProvider.generateToken(user, Duration.ofHours(2));

    }

}
