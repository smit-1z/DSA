class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, new ArrayList<>());
        return res;
    }

    public void backTrack(int[] candidates, int target, int pos, List<Integer> current) {

        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            if (target < candidates[i]) {
                break;
            }
            current.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i, current);
            current.removeLast();
        }
    }
}