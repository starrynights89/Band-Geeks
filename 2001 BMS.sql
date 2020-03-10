---DROPS TABLES---
drop table login cascade constraints;


---DROP SEQ---
drop sequence login_seq;


-------Sequences-----
create sequence login_seq nocache;
create sequence assignments_seq nocache;
create sequence comments_seq nocache;
create sequence inventory_seq nocache;
create sequence item_types_seq nocache;
create sequence instruments_seq nocache;
create sequence uniforms_seq nocache;
create sequence courses_seq nocache;
create sequence grade_levels_seq nocache;
create sequence students_seq nocache;
create sequence instructors_seq nocache;
create sequence assignment_types_seq nocache;

-------TABLES---------
create table login(
    user_id number(3) PRIMARY KEY,
    firstname varchar2(20),
    lastname varchar2(20),
    username varchar2(20),
    user_password varchar2(20)
);
/*
create table item_types(
    item_type_id number(3),
    item_name varchar2(50)
);
create table instruments(
    instrument_id number(3),
    instrument_name varchar2(50)
);
create table uniforms(
    uniforms_id number(3),
    uniforms_type varchar2(50)
);

create table courses(
    course_id number(3),
    course_name varchar2(50)
);

create table grade_levels(
    grade_level_id number(3),
    grade_level_name varchar2(50)
);

create table students(
    student_id number(3) primary key,
    instrument_id number(3),
    grade_level_id number(3),
    course_id number(3),
    foreign key (instrument_id) references instruments(instrument_id),
    foreign key (grade_level_id) references grade_levels(grade_level_id),
    foreign key (course_id) references courses(course_id),
    foreign key (student_id) references login(user_id)

);

create table instructors(
    instructor_id number(3) primary key,
    course_id number(3),
    foreign key (course_id) references courses(course_id),
    foreign key (instructor_id) references login(user_id)
);

create table assignment_types(
    assignment_type_id number(3) primary key,
    assignment_description varchar2(100),
    assignment_type_name varchar2(50)
);

create table assignment(
    assignment_id number(3) primary key,
    student_id number(3),
    instructor_id varchar2(20),
    assignment_type_id varchar2(20),
    date_assigned date,
    date_due date,
    foreign key (student_id) references students(student_id),
    foreign key (instructor_id) references instructors(instructor_id),
    foreign key (assignment_type_id) references assignment_types(assignment_type_id)
);
create table comments(
    comment_id number(3) primary key,
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
    item_type_id varchar2(50),
    foreign key (student_id) references students(student_id),
    foreign key (item_type_id) references item_types(item_type_id)
);


















*/


--------INSERTS----------------
insert into login (firstname, lastname, username, user_password, user_level)
        values('Ibrahim', 'Hamadi', 'IHamadi', 'password', 'Instructor');
        


commit;