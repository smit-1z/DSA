class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num:nums){
            set.add(num);
        }

        int max = 0;
        int i =0;

        while(i < nums.length){
            if(!set.contains(nums[i] + 1)){
                int count = 1;
                int diff = 1;
                while(set.contains(nums[i] - diff)){
                    count++;
                    diff++;
                }

                max = Math.max(count, max);
            }
            i++;
        }

        return max;
    }
}