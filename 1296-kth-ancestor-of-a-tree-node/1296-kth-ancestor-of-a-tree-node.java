class TreeAncestor {
    private int[][] anc; // Binary lifting table
    private static final int LOG = 30; // Maximum power of 2 within constraints

    public TreeAncestor(int n, int[] parent) {
        anc = new int[n][LOG];
        for (int i = 0; i < n; i++) {
            Arrays.fill(anc[i], -1); // Initialize ancestors with -1
        }

        // Fill the immediate parent information
        for (int i = 0; i < n; i++) {
            anc[i][0] = parent[i];
        }

        // Fill ancestors for higher powers of 2
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                if (anc[i][j - 1] != -1) {
                    anc[i][j] = anc[anc[i][j - 1]][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int currNode = node;
        for (int i = 0; i < LOG; i++) {
            if (((1 << i) & k) != 0) { // Check if the i-th bit in k is set
                currNode = anc[currNode][i];
                if (currNode == -1) return -1; // No valid ancestor
            }
        }
        return currNode;
    }
}


/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */