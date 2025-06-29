CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
    v_interest_rate NUMBER := 0.01; 
    v_updated_accounts NUMBER := 0;
    v_total_interest NUMBER := 0;
BEGIN
    
    DBMS_OUTPUT.PUT_LINE('Starting monthly interest processing...');
    DBMS_OUTPUT.PUT_LINE('Interest rate: ' || (v_interest_rate * 100) || '%');
    
    UPDATE accounts 
    SET balance = balance + (balance * v_interest_rate),
        last_updated = SYSDATE
    WHERE account_type = 'SAVINGS';

    v_updated_accounts := SQL%ROWCOUNT;
    
    SELECT SUM(balance * v_interest_rate)
    INTO v_total_interest
    FROM accounts
    WHERE account_type = 'SAVINGS';
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest processing completed successfully!');
    DBMS_OUTPUT.PUT_LINE('Number of savings accounts updated: ' || v_updated_accounts);
    DBMS_OUTPUT.PUT_LINE('Total interest applied: $' || TO_CHAR(v_total_interest, '999,999.99'));
    
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred during monthly interest processing: ' || SQLERRM);
        RAISE;
END ProcessMonthlyInterest;
/


SELECT account_id, customer_id, account_type, balance, last_updated  FROM accounts WHERE account_type = 'SAVINGS' ORDER BY account_id;

EXEC ProcessMonthlyInterest; -- executing the procedure

SELECT account_id, customer_id, account_type, balance, last_updated FROM accounts WHERE account_type = 'SAVINGS' ORDER BY account_id; 