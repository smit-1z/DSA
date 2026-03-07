class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int res = 0;

        for (int i = 1; i < n; i++) {
            //increasig sequence
            int count = 1;
            boolean decreasing = false;
            int j = i;

            while (j < n && arr[j] > arr[j - 1]) {
                count++;
                j++;
            }

            while (i != j && j < n && arr[j] < arr[j-1]) {
                decreasing = true;
                count++;
                j++;
            }
            if (count > 2 && decreasing) {
                res = Math.max(res, count);
            }
        }

        return res;
    }
}