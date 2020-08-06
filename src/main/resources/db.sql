create TYPE  users_type as Enum('company', 'employee');
drop table  employees;

create table users(
                      id char(32) not null primary key ,
                      email varchar(100) unique,
                      password varchar(20),
                      type varchar (20)

);
insert into users (id,email,password,type) values ('makerskiroanam2jo0elsmdy7eboeks','.hljshdj','123','employee');
create table employees(
                          id serial primary key ,
                          user_id char(32) unique not null ,
                          first_name varchar(100) not null ,
                          last_name varchar(100) not null ,
                          birthday date  ,
                          phone_number char(12) check ( phone_number like '+374%'),
                          address text ,
                          foreign key  (user_id) references users(id) on delete cascade
);
create table cvs(
                    id serial primary key ,
                    user_id char(32) unique not null ,
                    cv_bytes bytea ,
                    foreign key (user_id) references users (id) on delete cascade
);
Update employees set address=? where user_id=?;

create table companies(
    id  serial primary key ,
    user_id char(32) unique not null ,
    domain_name varchar(100),
    phone_number char(12) check ( phone_number like '+374%'),
    foreign key (user_id) references users(id) on delete cascade
);