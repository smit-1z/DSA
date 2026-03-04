class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] time : times) {
            adj.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[] { time[1], time[2] });
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Set<Integer> visited = new HashSet<>();
        int t = 0;

        minHeap.offer(new int[] { 0, k });

        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            int weight = node[0];
            int curr = node[1];

            if (visited.contains(curr)) continue;
                
            visited.add(curr);

            t = weight;
            
            if (adj.containsKey(curr)) {
                for (int[] next : adj.get(curr)) {
                    int nextNode = next[0];
                    int nextWeight = next[1];
                    minHeap.offer(new int[]{nextWeight+weight, nextNode});
                }
            }
        }
        return visited.size() == n? t:-1;
    }
}