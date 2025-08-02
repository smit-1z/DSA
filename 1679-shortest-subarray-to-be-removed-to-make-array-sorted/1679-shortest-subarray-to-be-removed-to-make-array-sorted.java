class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        int n = arr.length;

        while(r > 0 && arr[r] >= arr[r-1]){
            r--;
        }

        int res = r;

        while(l < r){
            while(r<n && arr[l] >arr[r]){
                r++;
            }

            res = Math.min(res, r - l -1);
            l++;
            if(arr[l] < arr[l-1]){
                break;
            }
        }

        return res;
    }
}