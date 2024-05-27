class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int newArea;
        int i=0; 
        int j=height.length-1;
        while(i<j){
            newArea = Math.min(height[i],height[j])*(j-i);
            maxArea = Math.max(maxArea, newArea);
            if(height[i]<=height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return maxArea;
    }
}