class Solution {
    public List<List<String>> solveNQueens(int n) {
         List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize the board with '.' (empty spaces)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        // Call the backtracking function to find all solutions
        solveNQueens(n, 0, board, result);
        return result;
    }

    // Backtracking function to find all solutions
    private static void solveNQueens(int n, int row, char[][] board, List<List<String>> result) {
        // If we have placed queens in all rows, add the current board configuration to result
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }
            result.add(solution);
            return;
        }

        // Try placing a queen in each column for the current row
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q'; // Place the queen
                solveNQueens(n, row + 1, board, result); // Recursively try to place queens in the next row
                board[row][col] = '.'; // Backtrack (remove the queen)
            }
        }
    }

    // Function to check if placing a queen at board[row][col] is safe
    private static boolean isSafe(char[][] board, int row, int col, int n) {
        // Check the column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check the diagonal (top-left to bottom-right)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the diagonal (top-right to bottom-left)
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // If no conflicts are found, it's safe to place the queen
        return true;
    

    }
}