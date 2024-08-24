# Write your MySQL query statement below
SELECT 
    id, 
    movie, 
    description, 
    rating
FROM 
    Cinema
WHERE 
    id % 2 != 0  -- This condition checks for odd-numbered IDs
    AND description != 'boring'  -- This condition filters out movies with the description 'boring'
ORDER BY 
    rating DESC;  -- This orders the results by rating in descending order