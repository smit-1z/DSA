class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> rows = new ArrayList<>();
        List<HashSet<Character>> cols = new ArrayList<>();
        List<HashSet<Character>> grid = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            grid.add(new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') continue;
                if (rows.get(i).contains(board[i][j])
                        || cols.get(j).contains(board[i][j]) || grid.get((i / 3 * 3) + j / 3).contains(board[i][j])) {
                    return false;
                }
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                grid.get((i / 3 * 3) + j / 3).add(board[i][j]);

            }
        }

        return true;

    }
}