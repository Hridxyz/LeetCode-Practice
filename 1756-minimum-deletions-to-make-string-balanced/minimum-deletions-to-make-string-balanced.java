class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        
        // Count the total number of 'a's in the string
        int totalAs = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') totalAs++;
        }

        // Initialize leftBs and minDeletions
        int leftBs = 0;
        int minDeletions = totalAs;  // Initial assumption: delete all 'a's

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') {
                leftBs++;
            } else {
                totalAs--;
            }
            // Min deletions at this point: 'b's to the left + 'a's to the right
            minDeletions = Math.min(minDeletions, leftBs + totalAs);
        }

        return minDeletions;
    }
}