import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = 1_000_000_007;
        
        // Build graph: adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) graph.add(new ArrayList<>());
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }

        // Min-heap for Dijkstra: [time, node]
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0}); // {distance, node}
        
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long time = curr[0];
            int node = (int) curr[1];

            if (time > dist[node]) continue;

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int edgeTime = neighbor[1];
                long newTime = time + edgeTime;

                if (newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{newTime, nextNode});
                } else if (newTime == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1]%mod;
    }
}