Create table Employee (
	EmployeeId Serial Primary Key,
	LastName Varchar(255),
	Firstname varchar(255),
	Address varchar(255),
	City varchar(255)
);

INSERT INTO public.employee(
	employeeid, lastname, firstname, address, city)
	VALUES (?, ?, ?, ?, ?);