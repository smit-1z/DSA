class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        this.res = new ArrayList<>();
        backTrack(nums,0,new ArrayList<>());
        return res;
    }

    public void backTrack(int[] nums, int start, List<Integer> list){
        if(start >nums.length) return;
        res.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            backTrack(nums, i+1, list);
            list.removeLast();
        }
    }
}