class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> ladderAllocations = new PriorityQueue<>();
        
        for (int i = 0; i < heights.length - 1; i++) {
            int climb = heights[i + 1] - heights[i];
            
            if (climb > 0) { // we need to climb up
                ladderAllocations.add(climb);
                if (ladderAllocations.size() > ladders) { // we've used all ladders, now use bricks
                    bricks -= ladderAllocations.poll(); // use bricks on the smallest climb
                }
                if (bricks < 0) { // we don't have enough bricks
                    return i;
                }
            }
        }
        
        return heights.length - 1; // we can reach the last building
    }
}