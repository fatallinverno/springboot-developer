package io.springboot.linverno.developer.application.service;

import io.springboot.linverno.developer.domain.entity.User;
import io.springboot.linverno.developer.dto.request.AddUserRequest;
import io.springboot.linverno.developer.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }

    public User findById(Long id) {

        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Unexpected user"));

    }

}
