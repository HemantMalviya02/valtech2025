--insert into publisher(id, name) values (nextval('pub_seq'),'Oreilly');
--insert into publisher(id, name) values (nextval('pub_seq'),'Tata Mcgraw Hill');
--insert into publisher(id, name) values (nextval('pub_seq'),'Pigeon');

--insert into book (id, name, price, year, publisher_id) values (nextval('book_seq'), 'The Complete Reference - Java', 120, 1997, 2);
--insert into book (id, name, price, year, publisher_id) values (nextval('book_seq'), 'Anxious People', 100, 2001, 2);
--insert into book (id, name, price, year, publisher_id) values (nextval('book_seq'), 'Kite Runner', 90, 2004, 2);
--insert into book (id, name, price, year, publisher_id) values (nextval('book_seq'), 'J2ee Best Practices', 300, 2001, 1);
--insert into book (id, name, price, year, publisher_id) values (nextval('book_seq'), 'The Spring Framework', 250, 1997, 1);
--insert into book (id, name, price, year, publisher_id) values (nextval('book_seq'), 'Hibernate Workbook', 100, 2003, 2);

--insert into author (id, name, address) values (nextval('author_seq'), 'Rod Johnson', 'Europe');
--insert into author (id, name, address) values (nextval('author_seq'), 'Jurgeon Holler', 'Europe');
--insert into author (id, name, address) values (nextval('author_seq'), 'James Goshling', 'US');
--insert into author (id, name, address) values (nextval('author_seq'), 'Gavin King', 'US');
--insert into author (id, name, address) values (nextval('author_seq'), 'Fedrick Backman', 'Australia');
--insert into author (id, name, address) values (nextval('author_seq'), 'Khalid Hosseini', 'Australia');

--insert into book_author(book_id, author_id) values(1,3);
--insert into book_author(book_id, author_id) values(2,5);
--insert into book_author(book_id, author_id) values(3,6);
--insert into book_author(book_id, author_id) values(4,1);
--insert into book_author(book_id, author_id) values(4,2);
--insert into book_author(book_id, author_id) values(5,1);
--insert into book_author(book_id, author_id) values(5,2);
--insert into book_author(book_id, author_id) values(6,4);
