drop database if exists airport;
create database airport default character set utf8 collate utf8_general_ci;
grant all on airport.* to 'staff'@'localhost' identified by 'password';
use airport;
CREATE TABLE air /*機場*/
(
    id int AUTO_INCREMENT PRIMARY KEY, 
    aid varchar(255) not null,/*機場代碼*/
    aname varchar(255) not null,/*機場名稱*/
    city varchar(255) not null,/*機場所在城市*/
    country varchar(255) not null,/*機場所在國家*/
    address varchar(255) not null,
    phone varchar(255) not null
);

create TABLE hangar/*機棚*/
(
    id int AUTO_INCREMENT PRIMARY KEY,
    mid INT(255) not null,/*機型代碼*/
    hid INT(255) not null/*機棚代碼*/
);

create TABLE modal/*機型*/
(
    id int AUTO_INCREMENT PRIMARY KEY,
    mid VARCHAR(255) not null,/*機型代碼*/
    company varchar(255) not null,/*製造公司*/
    fdate varchar(255) not null/*航班日期*/
);

CREATE Table class/*艙等*/
(
    id int AUTO_INCREMENT PRIMARY KEY,
    mid varchar(255) not null,/*機型代碼*/
    math INT(255) not null,/*位置數*/
    cid varchar(255) not null/*倉等代號*/
);

CREATE TABLE flight/*航班*/
(
    id int AUTO_INCREMENT PRIMARY KEY,
    fdate varchar(255) not null,/*航班日期*/
    fid varchar(255) not null,/*航班編號*/
    mid VARCHAR(255) not null,/*機型代碼*/
    ftime varchar(255) not null,/*起飛時間*/
    dtime varchar(255) not null/*降落時間*/
);

CREATE TABLE route/*航線*/
(
    id int AUTO_INCREMENT PRIMARY KEY,
    fid varchar(255) not null,/*航班編號*/
    sair varchar(255) not null,/*起飛機場*/
    dair varchar(255) not null,/*降落機場*/
    rtime VARCHAR(255) not null/*飛行時間*/
);

CREATE TABLE client/*客戶*/
(
    id int AUTO_INCREMENT PRIMARY KEY,
    cid varchar(255) not null,/*身分證號*/
    name varchar(255) not null,/*姓名*/
    phone varchar(255) not null,/*電話*/
    pay varchar(255) not null,/*付款方式*/
    country varchar(255) not null,/*國籍*/
    birthday varchar(255) not null/*生日*/
);

create Table detail/*訂位細項*/
(
    id int AUTO_INCREMENT PRIMARY KEY,
    serial varchar(255) not null,/*流水號*/
    cid varchar(255) not null,/*身分證號*/
    did varchar(255) not null,/*訂位代號*/
    fdate varchar(255) not null/*航班日期*/
);

create Table book/*訂位*/
(
    id int AUTO_INCREMENT PRIMARY KEY,
    did varchar(255) not null,/*訂位代號*/
    sair varchar(255) not null,/*起飛機場*/
    dair varchar(255) not null,/*降落機場*/
    fdate varchar(255) not null,/*航班日期*/
    people varchar(255) not null,/*人數*/
    time varchar(255) not null/*訂單時間*/
);

create Table ticket/*機票*/
(
    id int AUTO_INCREMENT PRIMARY KEY,
    tid  varchar(255) not null,/*票號*/
    serial varchar(255) not null,/*流水號*/
    fid varchar(255) not null,/*航班編號*/
    stime varchar(255) not null,/*起飛時間*/
    dtime varchar(255) not null/*降落時間*/
);

CREATE TABLE special/*特別優惠*/
(
    id int AUTO_INCREMENT PRIMARY KEY,
    sair varchar(255) not null,/*起飛機場*/
    dair varchar(255) not null,/*降落機場*/
    money VARCHAR(255) not null/*價格*/
);

create Table seat/*畫位*/
(
    id int AUTO_INCREMENT PRIMARY KEY,
    tid  varchar(255) not null,/*票號*/
    cid varchar(255) not null,/*身分證號*/
    fit varchar(255) not null,/*座號*/
    time varchar(255) not null/*訂單時間*/
);