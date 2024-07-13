CREATE DATABASE Assignment_SU24;

USE Assignment_SU24;

CREATE TABLE semester
(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    year  INT NOT NULL
);

CREATE TABLE users
(
    id       INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50)        NOT NULL,
    role     VARCHAR(50)        NOT NULL,
    name     VARCHAR(150)       NOT NULL
);

CREATE TABLE courses
(
    id    INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name  VARCHAR(150) NOT NULL,
    semid INT          NOT NULL,
    FOREIGN KEY (semid) REFERENCES semester (id)
);

CREATE TABLE assessments
(
    id     INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name   VARCHAR(150) NOT NULL,
    weight FLOAT        NOT NULL
);

CREATE TABLE grades
(
    id    INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    uid   INT   NOT NULL,
    aid   INT   NOT NULL,
    score FLOAT NOT NULL,
    FOREIGN KEY (uid) REFERENCES users (id),
    FOREIGN KEY (aid) REFERENCES assessments (id)
);

CREATE TABLE users_courses
(
    id       INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    uid      INT NOT NULL,
    lid      INT NOT NULL,
    courseId INT NOT NULL,
    active   BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (uid) REFERENCES users (id),
    FOREIGN KEY (courseId) REFERENCES courses (id),
    FOREIGN KEY (lid) REFERENCES users (id)
);

INSERT INTO semester (year)
VALUES (2023),
       (2024),
       (2025);

INSERT INTO users (username, password, role, name)
VALUES ('lecturer', 'lecturer', 'lecturer', 'lephu'),
       ('student1', 'student', 'student', 'vanbao'),
       ('student2', 'student', 'student', 'tuanminh'),
       ('student3', 'student', 'student', 'hoainam'),
       ('student4', 'student', 'student', 'trungdung'),
        ('admin', 'admin', 'admin', 'admin');

INSERT INTO courses (name, semid)
VALUES ('Web development', 1),
       ('System Design', 1),
       ('IT skills', 1);

INSERT INTO assessments (name, weight)
VALUES ('WS1', 0.05),
       ('WS2', 0.05),
       ('PT1', 0.1),
       ('PT2', 0.1),
       ('PE', 0.2),
       ('FE', 0.2);

INSERT INTO grades (uid, aid, score)
VALUES (1, 1, 85),
       (2, 2, 78),
       (3, 3, 90),
       (4, 4, 82),
       (1, 5, 88);

INSERT INTO users_courses (uid, lid, courseId)
VALUES (2, 1, 1),
       (3, 1, 2),
       (4, 1, 3);
