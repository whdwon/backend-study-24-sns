package com.example.sns.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 중복되는 어노테이션 설명은 User에 있음
@Entity
@Getter
@NoArgsConstructor
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    // (세부설정에서 DB의 열 타입을 TEXT로 지정, 수만 글자 이상 저장 가능)
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    // 양방향 N:1 관계 매핑 어노테이션 (여러 게시글을 사용자 한 명이 가짐)
    @ManyToOne(fetch = FetchType.LAZY)
    // DB테이블에서 외래키(FK)의 이름을 user_id로 지정하는 어노테이션
    @JoinColumn(name = "user_id")
    private User user;

    // 게시글 생성을 위한 생성자
    public Post(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    // 수정 기능을 위한 함수
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}