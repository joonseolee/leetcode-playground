# Write your MySQL query statement below
SELECT e.name
FROM Employee e
INNER JOIN (SELECT managerId, COUNT(*) total FROM Employee GROUP BY managerId) ec ON e.id = ec.managerId
WHERE ec.total > 4;