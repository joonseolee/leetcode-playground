# Write your MySQL query statement below
SELECT w2.id
FROM Weather w
LEFT JOIN Weather w2 ON w2.recordDate = DATE_ADD(w.recordDate, INTERVAL 1 DAY)
WHERE w.temperature < w2.temperature;