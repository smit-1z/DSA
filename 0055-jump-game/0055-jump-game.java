class Solution {
    public boolean canJump(int[] nums) {
        int furthest = 0;
        int i =0 ;
        while(i < nums.length && i <= furthest && furthest < nums.length-1){
            furthest = Math.max(nums[i] + i, furthest);
            i++;
        }
        return furthest >= nums.length-1;
    }
}