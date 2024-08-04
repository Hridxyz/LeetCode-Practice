
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        // Generate all subarray sums
        int[] subSums = subArray(nums, n);
        
        // Sort the array of subarray sums
        Arrays.sort(subSums);
        
        // Calculate the sum from index 'left' to 'right' (1-based index)
        return calSum(subSums, left, right);
    }
    
    public int[] subArray(int[] nums, int n) {
        int[] arr = new int[n * (n + 1) / 2];
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                arr[count++] = sum;
            }
        }
        return arr;
    }
    
    public int calSum(int[] arr, int left, int right) {
        long sum = 0;
        int mod = (int)(1e9 + 7);
        
        for (int i = left - 1; i < right; i++) {
            sum = (sum + arr[i]) % mod;
        }
        
        return (int) sum;
    }
}