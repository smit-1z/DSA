class Solution {
        List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        backtrack(nums, 0, new ArrayList<Integer>());

        return res;
    }

    public void backtrack(int[] nums, int pos, List<Integer> current) {
        res.add(new ArrayList<>(current));
        for (int i = pos; i < nums.length; i++) {
        if(i > pos && nums[i] == nums[i-1]) continue;
            current.add(nums[i]);
            backtrack(nums, i + 1, current);
            current.removeLast();
        }
    }

}