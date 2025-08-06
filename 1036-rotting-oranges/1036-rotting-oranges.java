class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int time =0;
        int fo =0;

        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }else if(grid[i][j]==1){
                    fo++;
                }
            }
        }
        if(fo==0){
            return 0;
        }
        int[] row = {-1,0,1,0};
        int[] col = {0,1,0,-1};

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int ru = cell[0];
            int cu = cell[1];
            int tu = cell[2];
            time = Math.max(time,tu);
            for(int i=0;i<4;i++){
                int nrow = ru + row[i];
                int ncol = cu + col[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1){
                    grid[nrow][ncol] =2;
                    fo--;
                    q.add(new int[]{nrow,ncol,tu+1});
                }
            }
            
        }
        if(fo==0){
            return time;
        }else{
            return -1;
        }

    }
}
