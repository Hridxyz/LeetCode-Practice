import java.util.*;

class Solution {
    // Global variables to store the graph, the count of nodes in each subtree, and the result
    private List<Set<Integer>> graph;
    private int[] count;
    private int[] result;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // Initialize graph as an adjacency list, count array, and result array
        graph = new ArrayList<>();
        count = new int[n];
        result = new int[n];
        
        // Build the graph
        for (int i = 0; i < n; ++i) graph.add(new HashSet<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // First DFS to populate count and result for root node
        dfs(0, -1);
        // Second DFS to adjust result based on result of the root node
        dfs2(0, -1);
        
        return result;
    }

    private void dfs(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child == parent) continue; // Skip the parent
            dfs(child, node); // DFS into child node
            count[node] += count[child]; // Update count of nodes in the subtree
            result[node] += result[child] + count[child]; // Update the result with distances from child
        }
        count[node]++; // Count the current node itself
    }

    private void dfs2(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child == parent) continue; // Skip the parent
            result[child] = result[node] - count[child] + count.length - count[child];
            // Recurse into the child node to continue adjusting the result
            dfs2(child, node);
        }
    }
}
