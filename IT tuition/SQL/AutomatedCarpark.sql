/* Creation of Database */
CREATE database AutoPark2

/* Selecting database */
USE autopark

/* Creating CompanyMaintenance */
CREATE TABLE CompanyMaintenance
(
MaintenanceID int NOT NULL,
SystemID int NOT NULL,
ErrorCodes int NOT NULL,
PRIMARY KEY (MaintenanceID)
)

/* Inserting sample Data for CompanyMaintenance table*/ 
INSERT INTO CompanyMaintenance
VALUES (5632, 2396, 9238)

/* Creating ParkingSystem */
CREATE TABLE ParkingSystem
(
SystemID int NOT NULL,
ParkingBayID varchar(255) NOT NULL,
TicketMachineID int NOT NULL,
CarPortID varchar(255),
PRIMARY KEY (SystemID)
)

/* Inserting sample data for ParkingSystem table */ 
INSERT INTO ParkingSystem
VALUES (2396, 'A36', 12, 2,)

/* Making a foregin key relationship with SystemID in ComapanyMaintenance and SystemID in ParkingSystem */
ALTER TABLE CompanyMaintenance
ADD CONSTRAINT fk_systemID
FOREIGN KEY (SystemID)
REFERENCES ParkingSystem (SystemID)

/* Creating CarStorage table */
CREATE TABLE CarStorage
(
ParkingBayID varchar(255) NOT NULL,
TicketID int NOT NULL,
LengthofStay time NOT NULL,
TimeofPark datetime NOT NULL,
TimeofRetrival datetime NOT NULL,
PRIMARY KEY (ParkingBayID)
)

/* Inserting sample data for CarStorage table */
INSERT INTO CarStorage
VALUES ('A36', 2936, '02:00:00', '2013-02-26 13:45:00', '2013-02-26 15:45:00')

/* Creating foreign key relationship with ParkingBayID in ParkingSystem table and CarStorage table */
ALTER TABLE ParkingSystem
ADD CONSTRAINT fk_parkingsystem
FOREIGN KEY (ParkingBayID)
REFERENCES CarStorage (ParkingBayID)

/* Creating payment handling table */
CREATE TABLE Payment
(
TicketID int NOT NULL,
TimeStayed TIME NOT NULL,
AmounttoPay DECIMAL NOT NULL,
PRIMARY KEY (TicketID)
)

/* Adding Sample data into Payment table */
INSERT INTO Payment
VALUES (2936, '02:00:00', '7.45')

/* Creating a foreign key relationship with TicketID in CarStorage table and Payment table */
ALTER TABLE CarStorage
ADD CONSTRAINT fk_ticketid
FOREIGN KEY (TicketID)
REFERENCES Payment (TicketID)

/* END OF SCRIPT */