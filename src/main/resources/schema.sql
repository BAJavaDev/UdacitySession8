CREATE TABLE IF NOT EXISTS USERS (
  userid INT PRIMARY KEY auto_increment,
  username VARCHAR(20) UNIQUE,
  salt VARCHAR,
  password VARCHAR,
  firstname VARCHAR(20),
  lastname VARCHAR(20)
);
