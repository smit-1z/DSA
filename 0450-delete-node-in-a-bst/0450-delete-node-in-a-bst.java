class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            else {
                TreeNode n = root.right;

                while (n.left != null) {
                    n = n.left;
                }

                n.left = root.left;
                TreeNode res = root.right;
                return res;
            }
        }
        return root;
    }
}