class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        this.small = new PriorityQueue<>((a, b) -> (b - a));
        this.large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        small.add(num);

        if ((!large.isEmpty() && small.peek() > large.peek())) {
            large.add(small.poll());
        }

        if (small.size() - large.size() > 1) {
            large.add(small.poll());
        }

        if (large.size() > small.size()) {
            small.add(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() == large.size()) {
            return (double) (small.peek() + large.peek()) / 2;
        } else {
            return (double) small.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */