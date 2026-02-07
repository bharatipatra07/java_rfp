-- UC1: Create Address Book Service Database
CREATE DATABASE AddressBookService;
USE AddressBookService;

-- UC2: Create AddressBook table to store contacts
CREATE TABLE AddressBook (
    ContactId INT AUTO_INCREMENT PRIMARY KEY,   
    FirstName VARCHAR(50) NOT NULL,             
    LastName VARCHAR(50) NOT NULL,               
    PhoneNumber VARCHAR(15) NOT NULL,            
    Address VARCHAR(200),
    City VARCHAR(50),
    State VARCHAR(50),
    ZipCode VARCHAR(10),
    CreatedAt DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- UC3: Insert sample contacts into AddressBook
INSERT INTO AddressBook
(FirstName, LastName, PhoneNumber, Email, Address, City, State, ZipCode)
VALUES
('Kishor', 'Kumar', '9876543210', 'kishor@gmail.com', 'MG Road', 'Bangalore', 'Karnataka', '560001'),
('Amit', 'Sharma', '9123456780', 'amit@gmail.com', 'Park Street', 'Kolkata', 'West Bengal', '700016');

SELECT * FROM AddressBook;

-- UC4: Update contact details using first name
UPDATE AddressBook
SET
    PhoneNumber = '9999999999',
    Email = 'kishor.updated@gmail.com',
    City = 'Hyderabad'
WHERE FirstName = 'Kishor';

-- UC5: Delete contact using first name
DELETE FROM AddressBook
WHERE FirstName = 'Amit';

