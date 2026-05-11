package com.example.sns.repository;

import com.example.sns.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository를 상속하므로 @Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository를 상속받으면 findById() 같은 기본 기능은 자동 생성
}
