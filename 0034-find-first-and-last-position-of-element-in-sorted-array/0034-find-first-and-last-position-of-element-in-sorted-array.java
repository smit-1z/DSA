class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] { findFirstAndLast(nums, target, -1), findFirstAndLast(nums, target, 1) };
    }

    public int findFirstAndLast(int[] nums, int target, int dir) {
        int returnIdx = -1;
        int start = 0;

        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                if (dir == -1) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                returnIdx = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return returnIdx;
    }
}