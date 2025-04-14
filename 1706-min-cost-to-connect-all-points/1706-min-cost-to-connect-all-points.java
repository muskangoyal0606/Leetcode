import java.util.*;

public class Solution {

    static class Edge {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static class DisjointSet {
        int[] parent, rank;

        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int findParent(int node) {
            if (parent[node] == node) return node;
            return parent[node] = findParent(parent[node]); // Path compression
        }

        void unionSet(int u, int v) {
            u = findParent(u);
            v = findParent(v);

            if (u == v) return;

            if (rank[u] < rank[v]) {
                parent[u] = v;
            } else if (rank[v] < rank[u]) {
                parent[v] = u;
            } else {
                parent[v] = u;
                rank[u]++;
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> edges = new ArrayList<>();

        // Build all possible edges with Manhattan distances
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + 
                           Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, dist));
            }
        }

        // Sort edges by weight
        Collections.sort(edges, (a, b) -> a.weight - b.weight);

        DisjointSet ds = new DisjointSet(n);
        int minCost = 0;
        int count = 0;

        for (Edge edge : edges) {
            if (ds.findParent(edge.u) != ds.findParent(edge.v)) {
                ds.unionSet(edge.u, edge.v);
                minCost += edge.weight;
                count++;
                if (count == n - 1) break; // MST will have exactly n-1 edges
            }
        }

        return minCost;
    }
}
