class Solution {
    public int search(int[] nums, int target) {
        //find the pivot index 
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
        int pivot = r;

        // determine which half to search

        r =  nums.length -1;

        if(target >= nums[pivot] && target <= nums[r]){
           l = pivot;
        }else{
            l = 0;
            r = pivot - 1;
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