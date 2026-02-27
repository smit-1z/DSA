class Solution {
    int maxArea = 0;
    int[][] seen;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        this.seen = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && seen[i][j] == 0) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1 || seen[x][y] == 1) {
            return 0;
        }

        seen[x][y] = 1;

        return 1 + dfs(grid, x, y + 1) + dfs(grid, x, y - 1) + dfs(grid, x + 1, y) + dfs(grid, x - 1, y);
    }
}