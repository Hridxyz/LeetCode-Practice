class Solution {
    public int search(int[] nums, int target) {
        int pv = 0;
        if(nums.length == 1 && nums[0] == target){
            return 0;
        }
        for(int i =0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                pv = i + 1; // Adjust pv to the index of the pivot
                break;
            }
        }
        if(nums[pv] == target){
            return pv;
        }
        for(int i=0; i<pv; i++){ // Correct loop variable
            if(nums[i] == target){
                return i;
            }
        }
        for(int j=pv; j<nums.length; j++){
            if(nums[j] == target){
                return j;
            }
        }
        return -1;
    }
}