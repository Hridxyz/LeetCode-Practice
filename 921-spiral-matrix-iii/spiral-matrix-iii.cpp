class Solution {
public:
    vector<vector<int>> spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        vector<vector<int>> result;
        int totalCells = rows * cols;
        int steps = 1;
        int r = rStart, c = cStart;
        
        result.push_back({r, c});
        if (totalCells == 1) return result;
        
        while (result.size() < totalCells) {
            // Move right
            for (int i = 0; i < steps; ++i) {
                c++;
                if (r >= 0 && r < rows && c >= 0 && c < cols) result.push_back({r, c});
            }
            // Move down
            for (int i = 0; i < steps; ++i) {
                r++;
                if (r >= 0 && r < rows && c >= 0 && c < cols) result.push_back({r, c});
            }
            steps++;
            // Move left
            for (int i = 0; i < steps; ++i) {
                c--;
                if (r >= 0 && r < rows && c >= 0 && c < cols) result.push_back({r, c});
            }
            // Move up
            for (int i = 0; i < steps; ++i) {
                r--;
                if (r >= 0 && r < rows && c >= 0 && c < cols) result.push_back({r, c});
            }
            steps++;
        }
        
        return result;
    }
};