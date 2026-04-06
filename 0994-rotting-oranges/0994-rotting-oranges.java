class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

        int time = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();
                for (int[] dir : dirs) {
                    int x = orange[0] + dir[0];
                    int y = orange[1] + dir[1];

                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[] { x, y });
                        fresh--;
                    }
                }
            }
            time++;
        }

        if (fresh == 0)
            return time;
        return -1;
    }
}