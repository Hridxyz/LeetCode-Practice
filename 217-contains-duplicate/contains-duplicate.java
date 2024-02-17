class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                // add() returns false if num was already in the set
                return true;
            }
        }
        return false;
    }
}