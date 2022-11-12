drop database if exists recognition;
create database recognition default character set utf8 collate utf8_general_ci;
grant all on recognition.* to 'staff'@'localhost' identified by 'password';
use recognition;

CREATE TABLE focus /*查看*/
(
    id int AUTO_INCREMENT PRIMARY KEY,/*編號*/
    people varchar(255) not null,/*人數*/
    time varchar(255) not null/*時間*/
);

