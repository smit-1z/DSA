class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, new ArrayList<>());
        return res;
    }

    public void backTrack(int[] candidates, int remaining, int pos, List<Integer> current) {

        if (remaining == 0) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            if (remaining < candidates[i]) {
                break;
            }
            if (i > pos && candidates[i] == candidates[i - 1])
                continue;
            current.add(candidates[i]);
            backTrack(candidates, remaining - candidates[i], i + 1, current);
            current.removeLast();
        }
    }
}
