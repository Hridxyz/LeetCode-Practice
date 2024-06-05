# Write your MySQL query statement below
SELECT EUI.unique_id, E.name
FROM Employees E
LEFT JOIN EmployeeUNI EUI
ON E.id = EUI.id;