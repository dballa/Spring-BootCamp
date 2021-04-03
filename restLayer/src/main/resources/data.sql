DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS subcategory;


CREATE TABLE subcategory(
 id int AUTO_INCREMENT PRIMARY KEY,
 name varchar(250) not null,
 active boolean not null
 
);

CREATE TABLE products (
  id int AUTO_INCREMENT PRIMARY KEY,
  name varchar(250) not null,
  description varchar(250),
  price integer not null,
  subcategory_id integer,
  foreign key (subcategory_id) references subcategory(id)
);

insert into subcategory(name,active) values
('Shoes',false),
('Dress',true);


INSERT INTO products (name, description, price, subcategory_id) VALUES
  ('test', '12ffgh' ,24, 1);