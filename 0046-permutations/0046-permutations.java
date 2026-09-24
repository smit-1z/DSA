class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        this.res = new ArrayList<>();
        backTrack(nums,  new ArrayList<>());
        return res;
    }

    public void backTrack(int[] nums,  ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;

        }

        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                backTrack(nums, list);
                list.removeLast();
            }
        }
    }
}