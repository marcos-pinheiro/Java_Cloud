CREATE TABLE dog (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(60),
	rg VARCHAR(60)
);

CREATE TABLE vaccine (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(60),
	vaccine_date DATE,
	dog_id INTEGER NOT NULL,
	CONSTRAINT FK_VACCINE__DOG FOREIGN KEY(dog_id) REFERENCES dog (id)
);