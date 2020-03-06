-- Script to CREATE and then GRANT access to the BookApp user
-- The BookApp user will only have access to the schema
-- of my bookstore.

/*
I like to separate my scripts by use case. I'll create
    a separate DCL, DDL, and DML script.
    This is just a personal preference.
    
    create a user -> define the user's schema -> add data to the schema
*/
-- A fresh start. Drop the user
drop user bmsapp cascade; -- semi-colons are necessary

/* One of the reasons we separate the schemas into users
    is so that we have restricted access to what we need in the
    moment. We are currently logged in as the admin user. That
    user has DBA priveleges. 
*/
-- create a user
create user bmsapp
identified by p4ssw0rd
default tablespace users
temporary tablespace temp
quota 10m on users;

-- DCL
-- Controls access to data
-- consists of two keywords: grant and revoke

-- ability to connect to another user from bookapp
grant connect to bmsapp;
-- ability to create types
grant resource to bmsapp;

-- WE DON'T want the ability to alter and destroy types
-- grant dba to bookapp;

-- ability to create a transaction session
grant create session to bmsapp;

grant create table to bmsapp;
grant create view to bmsapp;

-- Older versions of Oracle SQL we had to grant
-- grant select, insert, update, delete to bookapp;