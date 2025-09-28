class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Integer>> row = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> col = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> grid = new HashMap<>();

        for(int i =0;i<9;i++){
            row.put(i,  new HashSet<>());
            col.put(i,  new HashSet<>());
            grid.put(i,  new HashSet<>());
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
               if(board[i][j] != '.'){
                 int c = board[i][j] - '0';
                int gridKey =(i/3 * 3) + j/3;

                if(row.get(i).contains(c) || col.get(j).contains(c) || grid.get(gridKey).contains(c)){
                    return false;
                }
                
                row.get(i).add(c);
                col.get(j).add(c);
                grid.get(gridKey).add(c);
               }
            }
        }

        return true;
    }
}