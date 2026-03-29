class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int max = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int len = 0;

                while (set.contains(cur++)) {
                    len++;
                }

                max = Math.max(max, len);
            }
        }

        return max;
    }
}