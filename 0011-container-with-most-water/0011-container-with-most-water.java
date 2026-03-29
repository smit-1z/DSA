class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = 0;
        int curr = 0;
        
        while(l < r){
            if(height[l] < height[r]){
                curr = height[l] * (r - l);
                l++;
            }else{
                curr = height[r] * (r - l);
                r--;
            }

            max = Math.max(curr, max);
        }   

        return max;
    }
}