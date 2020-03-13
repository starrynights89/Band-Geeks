---DROPS TABLES---
drop table login cascade constraints;
drop table instruments cascade constraints;
drop table uniforms cascade constraints;
drop table courses cascade constraints;
drop table grade_levels cascade constraints;
drop table students cascade constraints;
drop table instructors cascade constraints;
drop table assignment_types cascade constraints;
drop table assignment cascade constraints;
drop table comments cascade constraints;
drop table inventory cascade constraints;
drop table requests cascade constraints;
drop table instrument_type cascade constraints;
drop table statuses cascade constraints;
drop table uniform_type cascade constraints;






-------Sequences-----


-------TABLES---------
create table login(
    user_id number(3) PRIMARY KEY,
    firstname varchar2(20),
    lastname varchar2(20),
    username varchar2(20),
    user_password varchar2(20)
);


create table courses(
    course_id number(3) PRIMARY KEY,
    course_name varchar2(50)
);

create table grade_levels(
    grade_level_id number(3) PRIMARY KEY,
    grade_level_name varchar2(50)
);
create table inventory(
    item_id number(3) PRIMARY KEY
);

create table instruments(
    instrument_id number(3) PRIMARY KEY,
    instruments_inventory_id number(3),
    instrument_name varchar2(50),
    foreign key (instruments_inventory_id) references inventory(item_id)
);

create table uniforms(
    uniforms_id number(3),
    uniforms_inventory_id number(3),
    uniforms_name varchar2(50),
    foreign key (uniforms_inventory_id) references inventory(item_id)
);
create table instrument_type(
    instrument_type_id number(3) primary key,
    instrument_type_name varchar2(50)
);
create table uniform_type(
    uniform_type_id number(3) primary key,
    uniform_type_name varchar2(50)
);

create table students(
    student_id number(3) primary key,
    student_grade_level_id number(3),
    student_course_id number(3),
    student_instrument_type_id number(3),
    student_uniform_type_id number(3),
    foreign key (student_instrument_type_id) references instrument_type(instrument_type_id),
    foreign key (student_grade_level_id) references grade_levels(grade_level_id),
    foreign key (student_course_id) references courses(course_id),
    foreign key (student_id) references login(user_id),
    foreign key (student_uniform_type_id) references uniform_type(uniform_type_id)


);

create table instructors(
    instructor_id number(3) primary key,
    instructor_course_id number(3),
    foreign key (instructor_course_id) references courses(course_id),
    foreign key (instructor_id) references login(user_id)
);


create table assignment_types(
    type_id number(3) primary key,
    assignment_description varchar2(100),
    assignment_type_name varchar2(50)
);


create table statuses(
    status_id number(3) primary key,
    status_type varchar2(20)
);

create table requests(
    request_id number(3) primary key,
    req_inventory_id number(3),
    req_student_id number(3),
    req_instructor_id number(3),
    req_status_id number(3),
    check_in TIMESTAMP,
    check_out TIMESTAMP,
    foreign key (req_inventory_id) references inventory(item_id),
    foreign key (req_student_id) references students(student_id),
    foreign key (req_instructor_id) references instructors(instructor_id),
    foreign key (req_status_id) references statuses(status_id)
);

create table assignment(
    assignment_id number(3) primary key,
    assignment_student_id number(3),
    assignment_instructor_id number(3),
    assignment_type_id number(3),
    assignment_grade varchar2(3),
    date_assigned date,
    date_due date,
    foreign key (assignment_student_id) references students(student_id),
    foreign key (assignment_instructor_id) references instructors(instructor_id),
    foreign key (assignment_type_id) references assignment_types(type_id)
);
create table comments(
    comment_id number(3) primary key,
    reciever number(3),
    sender number(3),
    time_stamp TIMESTAMP,
    cmmnt varchar2(100)
);


--------INSERTS----------------


-------USERS-------------
insert into login (user_id, firstname, lastname, username, user_password)
        values(1,'Ibrahim', 'Hamadi', 'IHamadi', 'password');
        
        
        
        
-------COURSES------------
insert into courses (course_id, course_name)
        values(1, 'Music Theory');
insert into courses (course_id, course_name)
        values(2, 'Jazz Band');
insert into courses (course_id, course_name)
        values(3, 'Marching Band');
insert into courses (course_id, course_name)
        values(4, 'Samba');
insert into courses (course_id, course_name)
        values(5, 'Opera');
        
        
-------Assignment--Types------------
insert into assignment_types(type_id, assignment_description, assignment_type_name)
        values(1, 'Listen to a song and memorize the tune', 'Listening Activity');
