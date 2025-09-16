class Node{

    int key;
    int val;
    Node prev ;
    Node next ;

    Node(int key, int val){
        this.key =key;
        this.val =val;
    }
}
class LRUCache {
    Node head;
    Node tail;

    HashMap<Integer,Node> map ;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(0,0);
        this.tail = new Node(0,0);

        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            remove(map.get(key));
            add(map.get(key));
            return map.get(key).val;
        }

        return -1;
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

    public void add(Node newNode){
        Node tailPrev = tail.prev;
        tail.prev = newNode;
        newNode.prev =tailPrev;
        newNode.next = tail;
        tailPrev.next = newNode;
    }

    public void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */