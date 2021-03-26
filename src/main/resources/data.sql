DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS publisher;

CREATE TABLE publisher(
 id int AUTO_INCREMENT PRIMARY KEY,
 name varchar(250) not null,
 address varchar(250) not null
 
);



CREATE TABLE book (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  price int NOT NULL,
  rate int NOT NULL,
  publisher_id int,
  foreign key (publisher_id) references publisher(id)
);

insert into publisher(name,address) values
('Albas','Tirane'),
('Lulet e Veres','Korce');


INSERT INTO book (name, price, rate,publisher_id) VALUES
  ('Don Kishoti', 20, 20 ,1),
  ('Krim dhe Ndershkim', 50, 15,1),
  ('Qyteti i Vogel', 100, 35,1);