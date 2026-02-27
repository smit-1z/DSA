class Solution {
    int min = 0;
    int max = 0;
    Map<Integer,List<int[]>> map ;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>  res = new ArrayList<>();
        if(root == null) return res;
        this.map = new HashMap<>();
        buildMap(root,0,0);

        for(int i=min;i<=max;i++){
            List<int[]> nodesInACol = map.get(i);

            Collections.sort(nodesInACol, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            List<Integer> currLevel = new ArrayList<>();

            for(int[] node: nodesInACol){
                currLevel.add(node[1]);
            }            
            res.add(currLevel);
        }
        return res;
    }

    public void buildMap(TreeNode root,int row, int col){
        
        min = Math.min(min, col);
        max = Math.max(max, col);
        
        map.computeIfAbsent(col, k-> new ArrayList<>()).add(new int[]{row, root.val});
        if(root.left != null) buildMap(root.left,row+1,col-1);
        if(root.right != null) buildMap(root.right,row+1,col+1);
    }
}