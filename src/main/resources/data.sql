-- Courses
INSERT INTO course (id, level) VALUES (1, '초급');
INSERT INTO course (id, level) VALUES (2, '중급');
INSERT INTO course (id, level) VALUES (3, '고급');

-- Lessons for 초급
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (1, '아미노산의 이해','단백질의 이해' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (2, '펩타이드 결합 원리','단백질의 이해' ,'https://www.youtube.com/embed/ecOk9o-3GHc?si=6D7Yl4a-fvtW6d8C', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (3, '단백질 접힙','단백질의 이해' ,'https://www.youtube.com/embed/ecOk9o-3GHc?si=Rj6cnFX6yp7i9gGp', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (4, '모티프 & 도메인','단백질의 이해' ,'https://www.youtube.com/embed/dV-pKfqPGAo?si=bh4alclUMDc21aBI', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (5, '단백질의 종류','단백질의 이해' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (6, '데이터 베이스의 이해','데이터베이스' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (7, '관련 데이터 베이스 종류','데이터베이스' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (8, '단백질 데이터 베이스 포맷','데이터베이스' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (9, 'PDB 사용 실습','데이터베이스' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (10, 'Uniprot 사용 실습','데이터베이스' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (11, 'pyMOL 소개 및 설정','단백질 모델링' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (12, 'pyMOL 실습(1)','단백질 모델링' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (13, 'pyMOL 실습 (2)','단백질 모델링' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (14, '표적 단백질의 3차원 구조','단백질 모델링' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (15, '표적 단백질과 화합물','단백질 모델링' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (16, 'Alpha Fold의 등장','Alpha Fold' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (17, 'Alpha Fold 1 분석','Alpha Fold' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (18, 'Alpha Fold 2 분석','Alpha Fold' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (19, 'Colab Fold 실습(1)','Alpha Fold' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (20, 'Colab Fold 실습(2)','Alpha Fold' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (21, 'Sars-coV2 구조 분석','단백질 구조 분석' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (22, '리셉터 중합체 구조 분석','단백질 구조 분석' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (23, '단백질 설계 과정','단백질 구조 분석' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (24, '단백질 설계 알고리즘','단백질 구조 분석' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);
INSERT INTO lesson (id, title, subject,url, course_id) VALUES (25, '인공 단백질 설계','단백질 구조 분석' ,'https://www.youtube.com/embed/nDwAQr2c5d0?si=aBHGiGz1p9biqjj3', 1);