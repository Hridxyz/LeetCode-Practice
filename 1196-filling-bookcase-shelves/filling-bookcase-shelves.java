class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(books, shelfWidth, 0, memo);
    }
    
    private int dfs(int[][] books, int shelfWidth, int i, int[] memo) {
        if (i == books.length) return 0;
        if (memo[i] != -1) return memo[i];
        
        int width = 0, height = 0, minHeight = Integer.MAX_VALUE;
        
        for (int j = i; j < books.length; j++) {
            width += books[j][0];
            if (width > shelfWidth) break;
            height = Math.max(height, books[j][1]);
            minHeight = Math.min(minHeight, height + dfs(books, shelfWidth, j + 1, memo));
        }
        
        memo[i] = minHeight;
        return minHeight;
    }
}