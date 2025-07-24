package io.springboot.linverno.developer.application.service;

import io.springboot.linverno.developer.domain.entity.Member;
import io.springboot.linverno.developer.infrastructure.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

}
