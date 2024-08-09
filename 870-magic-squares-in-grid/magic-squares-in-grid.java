class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean isMagic(int[][] grid, int row, int col) {
        // Check for unique values from 1 to 9
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val = grid[row + i][col + j];
                if (val < 1 || val > 9 || seen[val]) {
                    return false;
                }
                seen[val] = true;
            }
        }
        
        // Check if rows, columns, and diagonals sum to 15
        return (grid[row][col] + grid[row][col + 1] + grid[row][col + 2] == 15 &&
                grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2] == 15 &&
                grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2] == 15 &&
                grid[row][col] + grid[row + 1][col] + grid[row + 2][col] == 15 &&
                grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1] == 15 &&
                grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2] == 15 &&
                grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] == 15 &&
                grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] == 15);
    }
}