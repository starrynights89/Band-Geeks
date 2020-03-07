---DROPS---
drop table login cascade constraints;



drop sequence login_seq;


-------Sequences-----
create sequence login_seq nocache;



-------TABLES---------
create table login(
    user_id number(3) PRIMARY KEY,
    firstname varchar2(20),
    lastname varchar2(20),
    username varchar2(20),
    user_password varchar2(20),
    user_level varchar2(20)
);

create table assignment(
    student_id number(3),
    instructor_id varchar2(20),
    assignment_id varchar2(20),
    date_assigned date,
    date_due date
);
create table comments(
    reciever number(3),
    sender number(3),
    time_stamp TIMESTAMP,
    cmmnt varchar2(100)
);
create table inventory(
    item_id number(3) PRIMARY KEY,
    check_in timestamp,
    check_out timestamp,
    instructor_id number(3),
    student_id number(3),
    item_type_id varchar2(50)
);
create table assignment_type(
    assignment_key number(3),
    assignment_description varchar2(100),
    assignment_type_name varchar2(50)
);
create table item_type(
    item_key number(3),
    item_name varchar2(50)
);
create table instrument(
    instrument_key number(3),
    instrument_name varchar2(50)
);
create table uniforms(
    uniforms_key number(3),
    uniforms_type varchar2(50)
);

create table students(
    student_id number(3),
    instrument_id number(3),
    grade_level_id number(3)
);

create table instructor(
    faculty_id number(3),
    instructor_classification_id number(3)  
);

create table courses(
    course_id number(3),
    course_name varchar2(50)
);

create table grade_level(
    grade_level_id number(3),
    grade_level_name varchar2(50)
);



















--------INSERTS----------------
insert into login (firstname, lastname, username, user_password, user_level)
        values('Ibrahim', 'Hamadi', 'IHamadi', 'password', 'Director');
        


commit;