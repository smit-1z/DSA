class Solution {
    public int[][] merge(int[][] intervals) {
        int index = 0;
        Arrays.sort(intervals, (a,b) -> a[0] -b[0]);

        for(int[] interval: intervals){
            if(intervals[index][1] >= interval[0]){
                intervals[index][1] = Math.max(interval[1],intervals[index][1]);
            }else{
                index++;
                intervals[index] =interval;
            }
        }

        return Arrays.copyOf(intervals, index+1);
    }
}