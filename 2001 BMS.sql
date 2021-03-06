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
drop table chatter cascade constraints;







-------Sequences-----

drop sequence login_seq;
drop sequence courses_seq;
drop sequence grade_levels_seq;
drop sequence inventory_seq;
drop sequence instruments_seq;
drop sequence uniforms_seq;
drop sequence instrument_type_seq;
drop sequence uniform_type_seq;
drop sequence students_seq;
drop sequence instructors_seq;
drop sequence assignment_types_seq;
drop sequence statuses_seq;
drop sequence requests_seq;
drop sequence assignment_seq;
drop sequence comments_seq;
drop sequence chatter_seq;





create sequence login_seq nocache;
create sequence courses_seq nocache;
create sequence grade_levels_seq nocache;
create sequence inventory_seq start with 13 nocache;
create sequence instruments_seq nocache;
create sequence uniforms_seq nocache;
create sequence instrument_type_seq nocache;
create sequence uniform_type_seq nocache;
create sequence students_seq nocache;
create sequence instructors_seq nocache;
create sequence assignment_types_seq nocache;
create sequence statuses_seq nocache;
create sequence requests_seq nocache;
create sequence assignment_seq nocache;
create sequence comments_seq nocache;
create sequence chatter_seq nocache;




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
    instruments_inventory_id number(3) PRIMARY KEY,
    instrument_name varchar2(50),
    foreign key (instruments_inventory_id) references inventory(item_id)
);

create table uniforms(
    uniforms_inventory_id number(3) PRIMARY KEY,
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
    assignment_instrument varchar2(50),
    date_assigned date,
    date_due date,
    date_submitted date,
    status varchar(50)
);
create table comments(
    comment_id number(3) primary key,
    reciever number(3),
    sender number(3),
    time_stamp TIMESTAMP,
    cmmnt varchar2(100), 
    foreign key (reciever) references login(user_id),
    foreign key (sender) references login(user_id)
);

