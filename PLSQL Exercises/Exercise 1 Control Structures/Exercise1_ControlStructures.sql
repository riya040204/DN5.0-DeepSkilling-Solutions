-- Exercise 1: Control Structures

-- SCENARIO 1: Apply 1% discount to customers above 60 years old
DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Name, Age, LoanInterestRate
        FROM Customers
        WHERE Age > 60;
BEGIN
    FOR customer IN c_customers LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = customer.CustomerID;
        DBMS_OUTPUT.PUT_LINE('Discount applied for: ' || customer.Name);
    END LOOP;
    COMMIT;
END;
/

-- SCENARIO 2: Promote customers to VIP if balance over 10000
DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Name, Balance
        FROM Customers;
BEGIN
    FOR customer IN c_customers LOOP
        IF customer.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = customer.CustomerID;
            DBMS_OUTPUT.PUT_LINE('VIP granted to: ' || customer.Name);
        ELSE
            DBMS_OUTPUT.PUT_LINE('Regular: ' || customer.Name);
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- SCENARIO 3: Reminders for loans due within 30 days
DECLARE
    CURSOR c_loans IS
        SELECT l.LoanID, c.Name, l.DueDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR loan IN c_loans LOOP
        DBMS_OUTPUT.PUT_LINE('REMINDER: Dear ' || loan.Name ||
                             ', Loan ' || loan.LoanID ||
                             ' due on ' || TO_CHAR(loan.DueDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/
