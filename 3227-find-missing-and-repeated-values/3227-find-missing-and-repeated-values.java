class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int a = 0, b=0;
        int n= grid.length;
        Set<Integer> set = new HashSet<>();
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(set.contains(grid[i][j])){
                    a=grid[i][j];
                }
                set.add(grid[i][j]);
            }
        }

        for(int k =0;k<=n*n;k++){
            if(!set.contains(k)){
                b=k;
            }
        }
        return new int[]{a,b};
    }
}