-- Run these commands in MySQL Workbench

-- Create schema
CREATE SCHEMA ormlearn;
USE ormlearn;

-- Create country table
CREATE TABLE country (
    co_code VARCHAR(2) PRIMARY KEY,
    co_name VARCHAR(50)
);

-- Insert sample data
INSERT INTO country VALUES ('IN', 'India');
INSERT INTO country VALUES ('US', 'United States of America');
INSERT INTO country VALUES ('UK', 'United Kingdom');
INSERT INTO country VALUES ('AU', 'Australia');

-- Verify data
SELECT * FROM country;
