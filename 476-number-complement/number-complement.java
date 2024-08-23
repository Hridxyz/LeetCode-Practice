class Solution {
    public int findComplement(int num) {
        int temp = num;
        int mask = 0;
        
        // Build the mask
        while(temp != 0){
            mask = (mask << 1) | 1;
            temp >>= 1;
        }
        
        // XOR num with mask to get the complement
        return num ^ mask;
    }
}