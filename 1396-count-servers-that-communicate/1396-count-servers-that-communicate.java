class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            int num = 0;
            int col = -1;
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1){
                    col = j;
                    num++;
                }
            }
            if(num == 1){
                int serversInCol = 0;
                for(int j = 0;j<m;j++){
                    if(grid[j][col] == 1) serversInCol++; 
                }
                if(serversInCol > 1){
                    count+= num;
                }
            }else{
                count += num;
            }
        }
        return count;
    }
}