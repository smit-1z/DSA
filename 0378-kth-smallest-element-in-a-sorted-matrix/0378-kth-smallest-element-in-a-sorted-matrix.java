class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(pq.size() < k){
                    pq.offer(matrix[i][j]);
                }else if(pq.peek() >= matrix[i][j]){
                    pq.poll();
                    pq.offer(matrix[i][j]);
                }
            }
        }

        return pq.peek();
    }
}