class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE / 2;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        // Do k+1 “relaxation” rounds (0 stops ⇒ 1 edge, …, k stops ⇒ k+1 edges)
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(dist, n);
            for (int[] f : flights) {
                int u = f[0], v = f[1], w = f[2];
                if (dist[u] + w < temp[v]) {
                    temp[v] = dist[u] + w;
                }
            }
            dist = temp;
        }

        return dist[dst] >= INF ? -1 : dist[dst];
    }
}
