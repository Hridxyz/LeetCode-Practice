class Solution {
    public int findMaxLength(int[] nums) {
        // This hashmap will store the first index at which a count has been seen.
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, -1); // To handle the case when subarray starts from index 0.
        int maxLength = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            // Increment or decrement count
            count += nums[i] == 1 ? 1 : -1;
            
            if (countMap.containsKey(count)) {
                // If the count is the same, it means we've found a subarray of equal 0's and 1's.
                maxLength = Math.max(maxLength, i - countMap.get(count));
            } else {
                // Store the first time this count has been seen.
                countMap.put(count, i);
            }
        }
        
        return maxLength;
    }
}
