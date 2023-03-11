# Write your MySQL query statement below
SELECT c.name Customers
FROM Customers c
LEFT OUTER JOIN Orders o ON o.customerId = c.id
WHERE o.customerId is null;