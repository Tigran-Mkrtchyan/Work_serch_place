create TYPE  users_type as Enum('company', 'employee');
drop table  employees;

create table users(
                      id char(32) not null primary key ,
                      email varchar(100) unique,
                      password varchar(20),
                      type varchar (20)

);
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
select u.id ,u.type, concat( e.first_name ,c.company_name) as name from users u
    left join employees e on u.id = e.user_id
    left join companies c on u.id = c.user_id
    where u.email = ? and u.password = ?

    select first_name,last_name,birthday,phone_number,address
    from employees where user_id = ?