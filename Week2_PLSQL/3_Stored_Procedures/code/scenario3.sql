CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_from_balance NUMBER;
    v_to_balance NUMBER;
    v_from_account_exists NUMBER := 0;
    v_to_account_exists NUMBER := 0;
    v_transfer_successful BOOLEAN := FALSE;
BEGIN

    IF p_from_account_id IS NULL OR p_to_account_id IS NULL OR p_amount IS NULL THEN
        RAISE_APPLICATION_ERROR(-20001, 'Account IDs and amount cannot be null');
    END IF;
    
    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Transfer amount must be greater than zero');
    END IF;
    
    IF p_from_account_id = p_to_account_id THEN
        RAISE_APPLICATION_ERROR(-20003, 'Cannot transfer to the same account');
    END IF;
    

    SELECT COUNT(*)
    INTO v_from_account_exists
    FROM accounts
    WHERE account_id = p_from_account_id;
    
    IF v_from_account_exists = 0 THEN
        RAISE_APPLICATION_ERROR(-20004, 'Source account ' || p_from_account_id || ' does not exist');
    END IF;
    
    SELECT COUNT(*)
    INTO v_to_account_exists
    FROM accounts
    WHERE account_id = p_to_account_id;
    
    IF v_to_account_exists = 0 THEN
        RAISE_APPLICATION_ERROR(-20005, 'Destination account ' || p_to_account_id || ' does not exist');
    END IF;
    

    SELECT balance INTO v_from_balance
    FROM accounts
    WHERE account_id = p_from_account_id;
    
    SELECT balance INTO v_to_balance
    FROM accounts
    WHERE account_id = p_to_account_id;
    

    IF v_from_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20006, 'Insufficient balance in source account. Available: $' || 
                           TO_CHAR(v_from_balance, '999,999.99') || ', Required: $' || 
                           TO_CHAR(p_amount, '999,999.99'));
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('Starting fund transfer...');
    DBMS_OUTPUT.PUT_LINE('From Account: ' || p_from_account_id || ' (Balance: $' || TO_CHAR(v_from_balance, '999,999.99') || ')');
    DBMS_OUTPUT.PUT_LINE('To Account: ' || p_to_account_id || ' (Balance: $' || TO_CHAR(v_to_balance, '999,999.99') || ')');
    DBMS_OUTPUT.PUT_LINE('Transfer Amount: $' || TO_CHAR(p_amount, '999,999.99'));
    
    
    UPDATE accounts 
    SET balance = balance - p_amount,
        last_updated = SYSDATE
    WHERE account_id = p_from_account_id;
    
    UPDATE accounts 
    SET balance = balance + p_amount,
        last_updated = SYSDATE
    WHERE account_id = p_to_account_id;
    
    v_transfer_successful := TRUE;
    

    DBMS_OUTPUT.PUT_LINE('Fund transfer completed successfully!');
    DBMS_OUTPUT.PUT_LINE('New balance in account ' || p_from_account_id || ': $' || 
                        TO_CHAR(v_from_balance - p_amount, '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('New balance in account ' || p_to_account_id || ': $' || 
                        TO_CHAR(v_to_balance + p_amount, '999,999.99'));
    

    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN

        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred during fund transfer: ' || SQLERRM);
        RAISE;
END TransferFunds;
/



SELECT account_id, customer_id, account_type, balance FROM accounts ORDER BY account_id;

EXEC TransferFunds(1001, 1002, 1000);

SELECT account_id, customer_id, account_type, balance FROM accounts ORDER BY account_id;

EXEC TransferFunds(1003, 1004, 2000);

SELECT account_id, customer_id, account_type, balance FROM accounts ORDER BY account_id; 