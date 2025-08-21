class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, HashSet<Character>> row = new HashMap<>();
        Map<Integer, HashSet<Character>> col = new HashMap<>();
        Map<Integer, HashSet<Character>> grid = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
            grid.put(i, new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int gridId = (i / 3) * 3 + j / 3;
                    if (row.get(i).contains(board[i][j]) || col.get(j).contains(board[i][j])
                            || grid.get(gridId).contains(board[i][j])) {
                        return false;
                    }

                    row.get(i).add(board[i][j]);
                    col.get(j).add(board[i][j]);
                    grid.get(gridId).add(board[i][j]);
                }
            }
        }

        return true;
    }
}