import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        
        // Sort the points based on the end position
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrowPos = points[0][1]; // First arrow position at the end of the first balloon
        int arrowCount = 1;
        
        for (int i = 1; i < points.length; i++) {
            // If the balloon's start position is after the arrow position, we need a new arrow
            if (points[i][0] > arrowPos) {
                arrowCount++;
                arrowPos = points[i][1];
            }
        }
        
        return arrowCount;
    }
}
