class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < points.length; i++) {
            int dist = (points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            if(queue.size() < k){
                queue.offer(new int[]{dist,i});
            }else if(queue.peek()[0] > dist){
                queue.remove();
                queue.offer(new int[]{dist,i});
            }
        }

        int[][] res = new int[k][2];

        for(int i =0;i<k;i++){
            res[i] = points[queue.remove()[1]];
    }

return res;
    }
}