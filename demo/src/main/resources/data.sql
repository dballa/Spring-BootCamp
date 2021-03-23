DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  age int DEFAULT NULL
);

INSERT INTO users (first_name, last_name, age) VALUES
  ('Aliko', 'Dangote', 20),
  ('Bill', 'Gates', 30),
  ('Folrunsho', 'Alakija', 40);