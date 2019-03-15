Delete From authorities;
Delete From users;

insert into users (username, password, enabled) values ('user1', '{noop}123', true);
insert into authorities (username, authority) values ('user1', 'ROLE_USER');

insert into users (username, password, enabled) values ('user2', '{noop}234', true);
insert into authorities (username, authority) values ('user2', 'ROLE_ADMIN');