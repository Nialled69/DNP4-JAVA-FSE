CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    FullName VARCHAR2(100),
    Age INT,
    Balance NUMBER(10,2),
    IsVIP CHAR(1) DEFAULT 'N'
);

CREATE TABLE Loans (
    LoanID INT PRIMARY KEY,
    CustomerID INT REFERENCES Customers(CustomerID),
    InterestRate NUMBER(5,2),
    DueDate DATE
);
 

-- inserting dummy data 

INSERT INTO Customers VALUES (1, 'John Doe', 65, 12000, 'N');
INSERT INTO Customers VALUES (2, 'Jane Smith', 45, 9000, 'N');
INSERT INTO Customers VALUES (3, 'Alice Brown', 70, 15000, 'N');

INSERT INTO Loans VALUES (101, 1, 5.5, SYSDATE + 20);
INSERT INTO Loans VALUES (102, 2, 6.0, SYSDATE + 40);
INSERT INTO Loans VALUES (103, 3, 7.0, SYSDATE + 10);
COMMIT;