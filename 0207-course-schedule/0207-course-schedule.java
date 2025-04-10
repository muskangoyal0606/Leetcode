class Solution {
private static boolean checkCycleDFS(int node, boolean[] visited, boolean[] dfsVisited, HashMap<Integer, List<Integer>> adj) {
    visited[node] = true;
    dfsVisited[node] = true;

    for (int neighbour : adj.get(node)) {
      if (!visited[neighbour]) {
        if (checkCycleDFS(neighbour, visited, dfsVisited, adj)) {
          return true;
        }
      } else if (dfsVisited[neighbour]) {
        
        return true;
      }
    }

    dfsVisited[node] = false;
    return false;
  }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int V = numCourses;
        int[][] edges = prerequisites;
        for (int i = 0; i < V; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i <edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);

        }


    // Create visited and dfsVisited arrays
    boolean[] visited = new boolean[V + 1];
    boolean[] dfsVisited = new boolean[V + 1];

     for (int i = 1; i <V; i++) {
      if (!visited[i]) {
        if (checkCycleDFS(i, visited, dfsVisited, adj)) {
          return false;
        }
      }
    }

    return true;
        
    }
}