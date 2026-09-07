public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder ser = new StringBuilder();
        dfs(root, ser);
        return ser.toString();
    }

    public void dfs(TreeNode root, StringBuilder ser) {
        if (root == null) {
            ser.append("N,");
            return;
        }
        ser.append(root.val).append(",");
        dfs(root.left, ser);
        dfs(root.right, ser);
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] pos = { 0 };
        return dfs2(nodes, pos);
    }

    public TreeNode dfs2(String[] nodes, int[] pos) {
       if (nodes[pos[0]].equals("N")){
            pos[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[pos[0]]));
        pos[0]++;
        root.left = dfs2(nodes,pos);
        root.right = dfs2(nodes,pos);
        return root;
    }
}