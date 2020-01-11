Create Table Invoice_header(
	Invoice_ID serial Primary key,
	Invoice_to varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	subtotal real NOT NULL,
	discount real NOT Null,
	total real NOT NULL
);

Create table Invoice_details(
	detail_id serial primary key,
	Invoice_ID serial,
	Product_name varchar(50) NOT NULL,
	qty integer NOT NULL,
	total_price real ,
	FOREIGN KEY (Invoice_ID) REFERENCES invoice_header(Invoice_ID)
);