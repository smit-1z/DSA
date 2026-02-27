class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = 0;

        for(int num:nums){
            sum+=num;
            if(sum < 0){
                sum = 0;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}