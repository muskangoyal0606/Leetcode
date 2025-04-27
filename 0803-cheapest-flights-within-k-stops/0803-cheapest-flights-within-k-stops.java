import java.util.*;

class Solution {
    class Pair {
        int city, cost, stops;
        public Pair(int city, int cost, int stops) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build the adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }
        
        // Queue for BFS: {city, cost, stops}
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, 0, 0));
        
        // Track the minimum cost to reach each city with given stops
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int city = current.city;
            int cost = current.cost;
            int stops = current.stops;
            
            if (stops > k) continue; // If stops exceed k, skip
            
            if (!graph.containsKey(city)) continue;
            
            for (int[] neighbor : graph.get(city)) {
                int nextCity = neighbor[0];
                int price = neighbor[1];
                
                if (cost + price < minCost[nextCity]) {
                    minCost[nextCity] = cost + price;
                    queue.add(new Pair(nextCity, cost + price, stops + 1));
                }
            }
        }
        
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