insert into assignment_types(type_id, assignment_description, assignment_type_name)
        values(2, 'Learn to play specific song with no mistakes', 'Practice and Memorization');
insert into assignment_types(type_id, assignment_description, assignment_type_name)
        values(3, 'Learn to tune your instrument by ear', 'Ear Training');
insert into assignment_types(type_id, assignment_description, assignment_type_name)
        values(4, 'Students will warm up their instruments on 3 major scales, Bflat, E-flat, and A-flat.', 'Grand Major Scales');
insert into assignment_types(type_id, assignment_description, assignment_type_name)
        values(5, 'Students will be assigned the 2 pages of theory worksheet', 'Theory Worksheet');
       
       
       

insert into instrument_type (instrument_type_id, instrument_type_name)
        values(1, 'Flute');
insert into instrument_type (instrument_type_id, instrument_type_name)
        values(2, 'Clarinet');
insert into instrument_type (instrument_type_id, instrument_type_name)
        values(3, 'Saxophone');
insert into instrument_type (instrument_type_id, instrument_type_name)
        values(4, 'French Horn');
insert into instrument_type (instrument_type_id, instrument_type_name)
        values(5, 'Trombone');
insert into instrument_type (instrument_type_id, instrument_type_name)
        values(6, 'Euphonium');
insert into instrument_type (instrument_type_id, instrument_type_name)
        values(7, 'Tuba');
insert into instrument_type (instrument_type_id, instrument_type_name)
        values(8, 'Percussion');
-----------Inventory----------
insert into inventory (item_id)
        values(1);
insert into inventory (item_id)
        values(2);
insert into inventory (item_id)
        values(3);        
insert into inventory (item_id)
        values(4);
insert into inventory (item_id)
        values(5);
insert into inventory (item_id)
        values(6);
insert into inventory (item_id)
        values(7);
----------Instruments-----------
insert into instruments (instrument_id, instruments_inventory_id, instrument_name)
        values(1,1,'Old Tuba');
insert into instruments (instrument_id, instruments_inventory_id, instrument_name)
        values(2,2,'New Tuba');
insert into instruments (instrument_id, instruments_inventory_id, instrument_name)
        values(3,6,'Trombone 1');
insert into instruments (instrument_id, instruments_inventory_id, instrument_name)
        values(4,7,'Grimy Bass Trombone');
----------Uniform--------------
insert into uniforms (uniforms_id, uniforms_inventory_id, uniforms_name)
    values (1, 3, 'Small Uniform');
insert into uniforms (uniforms_id, uniforms_inventory_id, uniforms_name)
    values (2, 4, 'Large Uniform');
insert into uniforms (uniforms_id, uniforms_inventory_id, uniforms_name)
    values (3, 5, 'Smelly Uniform');
    
    
    
------USER-----
insert into login(user_id, firstname, lastname, username, user_password) 
    values(2, 'Bob', 'Bob', 'BBob', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(3, 'Ron', 'Swanson', 'RSwanson', 'password');
    
-------INstructors------
insert into instructors(instructor_id, Instructor_course_id) 
    values(3, 3);
insert into students(student_id, student_course_id) 
    values(2,3);
insert into students(student_id, student_course_id) 
    values(1,2);
    
    ----------gradelevel--------------
insert into grade_levels (grade_level_id, grade_level_name)
    values (1, 'Freshman');
insert into grade_levels (grade_level_id, grade_level_name)
    values (2, 'Sophomore');
insert into grade_levels (grade_level_id, grade_level_name)
    values (3, 'Junior');
insert into grade_levels (grade_level_id, grade_level_name)
    values (4, 'Senior');
 
---------Uniform Type-----------   
    
insert into uniform_type (uniform_type_id, uniform_type_name)
    values (1, 'Marching Uniform');
insert into uniform_type (uniform_type_id, uniform_type_name)
    values (2, 'Jazz Uniform');
insert into uniform_type (uniform_type_id, uniform_type_name)
    values (3, 'Opera Uniform');
insert into uniform_type (uniform_type_id, uniform_type_name)
    values (4, 'Samba Uniform');

-------Statuses------------
insert into statuses (status_id, status_type)
    values (1, 'PENDING');
insert into statuses (status_id, status_type)
    values (2, 'ACCEPTED');
insert into statuses (status_id, status_type)
    values (3, 'REJECTED');
    
    ----Test Request----------
insert into requests (request_id, req_inventory_id, req_student_id)
    values (1, 1, 1);
commit;