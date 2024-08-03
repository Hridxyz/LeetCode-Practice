class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        
        Map<Integer, Integer> targetCount = new HashMap<>();
        Map<Integer, Integer> arrCount = new HashMap<>();
        
        for (int i = 0; i < target.length; i++) {
            targetCount.put(target[i], targetCount.getOrDefault(target[i], 0) + 1);
            arrCount.put(arr[i], arrCount.getOrDefault(arr[i], 0) + 1);
        }
        
        return targetCount.equals(arrCount);
    }
}