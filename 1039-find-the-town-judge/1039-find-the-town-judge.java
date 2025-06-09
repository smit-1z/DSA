class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] votes = new int[n + 1];
        Set<Integer> set = new HashSet<>();

        for (int[] pair : trust) {
            votes[pair[1]]++;
            set.add(pair[0]);
        }


        for (int i = 1; i < votes.length; i++) {
            if (votes[i] == n - 1 && !set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}