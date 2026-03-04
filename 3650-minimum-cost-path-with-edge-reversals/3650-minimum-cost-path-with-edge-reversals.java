class Solution {
    public int minCost(int n, int[][] edges) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph[u].add(new int[] { u, v, w });
            graph[v].add(new int[] { v, u, w * 2 });
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[] { 0, 0 }); // cost,nodeID

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int cost = curr[0];
            int node = curr[1];

            if (cost > dist[node])
                continue;

            for (int[] edge : graph[node]) {
                int next = edge[1];
                int nextDist = edge[2];

                int newDist = nextDist + cost;
                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    minHeap.offer(new int[] { newDist, next });
                }
            }
        }

        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }
}