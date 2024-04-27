import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    private HashMap<Character, List<Integer>> charToIndicesMap = new HashMap<>();
    private int[][] memo;
    private String ring;
    private String key;

    public int findRotateSteps(String ring, String key) {
        this.ring = ring;
        this.key = key;
        memo = new int[ring.length()][key.length()];
        // Populate the map with lists of indices for each character
        for (int i = 0; i < ring.length(); i++) {
            charToIndicesMap.computeIfAbsent(ring.charAt(i), k -> new ArrayList<>()).add(i);
        }
        // Kick off the DP with the initial position being 0
        return dp(0, 0) + key.length();
    }

    private int dp(int ringPos, int keyIndex) {
        if (keyIndex == key.length()) {
            return 0; // No more characters to process
        }
        if (memo[ringPos][keyIndex] != 0) {
            return memo[ringPos][keyIndex]; // Return already computed result
        }
        int minSteps = Integer.MAX_VALUE;
        char keyChar = key.charAt(keyIndex);
        // Try all positions for the current character and use the one with the minimum steps
        for (int index : charToIndicesMap.get(keyChar)) {
            int dist = Math.abs(index - ringPos);
            int step = Math.min(dist, ring.length() - dist); // Clockwise or counter-clockwise
            minSteps = Math.min(minSteps, step + dp(index, keyIndex + 1));
        }
        memo[ringPos][keyIndex] = minSteps;
        return minSteps;
    }
}
