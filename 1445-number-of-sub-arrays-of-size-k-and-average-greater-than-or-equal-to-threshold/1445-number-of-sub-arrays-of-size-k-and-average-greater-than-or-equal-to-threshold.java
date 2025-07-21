class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int sum = 0;
        int L = 0;

        for (int R = 0; R < arr.length; R++) {

            sum += arr[R];

            if (R >= k-1) {
                if(sum/k >= threshold) res++; 
                sum -= arr[L++];
            }
        }
        return res;
    }
}