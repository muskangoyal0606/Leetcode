import java.util.*;

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        // Step 1: Build adjacency list with Manhattan distances
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) adj.put(i, new ArrayList<>());

        for (int i = 0; i < n; i++) {
            int[] u = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] v = points[j];
                int dist = Math.abs(u[0] - v[0]) + Math.abs(u[1] - v[1]);
                adj.get(i).add(new int[]{j, dist});
                adj.get(j).add(new int[]{i, dist});
            }
        }

        // Step 2: Prim's MST setup
        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] mst = new boolean[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        TreeSet<int[]> set = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // by weight
            return a[1] - b[1]; // by node index
        });

        key[0] = 0;
        set.add(new int[]{0, 0}); // {weight, node}

        // Step 3: Prim's algorithm
        while (!set.isEmpty()) {
            int[] top = set.pollFirst();
            int node = top[1];
            mst[node] = true;

            for (int[] neighbor : adj.get(node)) {
                int v = neighbor[0];
                int wt = neighbor[1];

                if (!mst[v] && wt < key[v]) {
                    set.remove(new int[]{key[v], v});
                    key[v] = wt;
                    parent[v] = node;
                    set.add(new int[]{key[v], v});
                }
            }
        }

        // Step 4: Return total cost
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalCost += key[i];
        }

        return totalCost;
    }
}
