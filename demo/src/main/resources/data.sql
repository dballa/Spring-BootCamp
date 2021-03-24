DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS subscriptions;

CREATE TABLE subscriptions(
 id int AUTO_INCREMENT PRIMARY KEY,
 name varchar(250) not null,
 active boolean not null
 
);



CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  age int NOT NULL,
  subscriptionId int,
  foreign key (subscriptionId) references subscriptions(id)
);

insert into subscriptions(name,active) values
('Subtest',false),
('Subtest2',true);


INSERT INTO users (first_name, last_name, age,subscriptionId) VALUES
  ('Aliko', 'Dangote', 10,1),
  ('Bill', 'Gates', 30,1),
  ('Folrunsho', 'Alakija', 40,1);