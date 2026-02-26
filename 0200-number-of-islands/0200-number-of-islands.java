class Solution {
    boolean[][] seen ;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        this.seen = new boolean[m][n];
        int res = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && !seen[i][j]){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int x, int y) {
        if(x<0 || y<0 || x>= grid.length || y>=grid[0].length|| seen[x][y] || grid[x][y] != '1'){
            return;
        }
        seen[x][y] = true;

        dfs(grid, x,y+1);
        dfs(grid, x,y-1);
        dfs(grid, x+1,y);
        dfs(grid, x-1,y);
    }
}