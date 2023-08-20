insert into course(id, name) values(10001, 'JPA in 50 Steps');
insert into course(id, name) values(10002, 'Databases in 50 Steps');
insert into course(id, name) values(10003, 'AWS in 50 Steps');

insert into passport(id, number) values(3001, '111');
insert into passport(id, number) values(3002, '222');
insert into passport(id, number) values(3003, '333');

insert into student(id, name, passport_id) values(2001, 'Vitor', 3001);
insert into student(id, name, passport_id) values(2002, 'Yasha', 3002);
insert into student(id, name, passport_id) values(2003, 'Caleb', 3003);

insert into review(id, rating, description) values (4001, '5', 'Great Course');
insert into review(id, rating, description) values (4002, '1', 'Garbage');
insert into review(id, rating, description) values (4003, '4', 'Good');

insert into course(id, name) values(666, 'test course');
insert into passport(id, number) values(999, 'test passport');
insert into student(id, name, passport_id) values(333, 'test student', 999);
insert into review(id, rating, description) values (777, '5', 'test review');