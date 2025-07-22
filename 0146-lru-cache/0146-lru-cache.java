class Node {
    Node next;
    Node prev;
    int val;
    int key;

    public Node(int key, int val) {
        this.val = val;
        this.key = key;
    }
}

class LRUCache {
    int capacity;

    Map<Integer, Node> map;

    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;

        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        this.head.next = tail;
        this.tail.prev = head;
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
        if (map.containsKey(key))
            remove(map.get(key));

        Node node = new Node(key, value);

        map.put(key,node);
        add(node);

        if(map.size() >capacity){
            map.remove(head.next.key);
            remove(head.next);
        }
    }

    public void add(Node node) {
        Node tailPrev = tail.prev;

        node.next = tail;
        node.prev = tailPrev;

        tailPrev.next = node;
        tail.prev = node;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}