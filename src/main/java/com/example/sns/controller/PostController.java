package com.example.sns.controller; // 이 파일의 위치

import com.example.sns.domain.Post; // Post 엔티티 사용
import com.example.sns.service.PostService; // 서비스 호출용
import org.springframework.web.bind.annotation.*; // @RestController, @GetMapping 등 웹 관련 전체
import java.util.List; // List 타입 사용

// 이 클래스가 Controller임을 선언하는 어노테이션
@RestController
// 컨트롤러 내 공통 URL 경로 지정하는 어노테이션
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 1. 작성
    @PostMapping
    public String create(@RequestBody Post post) {
        postService.createPost(post);
        return "게시글 작성 완료!";
    }

    // 2. 전체 조회
    @GetMapping
    public List<Post> list() {
        return postService.getAllPosts();
    }

    // 3. 수정
    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Post post) {
        postService.updatePost(id, post.getTitle(), post.getContent());
        return "게시글 수정 완료!";
    }

    // 4. 삭제
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        postService.deletePost(id);
        return "게시글 삭제 완료!";
    }
}