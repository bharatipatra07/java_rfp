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
('Amit', 'Kumar', 'MG Road', 'Bangalore', 'Karnataka', '560001', '9876543210', 'amit.kumar@gmail.com'),
('Riya', 'Sharma', 'Park Street', 'Kolkata', 'West Bengal', '700016', '9123456780', 'riya.sharma@gmail.com');

-- Add address book name and type columns
ALTER TABLE address_book
ADD address_book_name VARCHAR(50) NOT NULL,
ADD address_book_type VARCHAR(30) NOT NULL;

UPDATE address_book
SET address_book_name = 'Personal',
    address_book_type = 'Family'
WHERE first_name = 'Amit'
  AND last_name = 'Kumar';

UPDATE address_book
SET address_book_name = 'Office',
    address_book_type = 'Profession'
WHERE first_name = 'Riya'
  AND last_name = 'Sharma';
 
SELECT * FROM address_book;




