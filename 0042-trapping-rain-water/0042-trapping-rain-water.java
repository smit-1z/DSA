class Solution {
    public int trap(int[] height) {
        int lMax = 0;
        int rMax = 0;
        int l = 0;
        int r = height.length - 1;
        int res = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                lMax = Math.max(height[l], lMax);
                res += lMax - height[l++];
            } else {
                rMax = Math.max(height[r], rMax);
                res += rMax - height[r--];
            }
        }
        return res;
    }
}