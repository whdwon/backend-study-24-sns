package com.example.sns.repository;

import com.example.sns.entity.Like;
import com.example.sns.entity.Post;
import com.example.sns.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository  extends JpaRepository<Like, Long> {
    Optional<Like> findByUserAndPost(User user, Post post);
}
