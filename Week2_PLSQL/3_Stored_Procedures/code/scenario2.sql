CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) AS
    v_updated_employees NUMBER := 0;
    v_total_bonus NUMBER := 0;
    v_department_exists NUMBER := 0;
BEGIN
    
    IF p_department IS NULL OR p_bonus_percentage IS NULL THEN
        RAISE_APPLICATION_ERROR(-20001, 'Department and bonus percentage cannot be null');
    END IF;
    
    IF p_bonus_percentage < 0 OR p_bonus_percentage > 100 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Bonus percentage must be between 0 and 100');
    END IF;
    
    
    SELECT COUNT(*)
    INTO v_department_exists
    FROM employees
    WHERE department = p_department;
    
    IF v_department_exists = 0 THEN
        RAISE_APPLICATION_ERROR(-20003, 'Department ' || p_department || ' does not exist');
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('Starting employee bonus update...');
    DBMS_OUTPUT.PUT_LINE('Department: ' || p_department);
    DBMS_OUTPUT.PUT_LINE('Bonus percentage: ' || p_bonus_percentage || '%');
    
    SELECT SUM(salary * (p_bonus_percentage / 100))
    INTO v_total_bonus
    FROM employees
    WHERE department = p_department;
    
    UPDATE employees 
    SET salary = salary + (salary * (p_bonus_percentage / 100))
    WHERE department = p_department;
    

    v_updated_employees := SQL%ROWCOUNT;
    
    DBMS_OUTPUT.PUT_LINE('Employee bonus update completed successfully!');
    DBMS_OUTPUT.PUT_LINE('Number of employees updated: ' || v_updated_employees);
    DBMS_OUTPUT.PUT_LINE('Total bonus amount: $' || TO_CHAR(v_total_bonus, '999,999.99'));
    
    COMMIT;
    

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred during employee bonus update: ' || SQLERRM);
        RAISE;
END UpdateEmployeeBonus;
/



SELECT employee_id, first_name, last_name, department, salary FROM employees WHERE department = 'IT'ORDER BY employee_id;

EXEC UpdateEmployeeBonus('IT', 10); -- executing the procedure

SELECT employee_id, first_name, last_name, department, salary FROM employees WHERE department = 'IT' ORDER BY employee_id;
 
EXEC UpdateEmployeeBonus('HR', 5);  -- executing the procedure again

SELECT employee_id, first_name, last_name, department, salary FROM employees ORDER BY department, employee_id; 