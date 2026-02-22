class Solution {
    public int trap(int[] height) {
        int lMax = 0;
        int rMax = 0;
        int l = 0;
        int r = height.length-1;
        int res = 0;

        while(l < r){
            if(height[l] < height[r]){
                lMax = Math.max(lMax, height[l]);
                res += lMax - height[l];
                l++;
            }else{
                rMax = Math.max(rMax,height[r]);
                res += rMax - height[r];
                r--;
            }
        }

        return res;
    }
}