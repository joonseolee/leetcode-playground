# Write your MySQL query statement below
SELECT d.name Department, e.name Employee, e.salary Salary
FROM department d, employee e
WHERE (
    SELECT COUNT(DISTINCT salary)
    FROM employee
    WHERE salary > e.salary AND departmentId = d.id
) < 3 AND e.departmentId = d.id;