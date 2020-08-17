create TYPE  users_type as Enum('company', 'employee');
drop table if exists post_skill;
drop table if exists cvs;
drop table if exists posts;
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
create table logo(
    id serial primary key ,
    user_id char(32) unique not null ,
    logo_path  text,
    foreign key (user_id) references users (id) on delete cascade
);
create table  skills(
    id serial primary key ,
    skill_name varchar (30)
);

create  table levels(
    id serial primary key ,
    level_name varchar (30)
);
create  table job_types(
    id serial primary key ,
    type_name varchar (30)
);



create table post_level(
    post_id int references posts(id) on delete cascade ,
    level_id int references levels(id) on delete cascade
);


create table companies(
    id  serial primary key ,
    user_id char(32) unique not null ,
    domain_name varchar(100),
    phone_number char(12) check ( phone_number like '+374%'),
    company_name int not null,
    logo_id int unique ,
    foreign key (user_id) references users(id) on delete cascade
);
create table posts(
    id          serial primary key,
    user_id     char(32)  not null,
    description text not null,
    deadline date not null,
    jobType_id int references job_types(id) on delete set null,
    skill_id int references job_types(id) on delete set null,
    foreign key (user_id) references companies (user_id) on delete cascade
);
Update employees set address=? where user_id=?;
select u.id ,u.type, concat( e.first_name ,c.company_name) as name from users u
    left join employees e on u.id = e.user_id
    left join companies c on u.id = c.user_id
    where u.email = ? and u.password = ?;

    select first_name,last_name,birthday,phone_number,address
    from employees where user_id = ?;

select skill_name from skills;
select company_name from companies;
select first_name,last_name,birthday,phone_number,address ,cv_path,img_path
       from employees e
            left join cvs c on e.user_id = c.user_id
            left join imges i on e.user_id = i.user_id
                where e.user_id = ?;

select p.id, p."isDeadPost",logo_path,p.deadline,c.company_name as name ,s.skill_name as skill ,jt.type_name as type,string_agg(level_name,',/ ' ) as levels from posts p
    inner join companies c on p.user_id = c.user_id
    inner join skills s on p.skill_id = s.id
    inner join job_types jt on p.jobType_id = jt.id
    inner join logos on p.user_id = logos.user_id
    left join post_level pl on p.id = pl.post_id
    left join levels l on pl.level_id = l.id
    group by  p.id, c.company_name, logo_path,s.skill_name, jt.type_name

    having s.skill_name like ? and  c.company_name like ? and string_agg(level_name,',/' ) like ? and jt.type_name like ?;
//having s.skill_name like 'C#' and  c.company_name like 'Tech42' and string_agg(level_name,',/' ) like '%Junior%' and jt.type_name like 'Full time';

