class Node {
    Node next;
    Node prev;
    int key;
    int val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> map;

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
        return node.val;
    }

   public void put(int key, int value) {
    if (map.containsKey(key)) {
        Node node = map.get(key);
        node.val = value;
        remove(node);
        add(node);
    } else {
        Node node = new Node(key, value);
        map.put(key, node);
        add(node);
    }

    if (map.size() > capacity) {
        Node lru = tail.prev;
        remove(lru);
        map.remove(lru.key);
    }
}

    public void add(Node node) {
        Node next = head.next;
        node.next = next;
        node.prev = head;
        head.next = node;
        next.prev = node;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}