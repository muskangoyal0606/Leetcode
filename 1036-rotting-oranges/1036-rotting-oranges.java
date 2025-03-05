class Solution {
    public int orangesRotting(int[][] grid) {
        int count = 0;
        boolean changed = true; // Flag to check if rotting still happens

        while (changed) { // Run until no more changes happen
            changed = false;
            int[][] tempGrid = new int[grid.length][grid[0].length];

            // Copy grid state to avoid modifying it while iterating
            for (int i = 0; i < grid.length; i++) {
                tempGrid[i] = grid[i].clone();
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        if (rotten(tempGrid, i, j)) {
                            changed = true;
                        }
                    }
                }
            }

            // If any new orange got rotten, increase count
            if (changed) count++;

            // Copy back the modified state
            grid = tempGrid;
        }

        // Final check for fresh oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1; // Fresh oranges remain
                }
            }
        }
        return count; // Return the total time taken
    }

    public boolean rotten(int[][] grid, int i, int j) {
        boolean changed = false;
        int rows = grid.length, cols = grid[0].length;

        if (i > 0 && grid[i - 1][j] == 1) { grid[i - 1][j] = 2; changed = true; } // Up
        if (i < rows - 1 && grid[i + 1][j] == 1) { grid[i + 1][j] = 2; changed = true; } // Down
        if (j > 0 && grid[i][j - 1] == 1) { grid[i][j - 1] = 2; changed = true; } // Left
        if (j < cols - 1 && grid[i][j + 1] == 1) { grid[i][j + 1] = 2; changed = true; } // Right

        return changed;
    }
}
