class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<=nums.length-1; i++){
            for(int j=0; j<=nums.length-1; j++){
                if(i==j) continue;
                max = Math.max((nums[i]-1)*(nums[j]-1),max);
                //max = (((nums[i]-1)*(nums[j]-1))>max) ? ((nums[i]-1)*(nums[j]-1)) : max; 
            }
        }
        return max;
    }
}