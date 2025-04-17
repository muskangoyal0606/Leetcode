class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = 10000000;
        int[][] dist = new int[n][n];

        // Step 1: Initialize the distance matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // Step 2: Set direct edge distances
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            dist[from][to] = weight;
            dist[to][from] = weight;
        }

        // Step 3: Floyd-Warshall to compute all-pairs shortest path
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Step 4: Count reachable cities for each city
        int minReachable = n;
        int resultCity = -1;

        for (int i = 0; i < n; i++) {
            int reachable = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachable++;
                }
            }

            // Step 5: Choose the city with fewer reachable, break ties by larger index
            if (reachable <= minReachable) {
                minReachable = reachable;
                resultCity = i;
            }
        }

        return resultCity;
    }
}