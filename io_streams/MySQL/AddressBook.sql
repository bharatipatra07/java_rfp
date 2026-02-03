-- Create Address Book database
CREATE DATABASE address_book_service;

-- Show all databases
SHOW DATABASES;

-- Use the Address Book database
USE address_book_service;

-- Create address_book table
CREATE TABLE address_book (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    address VARCHAR(200),
    city VARCHAR(50),
    state VARCHAR(50),
    zip VARCHAR(10),
    phone_number VARCHAR(15),
    email VARCHAR(100),
    PRIMARY KEY (id)
);

-- Insert sample records into address_book table
INSERT INTO address_book 
(first_name, last_name, address, city, state, zip, phone_number, email)
VALUES
('Amit', 'Kumar', 'MG Road', 'Bangalore', 'Karnataka', '560001', '9876543210', 'amit.kumar@gmail.com'),
('Riya', 'Sharma', 'Park Street', 'Kolkata', 'West Bengal', '700016', '9123456780', 'riya.sharma@gmail.com');

-- View records
SELECT * FROM address_book;
