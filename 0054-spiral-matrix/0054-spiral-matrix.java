class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int startrow = 0;
        int startcol = 0;
        int endrow = matrix.length - 1;
        int endcol = matrix[0].length - 1;

        while (startrow <= endrow && startcol <= endcol) {
            // Traverse from left to right across the top row
            for (int j = startcol; j <= endcol; j++) {
                result.add(matrix[startrow][j]);
            }

            // Traverse from top to bottom along the right column
            for (int i = startrow + 1; i <= endrow; i++) {
                result.add(matrix[i][endcol]);
            }

            // Traverse from right to left along the bottom row
            for (int j = endcol - 1; j >= startcol; j--) {
                if (startrow == endrow) break; // Avoid duplicate traversal
                result.add(matrix[endrow][j]);
            }

            // Traverse from bottom to top along the left column
            for (int i = endrow - 1; i > startrow; i--) {
                if (startcol == endcol) break; // Avoid duplicate traversal
                result.add(matrix[i][startcol]);
            }

            // Update boundaries to move to the next inner layer
            startrow++;
            startcol++;
            endrow--;
            endcol--;
        }

        return result;
            
    }
}