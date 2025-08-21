class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums,new ArrayList<>(),0);
        return res;
    }

    public void backTrack(int[] nums, List<Integer> curr, int pos){
        res.add(new ArrayList<>(curr));

        for(int i=pos;i<nums.length;i++){
            if(i > pos && nums[i] == nums[i-1]){
                continue;
            } 

            curr.add(nums[i]);
            backTrack(nums, curr, i+1);
            curr.removeLast();
        }
    }
}