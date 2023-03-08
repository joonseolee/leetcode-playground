# Write your MySQL query statement below
SELECT
  score,
  @rank := @rank + (@prev <> (@prev := Score)) `rank`
FROM
  Scores,
  (SELECT @rank := 0, @prev := -1) r
ORDER BY score desc