class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor != color) {
            dfs(image, sr, sc, originalColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int originalColor, int newColor) {
        // Boundary conditions
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }
        if (image[sr][sc] != originalColor) {
            return;
        }

        // Recolor the pixel
        image[sr][sc] = newColor;

        // Recursive calls in 4 directions
        dfs(image, sr - 1, sc, originalColor, newColor); // up
        dfs(image, sr + 1, sc, originalColor, newColor); // down
        dfs(image, sr, sc - 1, originalColor, newColor); // left
        dfs(image, sr, sc + 1, originalColor, newColor); // right
    }
}