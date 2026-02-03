-- Create Address Book database
CREATE DATABASE address_book_service;

-- Show all databases
SHOW DATABASES;

-- Use the Address Book database
USE address_book_service;

CREATE TABLE person (
    person_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    address VARCHAR(200),
    city VARCHAR(50),
    state VARCHAR(50),
    zip VARCHAR(10),
    phone_number VARCHAR(15),
    email VARCHAR(100)
);

CREATE TABLE address_book_type (
    type_id INT AUTO_INCREMENT PRIMARY KEY,
    type_name VARCHAR(30) UNIQUE
);

INSERT INTO address_book_type (type_name)
VALUES ('Family'), ('Friends'), ('Profession');

CREATE TABLE person_address_book (
    person_id INT,
    type_id INT,
    PRIMARY KEY (person_id, type_id),
    FOREIGN KEY (person_id) REFERENCES person(person_id),
    FOREIGN KEY (type_id) REFERENCES address_book_type(type_id)
);

INSERT INTO person
(first_name, last_name, city, state, phone_number, email)
VALUES
('Riya', 'Sharma', 'Bangalore', 'Karnataka', '9876543210', 'riya@gmail.com');

-- Add Riya as Family
INSERT INTO person_address_book (person_id, type_id)
VALUES (1, 1);

-- Add Riya as Friend
INSERT INTO person_address_book (person_id, type_id)
VALUES (1, 2);

SELECT p.first_name, p.last_name, t.type_name
FROM person p
JOIN person_address_book pa ON p.person_id = pa.person_id
JOIN address_book_type t ON pa.type_id = t.type_id;
