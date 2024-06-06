# Write your MySQL query statement below
SELECT b.product_name, a.year, a.price
FROM Sales AS a
INNER JOIN Product AS b
ON a.product_id = b.product_id 
-- WHERE a.year IS NOT NULL
ORDER BY b.product_name