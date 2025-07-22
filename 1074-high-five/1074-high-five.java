class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

        for (int[] item : items) {
            int id = item[0];
            int score = item[1];

            map.computeIfAbsent(id, k -> new PriorityQueue<>());
            map.get(id).add(score);
            if (map.get(id).size() > 5)
                map.get(id).poll();
        }
        int[][] res = new int[map.size()][2];
        int counter = 0;

        for (int id : map.keySet()) {
            res[counter][0] = id;
            int sum = 0;
            while (!map.get(id).isEmpty()) {
                sum += map.get(id).poll();
            }
            res[counter++][1] = sum / 5;
        }

        return res;
    }
}