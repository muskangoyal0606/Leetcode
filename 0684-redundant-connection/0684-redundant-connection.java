class Solution {
    public int iscycle(int src, boolean[] visited, Map<Integer, List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> parent = new HashMap<>();
        q.offer(src);
        visited[src] = true;
        parent.put(src, -1);
        while (!q.isEmpty()) {
            int front = q.poll();
            for (int n : adj.get(front)) {
                if (visited[n] && parent.get(front) != n) {
                    return n;
                } else if (!visited[n]) {
                    visited[n] = true;
                    q.offer(n);
                    parent.put(n, front);
                }
            }
        }
        return -1;
    }

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int V = edges.length;
        for (int i = 1; i <= V; i++) {
            adj.put(i, new ArrayList<>());
        }

        boolean[] visited = new boolean[V + 1];
        int[] result = new int[2];

        for (int i = 0; i < V; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            // Check cycle
            Arrays.fill(visited, false);
            if (iscycle(u, visited, adj) != -1) {
                result = edges[i];
                return result;
            }
        }

        return null;
    }
}
