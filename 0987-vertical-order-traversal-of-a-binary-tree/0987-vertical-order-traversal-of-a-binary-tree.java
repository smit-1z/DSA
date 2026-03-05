
import java.util.Collection;class Solution {
    Map<Integer,List<int[]>> map ;
    int min = 0;
    int max = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>  res = new ArrayList<>();
        if(root == null) return res;

        this.map = new HashMap<>();
        dfs(root,0,0);


        for(int i=min;i<=max;i++){
            List<int[]> nodesInACol = map.get(i);
            Collections.sort(nodesInACol, (a,b) -> a[0] == b[0] ? a[1] - b[1]: a[0] - b[0]);
            List<Integer> currentLevel = new ArrayList<>();

            for(int [] node:nodesInACol){
                currentLevel.add(node[1]);
            }
            res.add(currentLevel);
    }

        return res;
    }
    public void dfs(TreeNode root, int row, int col){

        min = Math.min(min, col);
        max = Math.max(max, col);

        map.computeIfAbsent(col, k-> new ArrayList<>()).add(new int[]{row,root.val});

        if(root.left != null){
            dfs(root.left,row+1,col-1);
        }

        if(root.right != null){
            dfs(root.right,row+1,col+1);
        }
    }
}