class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement  = nums[0];
        int countOfMajorityElement = 0;
        for(int num:nums){
            if(num == majorityElement){
                countOfMajorityElement++;
            }else if(countOfMajorityElement > 0){
                countOfMajorityElement--;
            }else{
                countOfMajorityElement = 1;
                majorityElement = num;
            }
        }
        return majorityElement;
    }
}