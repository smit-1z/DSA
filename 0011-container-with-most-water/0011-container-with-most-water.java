class Solution {
    public int maxArea(int[] height) {
        int water = 0;

        int l =0; 
        int r = height.length-1;
        int currentWater = 0;
        while(l < r){
            if(height[l] < height[r]){
                currentWater = height[l] * (r-l);
                l++;
            }else{
                currentWater = height[r] * (r - l);
                r--;
            }
            water = Math.max(currentWater,water);
        }
        return water;
    }
}