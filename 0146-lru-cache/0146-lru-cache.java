class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
            map.remove(key);
        }

        Node n = new Node(key,value);
        map.put(key, n);
        add(n);
        if(map.size() >capacity){
            map.remove(tail.prev.key);
            remove(tail.prev);
        }
    }

    public void add(Node n){
        Node headNext = head.next;
        head.next = n;
        n.prev = head;
        n.next = headNext;
        headNext.prev = n;
    }

    public void remove(Node n){
        n.next.prev = n.prev;
        n.prev.next = n.next;
    }
}