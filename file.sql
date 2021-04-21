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
	passengerKT VARCHAR(10) NOT NULL,
	name VARCHAR(30),
	passportNumber VARCHAR(30) NOT NULL,
	ticketID INT,
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

INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1102, 'A02', false, false, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1103, 'A03', false, false, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1104, 'A04', false, false, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1105, 'A05', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1106, 'A06', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1107, 'A07', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1108, 'A08', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1109, 'A09', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1110, 'A10', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1111, 'A11', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1211, 'C11', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1302, 'D02', false, false, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1303, 'D03', false, false, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1304, 'D04', false, false, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1305, 'D05', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1306, 'D06', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1307, 'D07', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1308, 'D08', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1309, 'D09', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1410, 'D10', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1311, 'D11', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1402, 'F02', false, false, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1403, 'F03', false, false, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1404, 'F04', false, false, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1405, 'F05', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1406, 'F06', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1407, 'F07', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1408, 'F08', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1409, 'F09', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1410, 'F10', false, true, 1, 'FL101', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (1411, 'F11', false, true, 1, 'FL101', null);

INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2102, 'A02', false, false, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2103, 'A03', false, false, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2104, 'A04', false, false, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2105, 'A05', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2106, 'A06', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2107, 'A07', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2108, 'A08', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2109, 'A09', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2110, 'A10', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2111, 'A11', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2211, 'C11', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2302, 'D02', false, false, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2303, 'D03', false, false, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2304, 'D04', false, false, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2305, 'D05', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2306, 'D06', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2307, 'D07', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2308, 'D08', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2309, 'D09', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2310, 'D10', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2311, 'D11', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2402, 'F02', false, false, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2403, 'F03', false, false, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2404, 'F04', false, false, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2405, 'F05', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2406, 'F06', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2407, 'F07', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2408, 'F08', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2409, 'F09', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2410, 'F10', false, true, 2, 'FL102', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (2411, 'F11', false, true, 2, 'FL102', null);

INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3102, 'A02', false, false, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3103, 'A03', false, false, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3104, 'A04', false, false, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3105, 'A05', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3106, 'A06', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3107, 'A07', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3108, 'A08', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3109, 'A09', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3110, 'A10', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3111, 'A11', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3211, 'C11', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3302, 'D02', false, false, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3303, 'D03', false, false, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3304, 'D04', false, false, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3305, 'D05', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3306, 'D06', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3307, 'D07', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3308, 'D08', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3309, 'D09', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3310, 'D10', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3311, 'D11', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3402, 'F02', false, false, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3403, 'F03', false, false, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3404, 'F04', false, false, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3405, 'F05', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3406, 'F06', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3407, 'F07', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3408, 'F08', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3409, 'F09', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3410, 'F10', false, true, 3, 'FL201', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (3411, 'F11', false, true, 3, 'FL201', null);

INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4102, 'A02', false, false, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4103, 'A03', false, false, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4104, 'A04', false, false, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4105, 'A05', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4106, 'A06', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4107, 'A07', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4108, 'A08', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4109, 'A09', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4110, 'A10', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4111, 'A11', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4211, 'C11', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4302, 'D02', false, false, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4303, 'D03', false, false, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4304, 'D04', false, false, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4305, 'D05', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4306, 'D06', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4307, 'D07', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4308, 'D08', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4309, 'D09', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4310, 'D10', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4311, 'D11', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4402, 'F02', false, false, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4403, 'F03', false, false, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4404, 'F04', false, false, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4405, 'F05', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4406, 'F06', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4407, 'F07', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4408, 'F08', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4409, 'F09', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4410, 'F10', false, true, 4, 'FL202', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (4411, 'F11', false, true, 4, 'FL202', null);

INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5102, 'A02', false, false, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5103, 'A03', false, false, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5104, 'A04', false, false, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5105, 'A05', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5106, 'A06', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5107, 'A07', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5108, 'A08', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5109, 'A09', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5110, 'A10', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5111, 'A11', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5211, 'C11', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5302, 'D02', false, false, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5303, 'D03', false, false, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5304, 'D04', false, false, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5305, 'D05', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5306, 'D06', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5307, 'D07', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5308, 'D08', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5309, 'D09', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5310, 'D10', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5311, 'D11', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5402, 'F02', false, false, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5403, 'F03', false, false, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5404, 'F04', false, false, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5405, 'F05', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5406, 'F06', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5407, 'F07', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5408, 'F08', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5409, 'F09', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5410, 'F10', false, true, 5, 'FL301', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (5411, 'F11', false, true, 5, 'FL301', null);

INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6102, 'A02', false, false, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6103, 'A03', false, false, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6104, 'A04', false, false, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6105, 'A05', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6106, 'A06', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6107, 'A07', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6108, 'A08', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6109, 'A09', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6110, 'A10', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6111, 'A11', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6211, 'C11', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6302, 'D02', false, false, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6303, 'D03', false, false, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6304, 'D04', false, false, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6305, 'D05', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6306, 'D06', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6307, 'D07', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6308, 'D08', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6309, 'D09', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6310, 'D10', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6311, 'D11', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6402, 'F02', false, false, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6403, 'F03', false, false, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6404, 'F04', false, false, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6405, 'F05', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6406, 'F06', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6407, 'F07', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6408, 'F08', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6409, 'F09', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6410, 'F10', false, true, 6, 'FL302', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (6411, 'F11', false, true, 6, 'FL302', null);

INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7102, 'A02', false, false, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7103, 'A03', false, false, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7104, 'A04', false, false, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7105, 'A05', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7106, 'A06', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7107, 'A07', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7108, 'A08', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7109, 'A09', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7110, 'A10', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7111, 'A11', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7211, 'C11', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7302, 'D02', false, false, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7303, 'D03', false, false, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7304, 'D04', false, false, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7305, 'D05', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7306, 'D06', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7307, 'D07', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7308, 'D08', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7309, 'D09', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7310, 'D10', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7311, 'D11', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7402, 'F02', false, false, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7403, 'F03', false, false, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7404, 'F04', false, false, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7405, 'F05', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7406, 'F06', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7407, 'F07', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7408, 'F08', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7409, 'F09', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7410, 'F10', false, true, 7, 'FL401', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (7411, 'F11', false, true, 7, 'FL401', null);

INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8102, 'A02', false, false, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8103, 'A03', false, false, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8104, 'A04', false, false, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8105, 'A05', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8106, 'A06', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8107, 'A07', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8108, 'A08', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8109, 'A09', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8110, 'A10', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8111, 'A11', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8211, 'C11', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8302, 'D02', false, false, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8303, 'D03', false, false, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8304, 'D04', false, false, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8305, 'D05', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8306, 'D06', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8307, 'D07', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8308, 'D08', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8309, 'D09', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8310, 'D10', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8311, 'D11', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8402, 'F02', false, false, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8403, 'F03', false, false, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8404, 'F04', false, false, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8405, 'F05', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8406, 'F06', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8407, 'F07', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8408, 'F08', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8409, 'F09', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8410, 'F10', false, true, 8, 'FL402', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (8411, 'F11', false, true, 8, 'FL402', null);

INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9102, 'A02', false, false, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9103, 'A03', false, false, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9104, 'A04', false, false, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9105, 'A05', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9106, 'A06', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9107, 'A07', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9108, 'A08', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9109, 'A09', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9110, 'A10', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9111, 'A11', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9211, 'C11', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9302, 'D02', false, false, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9303, 'D03', false, false, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9304, 'D04', false, false, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9305, 'D05', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9306, 'D06', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9307, 'D07', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9308, 'D08', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9309, 'D09', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9310, 'D10', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9311, 'D11', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9402, 'F02', false, false, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9403, 'F03', false, false, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9404, 'F04', false, false, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9405, 'F05', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9406, 'F06', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9407, 'F07', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9408, 'F08', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9409, 'F09', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9410, 'F10', false, true, 9, 'FL501', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (9411, 'F11', false, true, 9, 'FL501', null);

INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10102, 'A02', false, false, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10103, 'A03', false, false, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10104, 'A04', false, false, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10105, 'A05', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10106, 'A06', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10107, 'A07', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10108, 'A08', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10109, 'A09', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10110, 'A10', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10111, 'A11', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10211, 'C11', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10302, 'D02', false, false, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10303, 'D03', false, false, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10304, 'D04', false, false, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10305, 'D05', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10306, 'D06', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10307, 'D07', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10308, 'D08', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10309, 'D09', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10310, 'D10', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10311, 'D11', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10402, 'F02', false, false, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10403, 'F03', false, false, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10404, 'F04', false, false, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10405, 'F05', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10406, 'F06', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10407, 'F07', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10408, 'F08', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10409, 'F09', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10410, 'F10', false, true, 10, 'FL502', null);
INSERT INTO Seats (seatID, seatNumber, seatOccupation, seatEconomy, flightID, flightNumber, ticketID) VALUES (10411, 'F11', false, true, 10, 'FL502', null);
