class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, new ArrayList<>());
        return res;
    }

    public void backTrack(int[] candidates, int remaining, int start, ArrayList<Integer> curr) {
        if (remaining == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if(candidates[i] > remaining){
                break;
            }
            curr.add(candidates[i]);
            backTrack(candidates, remaining-candidates[i], i, curr);
            curr.removeLast();
        }
    }
}