class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = (m * n) - 1;
        int mid, midElement ;

        while (l <= r) {
            mid = l + (r - l) / 2;
            midElement = matrix[mid / n][mid % n];
            
            if(target == midElement){
                return true;
            }else if(target > midElement){
                l = mid + 1;
            }else{
                r = mid-1;
            }
        }
        return false;
    }
}