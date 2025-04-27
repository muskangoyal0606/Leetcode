import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public static void dfs(int node, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack, adj);
            }
        }
        stack.push(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u); // Fix: Reverse the edge direction
        }

        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adj);
            }
        }

        // Convert stack to an array
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = stack.pop();
        }

        // Check for cycles (if topological order is valid)
        int[] position = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            position[order[i]] = i;
        }

        for (int u = 0; u < numCourses; u++) {
            for (int v : adj.get(u)) {
                if (position[u] >= position[v]) { // If u appears after v, it's invalid
                    return new int[0]; // Cycle detected
                }
            }
        }

        return order;
    }
}