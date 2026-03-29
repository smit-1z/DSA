class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int num : set) {
            int curRes = 0;
            int curNum = num;
            if (!set.contains(curNum - 1)) {
                while (set.contains(curNum)) {
                    curNum++;
                    curRes++;
                }
                max = Math.max(curRes, max);
            }
        }

        return max;
    }
}