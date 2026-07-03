-- ============================================
-- Exercise 3: Stored Procedures
-- ============================================

-- SCENARIO 1: Process Monthly Interest for Savings Accounts
-- Adds 1% interest to all savings account balances
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = ''SAVINGS'';

    DBMS_OUTPUT.PUT_LINE(''Monthly interest of 1% applied to all savings accounts.'');
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(''Error: '' || SQLERRM);
        ROLLBACK;
END ProcessMonthlyInterest;
/

-- How to call Scenario 1:
-- BEGIN
--     ProcessMonthlyInterest;
-- END;
-- /


-- ============================================
-- SCENARIO 2: Update Employee Bonus by Department
-- Adds bonus percentage to salary for a given department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department_id IN NUMBER,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percentage / 100)
    WHERE DepartmentID = p_department_id;

    IF SQL%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE(''No employees found in Department '' || p_department_id);
    ELSE
        DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || '' employees updated with '' ||
                             p_bonus_percentage || ''% bonus in Department '' ||
                             p_department_id);
    END IF;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(''Error: '' || SQLERRM);
        ROLLBACK;
END UpdateEmployeeBonus;
/

-- How to call Scenario 2:
-- BEGIN
--     UpdateEmployeeBonus(10, 15);  -- 15% bonus for Department 10
-- END;
-- /


-- ============================================
-- SCENARIO 3: Transfer Funds Between Accounts
-- Transfers amount from source to destination account
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- Check source account balance
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    -- Check sufficient balance
    IF v_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE(''Error: Insufficient balance in Account '' || p_from_account);
        DBMS_OUTPUT.PUT_LINE(''Available Balance: '' || v_balance);
    ELSE
        -- Deduct from source account
        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_from_account;

        -- Add to destination account
        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_to_account;

        DBMS_OUTPUT.PUT_LINE(''Transfer Successful!'');
        DBMS_OUTPUT.PUT_LINE(''Amount: $'' || p_amount ||
                             '' transferred from Account '' || p_from_account ||
                             '' to Account '' || p_to_account);
        COMMIT;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE(''Error: Account not found.'');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(''Error: '' || SQLERRM);
        ROLLBACK;
END TransferFunds;
/

-- How to call Scenario 3:
-- BEGIN
--     TransferFunds(1001, 1002, 500);  -- Transfer 500 from Acc 1001 to 1002
-- END;
-- /
