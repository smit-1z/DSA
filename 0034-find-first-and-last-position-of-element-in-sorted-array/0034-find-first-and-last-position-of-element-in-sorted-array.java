class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] { search(nums, target, -1), search(nums, target, 1) };
    }

    public int search(int[] nums, int target, int dir) {
        int start = 0;
        int end = nums.length - 1;
        int returnIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                returnIndex = mid;
                if (dir == -1) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return returnIndex;
    }
}