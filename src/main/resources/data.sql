Delete From authorities;
Delete From users;

insert into users (username, password, enabled, email) values ('user1', '{noop}123', true, 'user1@domain.com');
insert into authorities (username, authority) values ('user1', 'ROLE_USER');

insert into users (username, password, enabled, email) values ('user2', '{noop}234', true, 'user2@domain.com');
insert into authorities (username, authority) values ('user2', 'ROLE_ADMIN');