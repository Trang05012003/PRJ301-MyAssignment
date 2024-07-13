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

CREATE TABLE semester
(
    semid INT NOT NULL,
    year  INT NOT NULL,
    PRIMARY KEY (semid)
);

CREATE TABLE subjects
(
    subid   INT          NOT NULL,
    subname VARCHAR(150) NOT NULL,
    PRIMARY KEY (subid)
);

CREATE TABLE users
(
    id       INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    role     VARCHAR(50) NOT NULL,
    name     VARCHAR(150) NOT NULL
);

CREATE TABLE users_lecturers
(
    lecturer_id INT NOT NULL,
    student_id INT NOT NULL,
    PRIMARY KEY (lecturer_id, student_id),
    FOREIGN KEY (lecturer_id) REFERENCES users (id),
    FOREIGN KEY (student_id) REFERENCES users (id)
);

ALTER TABLE assesments
    ADD CONSTRAINT FK_assesments_subjects FOREIGN KEY (subid) REFERENCES subjects (subid);

ALTER TABLE courses
    ADD CONSTRAINT FK_courses_lecturers FOREIGN KEY (lid) REFERENCES users (id);

ALTER TABLE courses
    ADD CONSTRAINT FK_courses_semester FOREIGN KEY (semid) REFERENCES semester (semid);

ALTER TABLE courses
    ADD CONSTRAINT FK_courses_subjects FOREIGN KEY (subid) REFERENCES subjects (subid);

ALTER TABLE exams
    ADD CONSTRAINT FK_exams_assesments FOREIGN KEY (aid) REFERENCES assesments (aid);

ALTER TABLE grades
    ADD CONSTRAINT FK_grades_exams FOREIGN KEY (eid) REFERENCES exams (eid);

ALTER TABLE grades
    ADD CONSTRAINT FK_grades_students FOREIGN KEY (sid) REFERENCES users (id);

INSERT INTO users (username, password, role, name)
VALUES ('lecturer', 'lecturer', 'lecturer', 'lephu'),
       ('student1', 'student', 'student', 'vanbao'),
       ('student2', 'student', 'student', 'tuanminh'),
       ('student3', 'student', 'student', 'hoainam'),
       ('student4', 'student', 'student', 'trungdung');

INSERT INTO semester (semid, year)
VALUES (1, 2023),
       (2, 2024),
       (3, 2025);

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
