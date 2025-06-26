BEGIN
  FOR due_loan IN (SELECT l.LoanID, c.FullName, l.DueDate
                   FROM Loans l
                   JOIN Customers c ON c.CustomerID = l.CustomerID
                   WHERE l.DueDate <= SYSDATE + 30)
  LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || due_loan.LoanID ||
                         ' for ' || due_loan.FullName || 
                         ' is due on ' || TO_CHAR(due_loan.DueDate, 'DD-MON-YYYY'));
  END LOOP;
END;
/


SET SERVEROUTPUT ON;