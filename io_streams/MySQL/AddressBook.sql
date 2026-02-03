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
('Suresh', 'Naik', 'Beach Road', 'Goa', 'Goa', '403001', '9988776655', 'suresh.naik@gmail.com'),
('Amit', 'Kumar', 'MG Road', 'Bangalore', 'Karnataka', '560001', '9876543210', 'amit.kumar@gmail.com'),
('Riya', 'Sharma', 'Park Street', 'Kolkata', 'West Bengal', '700016', '9123456780', 'riya.sharma@gmail.com');

-- Sort alphabetically by first name, then last name
SELECT *
FROM address_book
WHERE city = 'Bangalore'
ORDER BY first_name ASC, last_name ASC;


