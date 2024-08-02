class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int k=0;

        for(int num:nums){
            if(num == 1){
                k++;
            }
        }

        if(k==0||k==n){
            return 0;
        }
        int currentOnes = 0;
        for( int i=0; i < k; i++){
            if(nums[i] == 1){
                currentOnes++;
            }
        }
        int maxOnes = currentOnes;

        for(int i=1; i<n; i++){
            if(nums[(i-1)%n] == 1){
                currentOnes --;
            }
            if(nums[(i+k-1)%n] == 1){
                currentOnes++;
            }
            maxOnes = Math.max(maxOnes, currentOnes);
        }
        return k-maxOnes;
    }
}