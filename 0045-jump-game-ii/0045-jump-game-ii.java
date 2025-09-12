class Solution {
    public int jump(int[] nums) {
        int l = 0;
        int r = 0;
        int furthest = 0;
        int steps = 0;

        while(r < nums.length -1){
            for(int i = l;i<=r;i++){
                furthest = Math.max(furthest,i + nums[i]);
            }

            l = r+1;
            r = furthest;
            steps++;
        }
        return steps;
    }
}