class Solution {
    boolean[][] covered;

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        int m = grid.length;
        int n = grid[0].length;
        this.covered = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!covered[i][j] && grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || covered[i][j] || grid[i][j] != 1) {
            return 0;
        }
        covered[i][j] = true;
        return 1 +
                dfs(grid, i + 1, j) +
                dfs(grid, i - 1, j) +
                dfs(grid, i, j + 1) +
                dfs(grid, i, j - 1);
    }
}