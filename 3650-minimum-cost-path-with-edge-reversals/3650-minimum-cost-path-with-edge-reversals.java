class Solution {
    public int minCost(int n, int[][] edges) {
         List<int[]>[] graph = new ArrayList[n];

         for(int i=0;i<n;i++)
            graph[i] = new ArrayList<>();

        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph[u].add(new int[]{u,v,w});
            graph[v].add(new int[]{v,u,2*w});
        }

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b)->a[0]-b[0]);

        pq.offer(new int[]{0,0}); // cost, node

        dist[0] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cost = cur[0];
            int node = cur[1];

            if(cost > dist[node]){
                continue;
            }

            for(int[] nei:graph[node]){
                int next = nei[1];
                int nextDist = nei[2];
                int newCost = cost + nextDist;
                if(newCost < dist[next]){
                    dist[next] = newCost;
                pq.offer(new int[]{newCost,next});
                }
            }
        }

        return dist[n-1] == Integer.MAX_VALUE?-1:dist[n-1];
    }
}