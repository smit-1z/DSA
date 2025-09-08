class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        for(int[] interval:intervals){
            if(res.isEmpty() || res.getLast()[1] < interval[0]){
                res.add(interval);
            }else if(res.getLast()[1] >= interval[0]){
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}