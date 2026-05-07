-- 외래키 제약 조건 때문에 posts를 먼저 삭제해야 합니다.
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS users;

-- 사용자 테이블 생성
CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL, -- 요청하신 대로 username으로 설정
                       email VARCHAR(255) NOT NULL     -- email 컬럼 추가 (비어있을 수 없음)
);

-- 게시글 테이블 생성
CREATE TABLE posts (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       content TEXT,
                       user_id BIGINT,
                       FOREIGN KEY (user_id) REFERENCES users(id)
);