drop table BORROWER if exists;
create table BORROWER (id bigint PRIMARY KEY, name varchar(20) NOT NULL,address varchar(500) NOT NULL,contact varchar(10) NOT NULL);

drop table LOAN if exists;
create table LOAN (id bigint PRIMARY KEY, loan_number varchar(20) NOT NULL,loan_amount DECIMAL(10,2) NOT NULL,interest_rate DECIMAL(2,2) NOT NULL, borrower_id bigint );