CREATE DATABASE Assignment_SU24;

USE Assignment_SU24;

CREATE TABLE assesments
(
    aid    INT          NOT NULL,
    aname  VARCHAR(150) NOT NULL,
    weight FLOAT        NOT NULL,
    subid  INT NULL,
    PRIMARY KEY (aid)
);

CREATE TABLE courses
(
    cid   INT          NOT NULL,
    cname VARCHAR(150) NOT NULL,
    lid   INT          NOT NULL,
    subid INT          NOT NULL,
    semid INT          NOT NULL,
    PRIMARY KEY (cid)
);

CREATE TABLE exams
(
    eid      INT      NOT NULL,
    `from`   DATETIME NOT NULL,
    duration FLOAT    NOT NULL,
    aid      INT      NOT NULL,
    PRIMARY KEY (eid)
);

CREATE TABLE grades
(
    eid   INT   NOT NULL,
    sid   INT   NOT NULL,
    score FLOAT NOT NULL,
    PRIMARY KEY (eid, sid)
);

CREATE TABLE lecturers
(
    lid   INT          NOT NULL,
    lname VARCHAR(150) NOT NULL,
    PRIMARY KEY (lid)
);

CREATE TABLE semester
(
    semid INT NOT NULL,
    year  INT NOT NULL,
    PRIMARY KEY (semid)
);

CREATE TABLE students
(
    sid   INT          NOT NULL,
    sname VARCHAR(150) NOT NULL,
    PRIMARY KEY (sid)
);

CREATE TABLE students_courses
(
    sid INT NOT NULL,
    cid INT NOT NULL,
    PRIMARY KEY (sid, cid)
);

CREATE TABLE subjects
(
    subid   INT          NOT NULL,
    subname VARCHAR(150) NOT NULL,
    PRIMARY KEY (subid)
);

CREATE TABLE users
(
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    role     VARCHAR(50) NOT NULL,
    PRIMARY KEY (username)
);

CREATE TABLE users_lecturers
(
    username VARCHAR(50) NOT NULL,
    lid      INT         NOT NULL,
    PRIMARY KEY (username, lid)
);

ALTER TABLE assesments
    ADD CONSTRAINT FK_assesments_subjects FOREIGN KEY (subid) REFERENCES subjects (subid);

ALTER TABLE courses
    ADD CONSTRAINT FK_courses_lecturers FOREIGN KEY (lid) REFERENCES lecturers (lid);

ALTER TABLE courses
    ADD CONSTRAINT FK_courses_semester FOREIGN KEY (semid) REFERENCES semester (semid);

ALTER TABLE courses
    ADD CONSTRAINT FK_courses_subjects FOREIGN KEY (subid) REFERENCES subjects (subid);

ALTER TABLE exams
    ADD CONSTRAINT FK_exams_assesments FOREIGN KEY (aid) REFERENCES assesments (aid);

ALTER TABLE grades
    ADD CONSTRAINT FK_grades_exams FOREIGN KEY (eid) REFERENCES exams (eid);

ALTER TABLE grades
    ADD CONSTRAINT FK_grades_students FOREIGN KEY (sid) REFERENCES students (sid);

ALTER TABLE students_courses
    ADD CONSTRAINT FK_students_courses_courses FOREIGN KEY (cid) REFERENCES courses (cid);

ALTER TABLE students_courses
    ADD CONSTRAINT FK_students_courses_students FOREIGN KEY (sid) REFERENCES students (sid);

ALTER TABLE users_lecturers
    ADD CONSTRAINT FK_users_lecturers_lecturers FOREIGN KEY (lid) REFERENCES lecturers (lid);

ALTER TABLE users_lecturers
    ADD CONSTRAINT FK_users_lecturers_users FOREIGN KEY (username) REFERENCES users (username);

INSERT INTO users (username, password, role)
VALUES ('lecturer', 'lecturer', 'lecturer'),
       ('student', 'student', 'student');

INSERT INTO semester (semid, year)
VALUES (1, 2023),
       (2, 2024),
       (3, 2025);

INSERT INTO lecturers (lid, lname)
VALUES (1, 'lephu'),
       (2, 'tanhai'),
       (3, 'quoctuan'),
       (4, 'doanphong');

INSERT INTO subjects (subid, subname)
VALUES (1, 'Math'),
       (2, 'Physics'),
       (3, 'Biology');

INSERT INTO courses (cid, cname, lid, subid, semid)
VALUES (1, 'Web development', 1, 2, 1),
       (2, 'System Design', 2, 2, 1),
       (3, 'IT skills', 3, 1, 1);

INSERT INTO assesments (aid, aname, weight, subid)
VALUES (1, 'Assignment 1', 20, 1),
       (2, 'Assignment 2', 20, 1),
       (3, 'Assignment 3', 20, 1),
       (4, 'Assignment 1', 20, 2),
       (5, 'Assignment 2', 20, 2),
       (6, 'Assignment 1', 20, 3);

INSERT INTO exams (eid, `from`, duration, aid)
VALUES (1, '2024-04-25 08:00:00', 90, 1),
       (2, '2024-04-26 08:00:00', 90, 2),
       (3, '2024-04-26 08:00:00', 90, 4),
       (4, '2024-05-02 08:00:00', 90, 5),
       (5, '2024-05-02 08:00:00', 90, 6);

INSERT INTO students (sid, sname)
VALUES (1, 'vanbao'),
       (2, 'tuanminh'),
       (3, 'hoainam'),
       (4, 'trungdung');

INSERT INTO students_courses (sid, cid)
VALUES (1, 1),
       (2, 1),
       (2, 2),
       (2, 3),
       (3, 1),
       (3, 2);

INSERT INTO grades (eid, sid, score)
VALUES (1, 1, 7),
       (1, 2, 8),
       (1, 3, 7),
       (2, 1, 8),
       (2, 2, 6),
       (2, 3, 9);

INSERT INTO users_lecturers (username, lid)
VALUES ('lecturer', 1);
