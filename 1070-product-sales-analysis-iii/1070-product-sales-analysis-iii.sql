# Write your MySQL query statement below
SELECT s.product_id, s.year first_year, s.quantity, s.price
FROM Sales s
WHERE (s.product_id, s.year) in (
    SELECT product_id, MIN(year) 
    FROM Sales
    GROUP BY product_id
)
