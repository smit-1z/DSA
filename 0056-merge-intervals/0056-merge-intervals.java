class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int index = 0;

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if(intervals[index][1] >= interval[0]){
                intervals[index][1] = Math.max(intervals[index][1], interval[1]);
            }else{
                index++;
                intervals[index] = interval;
            }
        }
        return Arrays.copyOf(intervals, index+1);
    }
}