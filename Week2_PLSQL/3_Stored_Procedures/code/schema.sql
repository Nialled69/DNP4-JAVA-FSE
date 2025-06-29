CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    customer_id NUMBER NOT NULL,
    account_type VARCHAR2(20) NOT NULL,
    balance NUMBER(10,2) DEFAULT 0.00,
    interest_rate NUMBER(5,4) DEFAULT 0.01,
    created_date DATE DEFAULT SYSDATE,
    last_updated DATE DEFAULT SYSDATE
);

CREATE TABLE employees (
    employee_id NUMBER PRIMARY KEY,
    first_name VARCHAR2(50) NOT NULL,
    last_name VARCHAR2(50) NOT NULL,
    department VARCHAR2(50) NOT NULL,
    salary NUMBER(10,2) NOT NULL,
    performance_rating NUMBER(3,1) DEFAULT 0.0,
    hire_date DATE DEFAULT SYSDATE
);

CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    first_name VARCHAR2(50) NOT NULL,
    last_name VARCHAR2(50) NOT NULL,
    email VARCHAR2(100) UNIQUE,
    phone VARCHAR2(20),
    created_date DATE DEFAULT SYSDATE
);


-- Inserting dummy data

INSERT INTO accounts (account_id, customer_id, account_type, balance, interest_rate) VALUES
(1001, 1, 'SAVINGS', 5000.00, 0.01),
(1002, 1, 'CHECKING', 2500.00, 0.00),
(1003, 2, 'SAVINGS', 10000.00, 0.01),
(1004, 3, 'SAVINGS', 7500.00, 0.01),
(1005, 2, 'CHECKING', 3000.00, 0.00);


INSERT INTO employees (employee_id, first_name, last_name, department, salary, performance_rating) VALUES
(2001, 'John', 'Smith', 'IT', 65000.00, 4.2),
(2002, 'Sarah', 'Johnson', 'IT', 70000.00, 4.5),
(2003, 'Mike', 'Davis', 'HR', 55000.00, 3.8),
(2004, 'Lisa', 'Wilson', 'HR', 60000.00, 4.1),
(2005, 'David', 'Brown', 'Finance', 75000.00, 4.7),
(2006, 'Emily', 'Taylor', 'Finance', 80000.00, 4.3);


INSERT INTO customers (customer_id, first_name, last_name, email, phone) VALUES
(1, 'Alice', 'Johnson', 'alice.johnson@email.com', '555-0101'),
(2, 'Bob', 'Smith', 'bob.smith@email.com', '555-0102'),
(3, 'Carol', 'Davis', 'carol.davis@email.com', '555-0103');

COMMIT; 