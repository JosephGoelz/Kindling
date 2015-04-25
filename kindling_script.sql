DROP DATABASE if exists bindling;
CREATE DATABASE bindling;
USE bindling;

CREATE TABLE users
(
userId int(8) primary key not null auto_increment,
gender int not null,
sexualOrientation int not null,
name varchar(255),
username varchar(255),
location varchar(255),
password varchar(255) not null,
age int not null,
intelligence int not null,
City varchar(255)
);


INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (1, 0, 'Barbara',
'BMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (1, 0, 'Chelsea',
'CMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (1, 0, 'Danica',
'DMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (1, 0, 'Elanor',
'EMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (1, 0, 'Fannie',
'FMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (1, 0, 'Georgia',
'GMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (1, 0, 'Hillary',
'HMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (1, 0, 'Ilsa',
'IMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (1, 1, 'Janice',
'JMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (1, 1, 'Kathy',
'KMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (0, 1, 'Lenny',
'LMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (0, 1, 'Maurice',
'MMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (0, 1, 'Ned',
'NMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (0, 1, 'Oscar',
'OMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (0, 1, 'Philip',
'PMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (0, 1, 'Quinn',
'QMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (0, 1, 'Red',
'RMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (0, 1, 'Samuel',
'SMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (0, 0, 'Theo',
'TMoney', 'Tibet', 'password', 21, 50, 'Lhasa');

INSERT INTO users (gender, sexualOrientation, name, username,
location, password, age, intelligence, city) VALUES (0, 0, 'Ulyses',
'UMoney', 'Tibet', 'password', 21, 50, 'Lhasa');