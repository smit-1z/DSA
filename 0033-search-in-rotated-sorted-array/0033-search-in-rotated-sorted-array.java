class Solution {
    public int search(int[] nums, int target) {
        //find the pivot index 
        int pivot = 0;
        int l = 0;
        int r =  nums.length -1;

        while(l < r){
            int mid = l + (r - l)/2;

            if(nums[mid] > nums[r]){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        pivot = r;

        // determine which half to search

        l = 0;
        r =  nums.length -1;

        if(target >= nums[l] && target <= nums[pivot - 1]){
            r = pivot-1;
        }else{
            l = pivot;
        }

        // search that half
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid+1;
            }
        }

        return -1;
    }
}