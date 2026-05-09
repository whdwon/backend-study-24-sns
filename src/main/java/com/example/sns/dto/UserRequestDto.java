package com.example.sns.dto;

// 유저를 등록할 때 필요한 정보
public record UserRequestDto(
        String username,
        String email,
        String password
) {}
