class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }

    public void backTrack(int[] candidates, int target, int start, ArrayList<Integer> curr, int curSum) {
        if (curSum == target) {
            res.add(new ArrayList<>(curr));
            
        }

        for (int i = start; i < candidates.length; i++) {
            curSum += candidates[i];
            if(curSum >target){
                break;
            }
            curr.add(candidates[i]);
            if (curSum <= target) {
                backTrack(candidates, target, i, curr, curSum);
            }
            curSum -= candidates[i];
            curr.removeLast();
        }
    }
}