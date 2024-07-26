import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // Base case
        if (numRows == 0) {
            return triangle;
        }

        // First row is always [1]
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // The first element of each row is always 1
            row.add(1);

            // Each element in the middle of the row is the sum of the two elements above it
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last element of each row is always 1
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }
}