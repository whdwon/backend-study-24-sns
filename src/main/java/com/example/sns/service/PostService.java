package com.example.sns.service; // 이 파일의 위치

import com.example.sns.domain.Post; // Post 객체 사용
import com.example.sns.repository.PostRepository; // 레포지터리 호출용
import org.springframework.stereotype.Service; // @Service 어노테이션
import org.springframework.transaction.annotation.Transactional; // @Transactional 어노테이션
import java.util.List; // List 타입 사용

// 이 클래스가 Service임을 선언하는 어노테이션
@Service
@Transactional // 데이터 변경 시 필요
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(Post post) {
        postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void updatePost(Long id, String title, String content) {
        postRepository.update(id, title, content);
    }

    public void deletePost(Long id) {
        postRepository.delete(id);
    }
}