create table chatter(
    chat_id number(3) primary key,
    reciever number(3),
    sender number(3),
    chat_timestamp TIMESTAMP,
    message varchar2(100) , 
    read_reciept varchar2(50)
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
insert into inventory (item_id)
        values(8);
insert into inventory (item_id)
        values(9);
insert into inventory (item_id)
        values(10);        
insert into inventory (item_id)
        values(11);
insert into inventory (item_id)
        values(12);
        
        
----------Instruments-----------
insert into instruments (instruments_inventory_id, instrument_name)
        values(1,'Old Tuba');
insert into instruments (instruments_inventory_id, instrument_name)
        values(2,'New Tuba');
insert into instruments (instruments_inventory_id, instrument_name)
        values(6,'Trombone 1');
insert into instruments (instruments_inventory_id, instrument_name)
        values(7,'Grimy Bass Trombone');
insert into instruments (instruments_inventory_id, instrument_name)
        values(8,'Grand Piano');
insert into instruments (instruments_inventory_id, instrument_name)
        values(9,'Rhodes Piano');
insert into instruments (instruments_inventory_id, instrument_name)
        values(10,'Bass Guitar');
insert into instruments (instruments_inventory_id, instrument_name)
        values(11,'Electric Guitar');
----------Uniform--------------
insert into uniforms (uniforms_inventory_id, uniforms_name)
    values (3, 'Small Uniform');
insert into uniforms (uniforms_inventory_id, uniforms_name)
    values (4, 'Large Uniform');
insert into uniforms (uniforms_inventory_id, uniforms_name)
    values (5, 'Smelly Uniform');
    
    
    
------USER-----
insert into login(user_id, firstname, lastname, username, user_password) 
    values(2, 'Bob', 'Bob', 'BBob', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(3, 'Ron', 'Swanson', 'RSwanson', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(4, 'Gaylord', 'Balcom', 'GBalcom', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(5, 'Hosea', 'Jack', 'HJack', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(6, 'Vera', 'Fuselier', 'VFuselier', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(7, 'Kacy', 'Poplar', 'KPoplar', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(8, 'Scottie', 'Wallen', 'SWallen', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(9, 'Deanna', 'Soukup', 'DSoukup', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(10, 'Brant', 'Dipaola', 'BDipaola', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(11, 'Jeffie', 'Parnell', 'JParnell', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(12, 'Monte', 'Heilig', 'MHeilig', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(13, 'Terrell', 'Metzer', 'TMetzer', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(14, 'Annelle', 'Ziolkowski', 'AZiolkowski', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(15, 'Lucila', 'Tiger', 'LTiger', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(16, 'Marybelle', 'Ensign', 'MEnsign', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(17, 'Carmen', 'Caylor', 'CCaylor', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(18, 'Melinda', 'Waiters', 'MWaiters', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(19, 'Darlene', 'Mund', 'DMund', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(20, 'Sophia', 'Williams', 'SWilliams', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(21, 'Emma', 'Alexander', 'EAlexander', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(22, 'Olivia', 'Henry', 'OHenry', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(23, 'Charlotte', 'John', 'CJohn', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(24, 'Genesis', 'James', 'GJames', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(25, 'Sofia', 'Daniel', 'SDaniel', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(26, 'Ava', 'Benjamin', 'ABenjamin', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(27, 'Chloe', 'Samuel', 'CSamuel', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(28, 'Madison', 'David', 'MDavid', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(29, 'Zoe', 'Jacob', 'ZJacob', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(30, 'Naomi', 'Anthony', 'NAnthony', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(31, 'Elijah', 'Daniel', 'EDaniel', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(32, 'Ethan', 'Dylan', 'EDylan', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(33, 'Liam', 'Christopher', 'LChristopher', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(34, 'Christian', 'Alexander', 'CAlexander', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(35, 'Ryan', 'Jacobs', 'RJacobs', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(36, 'Thomas', 'Henry', 'THenry', 'password');
insert into login(user_id, firstname, lastname, username, user_password) 
    values(37, 'Noah', 'James', 'NJames', 'password');
    
-------INstructors------
insert into instructors(instructor_id, Instructor_course_id) 
    values(3, 3);
insert into instructors(instructor_id, Instructor_course_id) 
    values(4, 4);
insert into instructors(instructor_id, Instructor_course_id) 
    values(5, 5);
insert into instructors(instructor_id, Instructor_course_id) 
    values(6, 2);    
insert into instructors(instructor_id, Instructor_course_id) 
    values(7, 1); 
    
    
----STUDENTTS---
insert into students(student_id, student_course_id) 
    values(2,3);
insert into students(student_id, student_course_id) 
    values(8,3);
insert into students(student_id, student_course_id) 
    values(9,3);
insert into students(student_id, student_course_id) 
    values(10,3);
insert into students(student_id, student_course_id) 
    values(11,3);
    
    
    
insert into students(student_id, student_course_id) 
    values(1,2);
insert into students(student_id, student_course_id) 
    values(12,2);
insert into students(student_id, student_course_id) 
    values(13,2);
insert into students(student_id, student_course_id) 
    values(14,2);
insert into students(student_id, student_course_id) 
    values(15,2);
insert into students(student_id, student_course_id) 
    values(31,2);
insert into students(student_id, student_course_id) 
    values(32,2);
    

insert into students(student_id, student_course_id) 
    values(16,1);
insert into students(student_id, student_course_id) 
    values(17,1);
insert into students(student_id, student_course_id) 
    values(18,1);
insert into students(student_id, student_course_id) 
    values(19,1);
insert into students(student_id, student_course_id) 
    values(20,1);    
insert into students(student_id, student_course_id) 
    values(33,1);
insert into students(student_id, student_course_id) 
    values(34,1);     
    
insert into students(student_id, student_course_id) 
    values(21,4);
insert into students(student_id, student_course_id) 
    values(22,4);
insert into students(student_id, student_course_id) 
    values(23,4);
insert into students(student_id, student_course_id) 
    values(24,4);
insert into students(student_id, student_course_id) 
    values(25,4);   
insert into students(student_id, student_course_id) 
    values(35,4);
insert into students(student_id, student_course_id) 
    values(36,4); 
    
insert into students(student_id, student_course_id) 
    values(26,5);
insert into students(student_id, student_course_id) 
    values(27,5);
insert into students(student_id, student_course_id) 
    values(28,5);
insert into students(student_id, student_course_id) 
    values(29,5);
insert into students(student_id, student_course_id) 
    values(30,5); 
insert into students(student_id, student_course_id) 
    values(37,5); 
        
    
    
    
    
    
    
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