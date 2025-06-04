class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();

        int idx = 0;
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            if (Math.abs(x - arr[idx]) > Math.abs(x - arr[i])) {
                idx = i;
            }
        }

        res.add(arr[idx]);

        int l = idx - 1;
        int r = idx + 1;

        while (res.size() != k) {
            if (l >= 0 && r < N) {
                if (Math.abs(x - arr[l]) < Math.abs(x - arr[r]) || Math.abs(x - arr[l]) == Math.abs(x - arr[r])) {
                    res.add(arr[l--]);
                } else {
                    res.add(arr[r++]);
                }
            } else if (l >= 0) {
                res.add(arr[l--]);
            } else if (r < N) {
                res.add(arr[r++]);
            }
        }

        Collections.sort(res);

        return res;
    }
}