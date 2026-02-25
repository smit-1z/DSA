class LFUCache {
    public static class Node {
        int key;
        int val;
        int freq;

        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
            this.prev = null;
            this.next = null;
        }
    }

    public static class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            this.tail.prev = head;
            this.head.next = tail;
            this.size = 0;
        }

        public void addNode(Node node) {
            Node next = head.next;
            head.next = node;
            node.next = next;
            node.prev = head;
            next.prev = node;
            size++;
        }

        public void removeNode(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }

        public Node removeLast() {
            if (this.size > 0) {
                Node lruNode = tail.prev;
                removeNode(lruNode);
                return lruNode;
            }
            return null;
        }
    }

    public final int capacity;
    int minFreq = 0;
    Map<Integer, Node> cache;
    Map<Integer, DoublyLinkedList> freqList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freqList = new HashMap<>();
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        touch(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.val = value;
            touch(node);
            return;
        }
        if(cache.size() == capacity){
            DoublyLinkedList minList = freqList.get(minFreq);
            Node evict = minList.removeLast();
            cache.remove(evict.key);
        }

        Node newNode = new Node(key,value);
        cache.put(key,newNode);
        minFreq = 1;
        freqList.computeIfAbsent(minFreq, k ->new DoublyLinkedList()).addNode(newNode);
    }

    public void touch(Node node){
        int freq = node.freq;
        DoublyLinkedList oldList = freqList.get(freq);
        oldList.removeNode(node);
        if(freq == minFreq && oldList.size == 0){
            minFreq++;
        }
        node.freq++;
        freqList.computeIfAbsent(node.freq,k->new DoublyLinkedList()).addNode(node);
    }
}