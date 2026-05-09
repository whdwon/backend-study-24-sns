package com.example.sns.controller;

import com.example.sns.dto.UserRequestDto;
import com.example.sns.dto.UserResponseDto;
import com.example.sns.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor // 생성자 주입을 자동으로 해줍니다 (final 필드 대상)
public class UserController {
    private final UserService userService;

    // 유저 생성 (회원 가입)
    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto dto) {
        // SQL을 직접 쓰지 않고 서비스에 처리를 맡깁니다.
        return userService.createUser(dto);
    }

    // 유저 전체 조회
    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }
}
