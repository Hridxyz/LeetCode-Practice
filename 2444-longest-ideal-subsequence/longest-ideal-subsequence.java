class Solution {
    public int longestIdealString(String s, int k) {
        // Create an array to store the longest ideal subsequence length ending with each letter
        int[] dp = new int[128];
        for (char c : s.toCharArray()) {
            // Find the current maximum length of the ideal subsequence that we can extend
            int maxPrevLen = 0;
            for (char j = (char)(Math.max('a', c - k)); j <= Math.min('z', c + k); j++) {
                maxPrevLen = Math.max(maxPrevLen, dp[j]);
            }
            // Update the length of the ideal subsequence ending with the current character
            dp[c] = maxPrevLen + 1;
        }
        // Find the maximum length among all ideal subsequences
        int maxLength = 0;
        for (int length : dp) {
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}
