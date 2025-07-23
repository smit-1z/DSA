class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            int i = 1;

            while (i < k) {
                queue.add(queue.poll());
                i++;
            }

            queue.poll();

        }

        return queue.peek();

    }
}