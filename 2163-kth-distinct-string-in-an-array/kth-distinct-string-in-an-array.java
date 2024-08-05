import java.util.*;

class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        
        // Count the frequency of each string
        for (String s : arr) {
            freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
        }
        
        List<String> distinctList = new ArrayList<>();
        
        // Collect distinct strings based on their order in the array
        for (String s : arr) {
            if (freqMap.get(s) == 1) {
                distinctList.add(s);
            }
        }
        
        // Return the k-th distinct string if it exists
        if (k <= distinctList.size()) {
            return distinctList.get(k - 1);
        } else {
            return "";
        }
    }
}