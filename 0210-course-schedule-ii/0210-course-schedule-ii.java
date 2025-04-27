class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = numCourses;
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : prerequisites) {
            int u = edge[1];
            int v = edge[0];
            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, pathVisited, stack, adj)) {
                    return new int[0]; // Cycle detected
                }
            }
        }

        int[] top = new int[V];
        int idx = 0;
        while (!stack.isEmpty()) {
            top[idx++] = stack.pop();
        }
        return top;
    }

    private static boolean dfs(int node, boolean[] visited, boolean[] pathVisited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, pathVisited, stack, adj)) return true;
            } else if (pathVisited[neighbor]) {
                return true; // Cycle detected
            }
        }

        pathVisited[node] = false; // Unmark the current path
        stack.push(node);
        return false;
    }
}