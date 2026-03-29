class Solution {
    public int trap(int[] height) {
        int maxR = 0;
        int maxL = 0;
        int l = 0;
        int r = height.length - 1;
        int maxWater = 0;
        int water =0;
        while(l < r){
            if(height[l] < height[r]){
                maxL = Math.max(maxL, height[l]);
                water = maxL - height[l];
                l++;
            }else{
                maxR = Math.max(maxR, height[r]);
                water = maxR - height[r];
                r--;
            }

            maxWater += water;   
        }
        return maxWater;
    }
}