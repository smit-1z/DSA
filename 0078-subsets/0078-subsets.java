class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums, 0, new ArrayList<>());
        return res;
    }

    public void backTrack(int[] nums, int start, List<Integer> current) {
        res.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backTrack(nums, i + 1, current);
            current.removeLast();
        }
    }
}