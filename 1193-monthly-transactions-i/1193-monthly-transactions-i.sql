# Write your MySQL query statement below
SELECT SUBSTR(t.trans_date, 1, 7) as month, t.country, COUNT(t.amount) trans_count, COUNT(CASE WHEN t.state = 'approved' THEN 1 ELSE null END) approved_count, SUM(t.amount) trans_total_amount, SUM(CASE WHEN t.state = 'approved' THEN t.amount ELSE 0 END) approved_total_amount
FROM Transactions t
GROUP BY SUBSTR(t.trans_date, 1, 7), t.country
