DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS book_category;

CREATE TABLE category(
 id int AUTO_INCREMENT PRIMARY KEY,
 name varchar(250) not null,
 active boolean not null
 
);

CREATE TABLE book (
  id int AUTO_INCREMENT PRIMARY KEY,
  isbn varchar(250) UNIQUE not null,
  title varchar(250) not null,
  description varchar(250) not null,
  number_of_pages integer not null,
  publisher varchar(250) not null,
  edition integer not null,
  category_id integer,
  foreign key (category_id) references category(id)
);

insert into category(name,active) values
('Mystery',false),
('Action',true);


INSERT INTO book (isbn, title, description, number_of_pages, publisher, edition, category_id) VALUES
  ('123test', 'java core', 'a guide to java','1000','oracle',9,1);