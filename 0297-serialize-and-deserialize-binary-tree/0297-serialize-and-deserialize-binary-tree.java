import java.util.StringTokenizer;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,"); // Use "#" instead of "null" to save space
            return;
        }
        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringTokenizer tokenizer = new StringTokenizer(data, ",");
        return createTree(tokenizer);
    }

    private TreeNode createTree(StringTokenizer tokenizer) {
        if (!tokenizer.hasMoreTokens()) return null;
        
        String val = tokenizer.nextToken();
        if (val.equals("#")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = createTree(tokenizer);
        root.right = createTree(tokenizer);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
