
--Tabela Aeroplan
CREATE TABLE Aeroplan(
aeroplan_id INT Primary Key, 
aeroplan_nr VARCHAR(50) NOT NULL,
kapaciteti INT NOT NULL,
kompania VARCHAR(100) NOT NULL,
vitprodhimi DATETIME NOT NULL,
klas int,
CONSTRAINT fk_klas FOREIGN KEY (klas) REFERENCES Klas(klas_id)
);

--Tabela Klas
CREATE TABLE Klas(
klas_id INT Primary Key, 
emertim VARCHAR(32) NOT NULL,
pershkrim VARCHAR(255) NOT NULL
);

--Tabela Itinerar
CREATE TABLE Itinerar(
itinerar_id INT Primary Key,
aeroport VARCHAR(50) NOT NULL,
destinacion VARCHAR(50) NOT NULL,
kodItinerari VARCHAR(50) NOT NULL UNIQUE
);


--Tabela Bilete
CREATE TABLE Bilete(
bilete_id INT,
itinerari INT,
sherbimi INT NOT NULL,
PRIMARY KEY (bilete_id),
CONSTRAINT fk_itinerari FOREIGN KEY (itinerari) REFERENCES Itinerar(itinerar_id)
); 
--Tabela Tarife
CREATE TABLE Tarife(
tarife_id INT PRIMARY KEY,
emertimi VARCHAR(16) NOT NULL,
total INT NOT NULL,
peshkrim VARCHAR(255) NOT NULL
);


-- Tabela ProgramiFluturimit
CREATE TABLE ProgramiFluturimit(
pf_id INT,
emertimi VARCHAR(16) NOT NULL,
dateNisje DATETIME NOT NULL,
dateMberritje DATETIME NOT NULL,
aeroplan INT,
bilete INT,
PRIMARY KEY (pf_id),
CONSTRAINT fk_aeroplan FOREIGN KEY (aeroplan) REFERENCES Aeroplan(aeroplan_id),
CONSTRAINT fk_bilete FOREIGN KEY (bilete) REFERENCES Bilete(bilete_id)
);


--Tabela Rajon
CREATE TABLE Rajon(
rajon_id INT PRIMARY KEY,
rajon_emer VARCHAR(50) NOT NULL
);


--Tabela Shtet
CREATE TABLE Shtet(
shtet_id INT ,
shtet_emer VARCHAR(50) NOT NULL,
rajon INT,
PRIMARY KEY (shtet_id),
CONSTRAINT fk_rajon FOREIGN KEY (rajon) REFERENCES Rajon(rajon_id)
);


--Tabela Kontakt
CREATE TABLE Kontakt(
kontakt_id INT PRIMARY KEY,
email VARCHAR(32) NOT NULL,
nrTel VARCHAR(32) NOT NULL,
rruga VARCHAR(50) NOT NULL,
shteti INT NOT NULL,
CONSTRAINT fk_shteti FOREIGN KEY(shteti) REFERENCES Shtet(shtet_id)
);


--Tabela Pasagjer
CREATE TABLE Pasagjer(
pasagjer_id INT PRIMARY KEY,
emri VARCHAR(50) NOT NULL,
adresa VARCHAR(64) NOT NULL,
mosha INT NOT NULL,
kombesia VARCHAR(16) NOT NULL,
kontakte INT NOT NULL,
CONSTRAINT fk_kontakte FOREIGN KEY(kontakte) REFERENCES KONTAKT(kontakt_id)
);





-- Tabela Punonjes
CREATE TABLE Punonjes(
punonjes_id INT PRIMARY KEY,
emri VARCHAR(50) NOT NULL,
adresa VARCHAR(64) NOT NULL,
email VARCHAR(32) NOT NULL,
nrTel VARCHAR(32) NOT NULL,
pozicioni INT NOT NULL,
CONSTRAINT fk_pozicioni FOREIGN KEY(pozicioni) REFERENCES PunTip(punTip_id)
);
 
--Tabela PunTip
CREATE TABLE PunTip(
	punTip_id INT PRIMARY KEY,
	emertim VARCHAR(32) NOT NULL,
	pershkrim VARCHAR(255) NOT NULL
);


--Tabela Transaksione
CREATE TABLE Transaksione(
transaksion_id INT PRIMARY KEY,
dateRezervimi DATETIME NOT NULL,
dateNisje DATETIME NOT NULL,
tipi BIT NOT NULL,
pasagjer INT,
progFluturimit INT,
punonjes INT,
tarifa INT,
CONSTRAINT fk_pasagjer FOREIGN KEY(pasagjer) REFERENCES Pasagjer(pasagjer_id),
CONSTRAINT fk_progFluturimit FOREIGN KEY(progFluturimit) REFERENCES ProgramiFluturimit(pf_id),
CONSTRAINT fk_punonjes FOREIGN KEY(punonjes) REFERENCES Punonjes(punonjes_id),
CONSTRAINT fk_tarifa FOREIGN KEY(tarifa) REFERENCES Tarife(tarife_id)
);

