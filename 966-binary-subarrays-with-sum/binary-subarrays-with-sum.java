class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0, res = 0;
        int[] count = new int[nums.length + 1];
        count[0] = 1; // One way to have sum = 0 (by having no elements)
        
        for (int num : nums) {
            sum += num;
            // If sum >= goal, then add the number of times (sum - goal) has occurred to result
            if (sum >= goal) res += count[sum - goal];
            // Increment the count of sum in the array
            count[sum]++;
        }
        
        return res;
    }
}
