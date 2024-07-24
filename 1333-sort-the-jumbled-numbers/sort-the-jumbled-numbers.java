import java.util.Arrays;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // Create an array to store the mapped values and their original indices
        int n = nums.length;
        int[][] mappedNums = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            mappedNums[i][0] = getMappedValue(nums[i], mapping);
            mappedNums[i][1] = i;
        }
        
        // Sort based on the mapped values, if equal use the original indices
        Arrays.sort(mappedNums, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        // Create the result array based on the sorted mapped values
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[mappedNums[i][1]];
        }
        
        return result;
    }

    private int getMappedValue(int num, int[] mapping) {
        StringBuilder sb = new StringBuilder();
        String strNum = String.valueOf(num);
        for (char c : strNum.toCharArray()) {
            sb.append(mapping[c - '0']);
        }
        return Integer.parseInt(sb.toString());
    }
}