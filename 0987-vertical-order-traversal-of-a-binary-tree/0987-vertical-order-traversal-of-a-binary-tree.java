class Solution {
    Map<Integer, List<int[]>> map = new HashMap<>();
    int min = 0;
    int max = 0;

    public void buildMap(TreeNode root, int x, int y) {
        max = Math.max(y, max);
        min = Math.min(y, min);

        map.computeIfAbsent(y, k -> new ArrayList<>());
        map.get(y).add(new int[] { x, root.val });
        if (root.left != null)
            buildMap(root.left, x + 1, y - 1);
        if (root.right != null)
            buildMap(root.right, x + 1, y + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        buildMap(root, 0, 0);

        for (int i = min; i <= max; i++) {
            List<int[]> nodesInCurrentLevel = map.get(i);
            Collections.sort(nodesInCurrentLevel, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

            List<Integer> currLevel = new ArrayList<>();

            for (int[] node : nodesInCurrentLevel) {
                currLevel.add(node[1]);
            }

            res.add(currLevel);
        }

        return res;
    }
}