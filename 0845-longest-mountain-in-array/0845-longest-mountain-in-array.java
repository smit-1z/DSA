class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int i = 1;
        int res = 0;

        while (i < n - 1) {
            if (arr[i] > arr[i-1] && arr[i] > arr[i + 1]) {
                int left = i;
                int right = i;

                while (left > 0 && arr[left-1] < arr[left]) {
                    left--;
                }

                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                res = Math.max(res, right - left + 1);
                i = right;
            } else {
                i++;
            }
        }
        return res;
    }
}