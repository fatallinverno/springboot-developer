package io.springboot.linverno.developer.presentation.controller;

import io.springboot.linverno.developer.application.service.TestService;
import io.springboot.linverno.developer.domain.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public List<Member> getAllMembers() {
        List<Member> members = testService.getAllMembers();

        return members;
    }

}
