public class Solution {
    public long wonderfulSubstrings(String word) {
        long[] count = new long[1024]; // There are 2^10 possible bitmasks
        count[0] = 1; // To handle the case where the substring starts from the first character
        int mask = 0;
        long result = 0;
        
        for (char c : word.toCharArray()) {
            // Flip the corresponding bit in the bitmask
            mask ^= (1 << (c - 'a'));
            
            // All substrings with this exact bitmask are wonderful
            result += count[mask];
            
            // Try flipping each bit to find substrings where exactly one character has an odd count
            for (int i = 0; i < 10; i++) {
                result += count[mask ^ (1 << i)];
            }
            
            // Increment the count of this bitmask in the map
            count[mask]++;
        }
        
        return result;
    }
}
