package com.example.sns.controller;

import com.example.sns.dto.PostRequestDto;
import com.example.sns.dto.PostResponseDto;
import com.example.sns.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor // 생성자 코드를 대신 생성.
public class PostController {

    private final PostService postService;

    // 1. 게시글 작성
    @PostMapping
    public String create(@RequestBody PostRequestDto requestDto) {
        postService.createPost(requestDto);
        return "게시글 작성 완료!";
    }

    // 2. 전체 조회
    @GetMapping
    public List<PostResponseDto> list() {
        return postService.getAllPosts();
    }

    // 3. 수정
    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        postService.updatePost(id, requestDto);
        return "게시글 수정 완료!";
    }

    // 4. 삭제
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        postService.deletePost(id);
        return "게시글 삭제 완료!";
    }
}