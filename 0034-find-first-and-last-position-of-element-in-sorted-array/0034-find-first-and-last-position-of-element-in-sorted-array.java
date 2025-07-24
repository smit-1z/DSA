class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findPos(nums,target,-1),findPos(nums,target,1)};
    }

    public int findPos(int[] nums,int target, int dir){
        int start = 0;
        int end = nums.length-1;
        int pos = -1;
        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] == target){
                pos = mid;
                if(dir == -1){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else if(nums[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return pos;
    }   
}