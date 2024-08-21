# Write your MySQL query statement below
SELECT a.name FROM Employee AS a
INNER JOIN Employee AS b
ON a.id = b.managerID
GROUP BY a.id
HAVING COUNT(b.managerID) >= 5;