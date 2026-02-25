class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }

                currentLevel.add(node.val);
            }


            res.add(currentLevel);
        }
            Collections.reverse(res);

        return res;
    }
}