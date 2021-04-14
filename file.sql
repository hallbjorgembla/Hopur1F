CREATE DATABASE flightSearchDB;

DROP TABLE if exists Bookings;
DROP TABLE if exists Tickets;
DROP TABLE if exists Flights;
DROP TABLE if exists Seats;
DROP TABLE if exists Passengers;

CREATE TABLE Bookings(
	bookingID INT NOT NULL PRIMARY KEY
);

CREATE Table Tickets(
	ticketID INT NOT NULL PRIMARY KEY,
	bookingID INT,
	FOREIGN KEY(bookingID) REFERENCES Bookings(bookingID)
);

CREATE Table Flights(
	flightID INT NOT NULL,
	flightNumber VARCHAR(30) NOT NULL,
	flightDeparture VARCHAR(30),
	flightDestination VARCHAR(30),
	departureTime DATETIME,
	arrivalTime DATETIME,
	flightTime DOUBLE,
	priceFirstClass DOUBLE,
	priceEconomy DOUBLE,
	numberOfSeats INT,
	PRIMARY KEY(flightID, flightNumber)
);

CREATE TABLE Seats(
	seatID INT NOT NULL,
	seatNumber VARCHAR(30) NOT NULL,
	seatOccupation BOOLEAN,
	seatEconomy BOOLEAN,
	flightID INT,
	flightNumber VARCHAR(30),
	ticketID INT,
	PRIMARY KEY(seatID, seatNumber),
	FOREIGN KEY(flightID, flightNumber) REFERENCES Flights(flightID, flightNumber),
	FOREIGN KEY(ticketID) REFERENCES Tickets(ticketID)
);

CREATE TABLE Passengers(
	passengerID INT NOT NULL,
	name VARCHAR(30),
	passportNumber VARCHAR(30) NOT NULL,
	ticketID INT,
	PRIMARY KEY(passengerID, passportNumber),
	FOREIGN KEY(ticketID) REFERENCES Tickets(ticketID)
);

INSERT INTO Flights(flightID, flightNumber, flightDeparture, flightDestination, departureTime, arrivalTime, flightTime, priceFirstClass, priceEconomy, numberOfSeats) VALUES(1, 'FL101', 'Reykjavík','Akureyri','2021-06-01 06:00:00','2021-06-01 06:45:00', 0.75, 17500, 7500, 128);
INSERT INTO Flights(flightID, flightNumber, flightDeparture, flightDestination, departureTime, arrivalTime, flightTime, priceFirstClass, priceEconomy, numberOfSeats) VALUES(2, 'FL102', 'Akureyri','Reykjavík','2021-06-01 20:00:00','2021-06-01 20:45:00', 0.75, 17500, 7500, 128);
INSERT INTO Flights(flightID, flightNumber, flightDeparture, flightDestination, departureTime, arrivalTime, flightTime, priceFirstClass, priceEconomy, numberOfSeats) VALUES(3, 'FL201', 'Reykjavík','Egilsstaðir','2021-06-02 08:00:00','2021-06-01 09:00:00', 1.0, 25000, 15000, 128);
INSERT INTO Flights(flightID, flightNumber, flightDeparture, flightDestination, departureTime, arrivalTime, flightTime, priceFirstClass, priceEconomy, numberOfSeats) VALUES(4, 'FL202', 'Egilsstaðir','Reykjavík','2021-06-02 18:00:00','2021-06-01 19:00:00', 1.0, 25000, 15000, 128);
INSERT INTO Flights(flightID, flightNumber, flightDeparture, flightDestination, departureTime, arrivalTime, flightTime, priceFirstClass, priceEconomy, numberOfSeats) VALUES(5, 'FL301', 'Reykjavík','Gjögur','2021-06-01 07:00:00','2021-06-01 07:40:00', 0.67, 39500, 29500, 128);
INSERT INTO Flights(flightID, flightNumber, flightDeparture, flightDestination, departureTime, arrivalTime, flightTime, priceFirstClass, priceEconomy, numberOfSeats) VALUES(6, 'FL302', 'Gjögur','Reykjavík','2021-06-01 21:00:00','2021-06-01 21:40:00', 0.67, 39500, 29500, 128);
INSERT INTO Flights(flightID, flightNumber, flightDeparture, flightDestination, departureTime, arrivalTime, flightTime, priceFirstClass, priceEconomy, numberOfSeats) VALUES(7, 'FL401', 'Akureyri','Egilsstaðir','2021-06-01 10:00:00','2021-06-01 10:30:00', 0.5, 18500, 8500, 128);
INSERT INTO Flights(flightID, flightNumber, flightDeparture, flightDestination, departureTime, arrivalTime, flightTime, priceFirstClass, priceEconomy, numberOfSeats) VALUES(8, 'FL402', 'Egilsstaðir','Akureyri','2021-06-01 22:00:00','2021-06-01 22:30:00', 0.5, 18500, 8500, 128);
INSERT INTO Flights(flightID, flightNumber, flightDeparture, flightDestination, departureTime, arrivalTime, flightTime, priceFirstClass, priceEconomy, numberOfSeats) VALUES(9, 'FL501', 'Reykjavík','Ísafjörður','2021-06-01 09:00:00','2021-06-01 09:40:00', 0.67, 20500, 10500, 128);
INSERT INTO Flights(flightID, flightNumber, flightDeparture, flightDestination, departureTime, arrivalTime, flightTime, priceFirstClass, priceEconomy, numberOfSeats) VALUES(10, 'FL502', 'Ísafjörður','Reykjavík','2021-06-01 21:00:00','2021-06-01 21:40:00', 0.67, 20500, 10500, 128);
