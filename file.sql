DROP TABLE if exists Bookings;
DROP TABLE if exists Tickets;
DROP TABLE if exists Flights;
DROP TABLE if exists Seats;
DROP TABLE if exists Passengers;

CREATE Table Bookings(
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
	departureTime LOCALDATETIME,
	arrivalTime LOCALDATETIME,
	flightTime DOUBLE,
	priceFirstClass DOUBLE,
	priceEconomy DOUBLE,
	PRIMARY KEY(flightID, flightNumber)
);

CREATE Table Seats(
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

CREATE Table Passengers(
	passengerID INT NOT NULL,
	name STRING,
	passportNumber STRING NOT NULL,
	ticketID INT,
	PRIMARY KEY(passengerID, passportNumber),
	FOREIGN KEY(ticketID) REFERENCES Tickets(ticketID)
);