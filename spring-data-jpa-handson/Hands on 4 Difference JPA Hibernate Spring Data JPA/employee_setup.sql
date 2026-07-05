USE ormlearn;

CREATE TABLE employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    emp_salary DOUBLE,
    emp_department VARCHAR(50)
);

INSERT INTO employee VALUES (1, 'Alice', 75000.00, 'Engineering');
INSERT INTO employee VALUES (2, 'Bob', 65000.00, 'Marketing');
INSERT INTO employee VALUES (3, 'Charlie', 80000.00, 'Engineering');
INSERT INTO employee VALUES (4, 'Diana', 70000.00, 'HR');

SELECT * FROM employee;
