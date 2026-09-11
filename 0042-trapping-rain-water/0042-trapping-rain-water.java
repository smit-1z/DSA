class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length-1;

        int lMax = 0;
        int rMax = 0;
        int res =0;

        while(l <=r){
            if(height[l] < height[r]){
                lMax = Math.max(height[l], lMax);
                res+=lMax - height[l];
                l++;
            }else{
                rMax = Math.max(height[r], rMax);
                res+=rMax - height[r];
                r--;
            }
        }

        return res;
    }
}