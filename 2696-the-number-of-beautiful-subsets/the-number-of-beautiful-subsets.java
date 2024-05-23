class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        
        // Generate all subsets
        for (int i = 1; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            // Check if the subset is beautiful
            if (isBeautiful(subset, k)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isBeautiful(List<Integer> subset, int k) {
        int n = subset.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(subset.get(i) - subset.get(j)) == k) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {2, 4, 6};
        int k1 = 2;
        System.out.println(sol.beautifulSubsets(nums1, k1));  // Output: 4
        
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(sol.beautifulSubsets(nums2, k2));  // Output: 1
    }
}