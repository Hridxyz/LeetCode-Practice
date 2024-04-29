public class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = 0;
        // Find the XOR of all elements in the array
        for (int num : nums) {
            xor ^= num;
        }
        // XOR the result with k to find which bits are different
        int xorWithK = xor ^ k;
        // Count the number of bits set to 1 (differing bits)
        return Integer.bitCount(xorWithK);
    }
}
