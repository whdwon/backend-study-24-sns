package com.example.sns.repository;

import com.example.sns.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JPA 버전
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // save(), findAll(), findById(), deleteById() 등이 자동으로 생성.
}