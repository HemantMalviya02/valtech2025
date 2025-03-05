create table publisher(
	id int primary key,
	name varchar(30)
);

create sequence pub_seq start with 1;

create table book(
	id int primary key,
	name varchar(30),
	price int, 
	year int,
	publisher_id int references publisher(id)
);

create sequence book_seq start with 1;

create table author(
	id int primary key,
	name varchar(30),
	address varchar(100)
);

create sequence author_seq start with 1;

create table book_author(
	book_id int not null references book(id),
	author_id int not null references author(id),
	primary key(book_id, author_id)
);