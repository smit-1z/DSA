class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0)  return intervals;
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        ArrayList<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for(int[] interval : intervals){
            if(res.getLast()[1] >= interval[0]){
                res.getLast()[1] = Math.max(interval[1],res.getLast()[1]);
            }else{
                res.add(interval);
            }
        }

        return  res.toArray(new int[res.size()][]);
    }
}