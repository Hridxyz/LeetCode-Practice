SELECT a.name, b.bonus 
FROM Employee AS a 
LEFT JOIN Bonus AS b 
ON a.empID = b.empID 
WHERE b.bonus < 1000 OR b.bonus IS NULL;