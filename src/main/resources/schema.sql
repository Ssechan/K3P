-- User 테이블 생성
CREATE TABLE user (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          user_id VARCHAR(255) NOT NULL UNIQUE,
                          user_password VARCHAR(255) NOT NULL,
                          user_email VARCHAR(255) NOT NULL UNIQUE
);

--Course 테이블 생성
CREATE TABLE course (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        level VARCHAR(255)
);

-- Lesson 테이블 생성
CREATE TABLE lesson (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(255),
                        subject VARCHAR(255),
                        url VARCHAR(255),
                        course_id BIGINT,
                        FOREIGN KEY (course_id) REFERENCES course(id)
);

-- Quiz 테이블 생성
CREATE TABLE quiz (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255)
);

-- Question 테이블 생성
CREATE TABLE question (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          question TEXT,
                          options TEXT, -- JSON 형식으로 저장하기 위해 TEXT 사용
                          correct_answer VARCHAR(255),
                          quiz_id BIGINT,
                          FOREIGN KEY (quiz_id) REFERENCES quiz(id)
);

-- UserLesson 테이블 생성
CREATE TABLE user_lesson (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             user_id BIGINT,
                             lesson_id BIGINT,
                             completed BOOLEAN,
                             passed BOOLEAN,
                             FOREIGN KEY (user_id) REFERENCES user(id),
                             FOREIGN KEY (lesson_id) REFERENCES lesson(id)
);