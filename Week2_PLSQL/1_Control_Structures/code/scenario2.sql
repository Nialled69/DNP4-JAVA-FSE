BEGIN
  FOR cust IN (SELECT CustomerID FROM Customers WHERE Balance > 10000) 
  LOOP
    UPDATE Customers
    SET IsVIP = 'Y'
    WHERE CustomerID = cust.CustomerID;
  END LOOP;
END;
/

select * from Customers;