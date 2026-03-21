class Solution {
    boolean[][] seen;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        this.seen = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !seen[i][j]) {
                    res++;
                    dfs(i, j, grid);
                }
            }
        }

        return res;
    }

    public void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || seen[i][j] || grid[i][j] != '1') {
            return;
        }
        seen[i][j] = true;
        dfs(i + 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i - 1, j, grid);
        dfs(i, j - 1, grid);
    }
}