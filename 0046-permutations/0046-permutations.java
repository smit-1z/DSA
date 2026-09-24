class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        this.res = new ArrayList<>();
        backTrack(nums,  new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    public void backTrack(int[] nums,  ArrayList<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;

        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
                used[i] = true;
                list.add(nums[i]);
                backTrack(nums, list,used);
                used[i] = false;
                list.removeLast();
        }
    }
}