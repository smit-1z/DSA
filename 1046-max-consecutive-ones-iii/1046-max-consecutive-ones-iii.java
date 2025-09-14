class Solution {
    public int longestOnes(int[] nums, int k) {
     int start = 0;
     int end =0;

     for(end = 0;end < nums.length;end++){
        if(nums[end] == 0){
            k--;
        }

        if(k<0){
            if(nums[start] == 0){
                k++;
            }
            start++;
        }
     }   

     return end - start ;
    }
}