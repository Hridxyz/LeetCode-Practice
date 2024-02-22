class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustO = new int[n+1];
        int[] trustB = new int[n+1];
        for (int[] relation : trust){
            trustO[relation[0]]++;
            trustB[relation[1]]++;
        }
        for(int i=1; i<=n; i++){
            if(trustO[i] == 0 && trustB[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}