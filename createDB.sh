#!bin/sh
echo "Create database 'NotesWeb'"
echo -n "Username: "
read username
echo -n "Password: "
read -s password
echo
mysql -u $username -p$password -e "
CREATE DATABASE NotesWeb DEFAULT CHARACTER SET 'utf8' DEFAULT COLLATE 'utf8_unicode_ci';
USE NotesWeb;
CREATE TABLE Users
(
    USER_ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username VARCHAR(12) NOT NULL,
    password VARCHAR(16) NOT NULL
);
CREATE UNIQUE INDEX username ON Users (username);
CREATE TABLE Notes
(
    id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    USER_ID BIGINT(20) NOT NULL,
    title VARCHAR(25) NOT NULL,
    text VARCHAR(255) NOT NULL,
    CONSTRAINT FK47F5EA160804239 FOREIGN KEY (USER_ID) REFERENCES Users (USER_ID)
);
CREATE INDEX FK47F5EA160804239 ON Notes (USER_ID);"