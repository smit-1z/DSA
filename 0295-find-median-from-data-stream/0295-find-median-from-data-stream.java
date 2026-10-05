class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        this.min = new PriorityQueue<>();
        this.max = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        min.add(num);

        if (!max.isEmpty() &&  min.peek() > max.peek()) {
            max.add(min.poll());
        }

        if(min.size() - max.size() > 1){
            max.add(min.poll());
        }

        if(max.size() > min.size()){
            min.add(max.poll());
        }
    }

    public double findMedian() {
        if(min.size() == max.size()) return (double) (min.peek() + max.peek()) / 2;

        return (double)  min.peek();
    }
}