class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int pivot = -1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        pivot = start;

        end = nums.length - 1;

        if (target >= nums[pivot] && target <= nums[end]) {
            start = pivot;
        } else {
            start = 0;
            end = pivot - 1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;

            } else {
                end = mid - 1;
            }
        }

        return -1;

    }
}