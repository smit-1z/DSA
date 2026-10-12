class Solution {
    public boolean canJump(int[] nums) {
        int furthest = 0;

        for(int i =0;i <= furthest && furthest < nums.length;i++){
            furthest = Math.max(nums[i] + i, furthest);
        }
        return furthest >= nums.length;
    }
}