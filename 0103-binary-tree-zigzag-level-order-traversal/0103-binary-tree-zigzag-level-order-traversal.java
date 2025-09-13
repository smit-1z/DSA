class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> nodesInCurrentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                
                nodesInCurrentLevel.add(node.val);
            }

            if(res.size() % 2 == 0){
                res.add(nodesInCurrentLevel);
            }else{
                res.add(nodesInCurrentLevel.reversed());
            }
        }

        return res;
    }
}