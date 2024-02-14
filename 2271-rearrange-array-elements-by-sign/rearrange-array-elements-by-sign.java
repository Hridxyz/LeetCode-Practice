class Solution {
    public int[] rearrangeArray(int[] nums) {
        int positivePointer = 0;
        int negativePointer = 0;
        int[] result = new int[nums.length];
        while (nums[positivePointer] < 0) {
            positivePointer++;
        }
        for (int i = 0; i < nums.length; i += 2) {
            result[i] = nums[positivePointer++];
            while (positivePointer < nums.length && nums[positivePointer] < 0) {
                positivePointer++;
            }
            
            // Place the next negative number
            if (i + 1 < nums.length) {
                while (nums[negativePointer] > 0) {
                    negativePointer++;
                }
                result[i + 1] = nums[negativePointer++];
            }
        }
        return result;
    }
}
