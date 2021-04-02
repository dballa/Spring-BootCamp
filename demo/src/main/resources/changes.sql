CREATE schema uniman;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

CREATE TABLE uniman.roles(
 id int AUTO_INCREMENT PRIMARY KEY,
 name varchar(50) not null 
);


CREATE TABLE uniman.users (
  id int AUTO_INCREMENT  PRIMARY KEY,
  first_name character varying(120) not null,
  last_name character varying(120) not null,
  birthdate timestamp without time zone not null,
  gender character varying(10),
  birth_place character varying(50),
  address character varying(520),
  telephone character varying(20),
  email character varying(100),
  personal_no character varying(20),
  username character varying(20) not null,
  password character varying(50) not null,
  enabled boolean,
  foreign key (role_id) references roles(id)
);

insert into roles(name) values
('Student'),
('Professor'),
('Coordinator'),
('Administrator');


INSERT INTO users (first_name, last_name, birthdate, username, password, role_id) VALUES
  ('Ervin', 'Rakipi', 1985-10-19 10:23:54,'Ervin','Rakipi', 1),
  ('Alex', 'Rakipi', 2010-10-19 10:23:54, 'Alex','Rakipi',2),
  ('Maria', 'Rakipi', 1990-10-19 10:23:54, 'Maria','Rakipi',3),
  ('Armando', 'Rakipi', 2005-10-19 10:23:54, 'Armando','Rakipi',4);