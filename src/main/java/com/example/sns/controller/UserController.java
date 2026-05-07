package com.example.sns.controller;

import com.example.sns.domain.User; // User 엔티티 사용
import org.springframework.jdbc.core.simple.JdbcClient; // JdbcClient 도구
import org.springframework.web.bind.annotation.*; // @RestController, @PostMapping 등

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final JdbcClient jdbcClient;

    // 생성자 주입 방식으로 JdbcClient를 가져옵니다.
    public UserController(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        jdbcClient.sql("INSERT INTO users (username, email) VALUES (?, ?)")
                .params(user.getUsername(), user.getEmail())
                .update();

        return "사용자 생성 완료!";
    }
}
