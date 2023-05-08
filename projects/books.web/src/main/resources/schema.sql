drop table if exists MESSAGES
drop table if exists STORE
create table MESSAGES (message varchar(128))
create table STORE (category varchar(20), item varchar(20), stock integer, primary key (category, item))