DROP DATABASE IF EXISTS all_db;
DROP DATABASE IF EXISTS reg_db;
DROP DATABASE IF EXISTS exams_db;

CREATE USER IF NOT EXISTS 'student'@'localhost'
  identified by '';
GRANT ALL PRIVILEGES ON *.* TO 'student' @'localhost';

CREATE DATABASE all_db;
CREATE DATABASE reg_db;
CREATE DATABASE exams_b;