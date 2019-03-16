Drop Table IF EXISTS authorities;
Drop Table IF EXISTS USERS;

CREATE TABLE IF NOT EXISTS USERS(username VARCHAR(255) PRIMARY KEY, password VARCHAR(255), enabled BOOLEAN, email VARCHAR(255));
CREATE TABLE IF NOT EXISTS authorities(username VARCHAR(255), authority  VARCHAR(255), foreign key (username) references users(username));
