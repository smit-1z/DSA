class Solution {
    Map<Integer, List<int[]>> map;
    int min = 0;
    int max = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        this.map = new HashMap<>();

        buildMap(root, 0, 0);

        for (int i = min; i <= max; i++) {
            List<int[]> nodesInACol = map.get(i);
            Collections.sort(nodesInACol, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            List<Integer> sortedNodesInaCol = new ArrayList<>();

            for (int[] sortedNodes : nodesInACol) {
                sortedNodesInaCol.add(sortedNodes[1]);
            }
            res.add(sortedNodesInaCol);
        }
        return res;
    }

    public void buildMap(TreeNode root, int x, int y) {
        min = Math.min(min, y);
        max = Math.max(max, y);

        map.computeIfAbsent(y, k -> new ArrayList<>());
        map.get(y).add(new int[] { x, root.val });

        if (root.left != null)
            buildMap(root.left, x + 1, y - 1);
        if (root.right != null)
            buildMap(root.right, x + 1, y + 1);

    }
}