create TYPE  users_type as Enum('company', 'employee');
drop table if exists employees_skills;
drop table if exists employees_skills;
drop table if exists cvs;
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
                    cv_path  text,
                    foreign key (user_id) references users (id) on delete cascade
);

create table img(
                    id serial primary key ,
                    user_id char(32) unique not null ,
                    img_path  text,
                    foreign key (user_id) references users (id) on delete cascade
);
create table  skills(
    id serial primary key ,
    skills_name varchar (30)
);

create table employee_skills(
    user_id char(32) references employees(user_id) on delete cascade ,
    skills_id int references skills(id) on delete cascade
);
create  table levels(
  int serial primary key ,
  level_name varchar (30)
);
create  table job_types(
    int serial primary key ,
    type_name varchar (30)
);

create table companies(
    id  serial primary key ,
    user_id char(32) unique not null ,
    domain_name varchar(100),
    phone_number char(12) check ( phone_number like '+374%'),
    company_name int not null,
    foreign key (user_id) references users(id) on delete cascade
);
Update employees set address=? where user_id=?;
select u.id ,u.type, concat( e.first_name ,c.company_name) as name from users u
    left join employees e on u.id = e.user_id
    left join companies c on u.id = c.user_id
    where u.email = ? and u.password = ?;

    select first_name,last_name,birthday,phone_number,address
    from employees where user_id = ?;

select skill_name from skills;
    alter table skills rename  column skills_name to skill_name;
select company_name from companies;
select first_name,last_name,birthday,phone_number,address ,cv_path,img_path
       from employees e
            inner join cvs c on e.user_id = c.user_id
            inner join imges i on e.user_id = i.user_id
                where e.user_id = ?;