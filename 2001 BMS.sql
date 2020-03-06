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


------Trigger------
create or replace trigger login_pk_trig 
before insert or update on login
for each row
begin
    if INSERTING then
        select login_seq.nextVal into :new.user_id from dual;
    elsif UPDATING then
        select :old.user_id into :new.user_id from dual;
    end if;
end;
/


--------INSERTS----------------
insert into login (firstname, lastname, username, user_password, user_level)
        values('Ibrahim', 'Hamadi', 'IHamadi', 'password', 'Director');
        



commit;