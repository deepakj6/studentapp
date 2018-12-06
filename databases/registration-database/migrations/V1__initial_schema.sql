CREATE TABLE students (
id BIGINT(20) not null auto_increment,
student_name varchar(45),
date_of_birth DATETIME,
date_of_admission DATETIME,
semester BIGINT(20),
primary key (id)
)

engine = innodb
default charset = utf8;