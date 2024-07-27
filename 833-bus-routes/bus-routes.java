import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        
        // Map each stop to the buses (routes) that go through it
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }
        
        // BFS setup
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();
        queue.add(source);
        visitedStops.add(source);
        
        int buses = 0;
        
        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            buses++;
            
            for (int i = 0; i < size; i++) {
                int currentStop = queue.poll();
                
                for (int bus : stopToBuses.getOrDefault(currentStop, new ArrayList<>())) {
                    if (visitedBuses.contains(bus)) {
                        continue;
                    }
                    
                    visitedBuses.add(bus);
                    
                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) {
                            return buses;
                        }
                        
                        if (!visitedStops.contains(nextStop)) {
                            visitedStops.add(nextStop);
                            queue.add(nextStop);
                        }
                    }
                }
            }
        }
        
        return -1; // If we cannot reach the target
    }
}