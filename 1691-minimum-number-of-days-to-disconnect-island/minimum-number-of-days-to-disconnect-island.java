class Solution {
    public int minDays(int[][] grid) {
        if (isDisconnected(grid)) return 0;  // Already disconnected

        int rows = grid.length, cols = grid[0].length;

        // Check each land cell by turning it into water and seeing if it disconnects the island
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;  // Temporarily change the cell to water
                    if (isDisconnected(grid)) return 1;  // Check if grid is now disconnected
                    grid[i][j] = 1;  // Change it back to land
                }
            }
        }

        // If no single cell can disconnect the island, return 2
        return 2;
    }

    // Helper function to check if the grid is disconnected
    private boolean isDisconnected(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // Find the first land cell to start DFS
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, i, j);
                    // Now check if there are any other unvisited land cells
                    for (int r = 0; r < rows; r++) {
                        for (int c = 0; c < cols; c++) {
                            if (grid[r][c] == 1 && !visited[r][c]) return true;
                        }
                    }
                    return false;
                }
            }
        }
        return true;  // No land found, so it's disconnected
    }

    // DFS to mark connected land cells as visited
    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int[] dir = {-1, 0, 1, 0, -1};  // Directions for row and column
        visited[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int r = i + dir[d], c = j + dir[d + 1];
            if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && 
                grid[r][c] == 1 && !visited[r][c]) {
                dfs(grid, visited, r, c);
            }
        }
    }
}