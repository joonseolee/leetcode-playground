# Write your MySQL query statement below
SELECT d.name Department, e.name Employee, e.salary Salary
FROM Department d, Employee e
WHERE d.id = e.departmentId AND e.salary = (
    SELECT MAX(salary)
    FROM Employee
    WHERE departmentId = d.id
) 