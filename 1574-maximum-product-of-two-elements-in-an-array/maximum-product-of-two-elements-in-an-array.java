class Solution {
     public int maxProduct(int[] nums) {
        return maxProductHelper(nums, 0, 1, Integer.MIN_VALUE);
    }

    private int maxProductHelper(int[] nums, int start, int next, int max) {
        // Base case: if we've reached the end of the array, return the max product found so far.
        if (start >= nums.length - 1) {
            return max;
        }
        
        if (next >= nums.length) {
            // Move to the next starting point and reset 'next' to 'start + 1'
            return maxProductHelper(nums, start + 1, start + 2, max);
        }
        
        // Calculate the product.
        int product = (nums[start] - 1) * (nums[next] - 1);
        
        // Update the maximum product if the current product is greater.
        max = Math.max(max, product);
        
        // Recurse to the next pair.
        return maxProductHelper(nums, start, next + 1, max);
    }
}