class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> map;

    Node head;
    Node tail;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        this.head.next = tail;
        this.tail.prev = head;

    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        remove(map.get(key));
        add(map.get(key));
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }

        Node newNode = new Node(key,value);
        map.put(key,newNode);
        add(newNode);

        if(map.size() > capacity){
            map.remove(head.next.key);
            remove(head.next);
        }
    }

    public void add(Node node){
        Node tailPrev = tail.prev;
        tail.prev = node;
        node.next = tail;
        node.prev = tailPrev;
        tailPrev.next = node;
    }

    public void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}