class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        boolean seenTwice = false;

        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                if(seenTwice){
                    continue;
                }else{
                    seenTwice = true;
                }
            }else{
                seenTwice = false;
            }
            nums[index++] =  nums[i];
        }

        return index;
    }
}