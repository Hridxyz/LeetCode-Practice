
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Min-heap to store matrix elements with comparator by their value
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Initially, add the first element of each row to the heap
        for (int i = 0; i < matrix.length; i++) {
            // Each element in the heap is an array containing the value, the row index, and the column index
            minHeap.offer(new int[] {matrix[i][0], i, 0});
        }
        
        // Extract-min process for k-1 times to reach the k-th smallest element
        for (int i = 0; i < k - 1; i++) {
            int[] element = minHeap.poll();
            int value = element[0];
            int row = element[1];
            int col = element[2];
            
            // If there's another element in the same row, add it to the heap
            if (col + 1 < matrix[row].length) {
                minHeap.offer(new int[] {matrix[row][col + 1], row, col + 1});
            }
        }
        
        // The k-th smallest element
        return minHeap.poll()[0];
    }
}
