class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement = nums[0];
        int countOfMajorityElement = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] == majorityElement) countOfMajorityElement++;
            else countOfMajorityElement--;

            if(countOfMajorityElement == 0){
                countOfMajorityElement = 1;
                majorityElement = nums[i];
            }
        }

        return majorityElement;
    }
}