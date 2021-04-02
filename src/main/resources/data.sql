DROP TABLE IF EXISTS subject;
DROP TABLE IF EXISTS professor;


create table professor
(
    id INT AUTO_INCREMENT  PRIMARY KEY,
    first_name character varying(120) not null,
    last_name character varying(120) not null
);

create table subject
(
    id INT AUTO_INCREMENT  PRIMARY KEY,
    professor_id integer not null,
    active boolean not null,
    name character varying(100) not null,
    credits_cfu numeric not null,
    semester integer,
    total_hours numeric,
    foreign key (professor_id) references professor(id)
);



INSERT INTO professor (first_name, last_name) VALUES
('Aliko', 'Dangote'),
('Bill', 'Gates'),
('Folrunsho', 'Alakija');


insert into subject(professor_id,active, name, credits_cfu, semester, total_hours) values
(1,true,'Algoritmike',5,1,15),
(1,false,'Programim',5,2,15);
