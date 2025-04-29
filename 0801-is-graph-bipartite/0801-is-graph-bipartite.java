class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0: unvisited, 1: color1, -1: color2

        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !dfs(graph, color, i, 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int[] color, int node, int currentColor) {
        color[node] = currentColor;

        for (int neighbor : graph[node]) {
            if (color[neighbor] == 0) {
                if (!dfs(graph, color, neighbor, -currentColor)) {
                    return false;
                }
            } else if (color[neighbor] == currentColor) {
                return false; // Same color as the current node
            }
        }

        return true;
    }
}
