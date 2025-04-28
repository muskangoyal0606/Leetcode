class Solution {
    public int[][] updateMatrix(int[][] mat) {
       int n = mat.length;
        int m = mat[0].length;
        
        int[][] dist = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        
        // Step 1: Push all cells with 1 into the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j, 0});  // {row, col, distance}
                    vis[i][j] = true;
                }
            }
        }
        
        // Step 2: BFS to find the minimum distance
        int[] delRow = {-1, 0, 1, 0}; // up, right, down, left
        int[] delCol = {0, 1, 0, -1};
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int row = temp[0];
            int col = temp[1];
            int steps = temp[2];
            
            dist[row][col] = steps;
            
            // Explore neighbors
            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true;
                    q.offer(new int[]{nrow, ncol, steps + 1});
                }
            }
        }
        
        return dist; 
    }
}