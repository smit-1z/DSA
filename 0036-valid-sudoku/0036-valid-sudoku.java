class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rowSets = new ArrayList<>();
        List<Set<Character>> colSets = new ArrayList<>();
        List<Set<Character>> gridSets = new ArrayList<>();

        for(int i=0;i<9;i++){
            rowSets.add(new HashSet<>());
            colSets.add(new HashSet<>());
            gridSets.add(new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    char num = board[i][j];
                    int grid = (j / 3) + 3 * (i / 3);

                    if (rowSets.get(i).contains(num) || colSets.get(j).contains(num)
                            || gridSets.get(grid).contains(num)) {
                        return false;
                    } else {
                        rowSets.get(i).add(num);
                        colSets.get(j).add(num);
                        gridSets.get(grid).add(num);
                    }
                }
            }
        }
        return true;
    }
}