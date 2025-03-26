public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] a = data.split(",");
        int[] index = {0}; // Use an array to keep track of index by reference
        return createTree(a, index);
    }

    private TreeNode createTree(String[] a, int[] index) {
        if (index[0] >= a.length || a[index[0]].equals("null")) {
            index[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(a[index[0]]));
        index[0]++;
        root.left = createTree(a, index);
        root.right = createTree(a, index);

        return root;
    }
}