CREATE TABLE IF NOT EXISTS staffs (
    id INT PRIMARY KEY,
    full_name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(50) NOT NULL,
    work_type VARCHAR(50) NOT NULL,
    course_teaching VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS students(
    id INT PRIMARY KEY,
    full_name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(50) NOT NULL,
    enrolled_course VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS applicants(
    id INT PRIMARY KEY,
    full_name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(50) NOT NULL,
    interested_course VARCHAR(50) NOT NULL
);