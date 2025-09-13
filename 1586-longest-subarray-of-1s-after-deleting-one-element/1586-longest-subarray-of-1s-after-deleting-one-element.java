class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        int zeroCount = 0;
        int res = 0;

        for(end = 0 ;end<nums.length;end++){
            if(nums[end] == 0){
                zeroCount +=1;
            }
            while(zeroCount > 1){
                if(nums[start] == 0){
                    zeroCount--;
                }
                start++;
            }
            res = Math.max(res, end-start);
        }
        return res;
    }
}