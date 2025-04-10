class Solution {
    private static int isCyclicDFS(int node, int parent, boolean[] visited, Map<Integer, List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (isCyclicDFS(neighbor, node, visited, adj)== neighbor) {
                    return neighbor;
                }
            } else if (neighbor != parent) {
                // Cycle found
                return neighbor;
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
            if (isCyclicDFS(u,-1, visited, adj) != -1) {
                result = edges[i];
                return result;
            }
        }

        return null;
    }
}
