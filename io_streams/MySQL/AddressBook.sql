-- Use existing Address Book Service database
USE address_book_service;

-- Create Address Book table
CREATE TABLE address_book (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    address VARCHAR(200) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    zip VARCHAR(10) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);
INSERT INTO address_book
(first_name, last_name, address, city, state, zip, phone_number, email)
VALUES
('Anita', 'Patel', 'Ring Road', 'Ahmedabad', 'Gujarat', '380001', '9123456789', 'anita.patel@gmail.com'),
('Suresh', 'Naik', 'Beach Road', 'Goa', 'Goa', '403001', '9988776655', 'suresh.naik@gmail.com');

-- Delete a contact from address_book
DELETE FROM address_book
WHERE first_name = 'Rahul'
  AND last_name = 'Verma';

-- View records
SELECT * FROM address_book;
