package com.example.sns.repository;

import com.example.sns.domain.Post; // Post 객체 사용
import org.springframework.jdbc.core.simple.JdbcClient; // 'JdbcClient' 도구 사용
import org.springframework.stereotype.Repository; // @Repository 어노테이션
import java.util.List; // List 타입 사용

// 이 클래스가 Repository임을 선언하는 어노테이션
@Repository
public class PostRepository {
    private final JdbcClient jdbcClient;

    public PostRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    // 게시글 작성(Create)하는 함수
    public void save(Post post) {
        jdbcClient.sql("INSERT INTO posts (title, content, user_id) VALUES (?, ?, ?)")
                .params(post.getTitle(), post.getContent(), post.getUser().getId())
                .update();
    }

    // 게시글 전체 조회(Read)하는 함수
    public List<Post> findAll() {
        return jdbcClient.sql("SELECT * FROM posts")
                .query(Post.class) // Post 객체로 매핑
                .list();
    }

    // 게시글 수정(Update)하는 함수
    public void update(Long id, String title, String content) {
        jdbcClient.sql("UPDATE posts SET title = ?, content = ? WHERE post_id = ?")
                .params(title, content, id)
                .update();
    }

    // 게시글 삭제(Delete)하는 함수
    public void delete(Long id) {
        jdbcClient.sql("DELETE FROM posts WHERE post_id = ?")
                .params(id)
                .update();
    }
}