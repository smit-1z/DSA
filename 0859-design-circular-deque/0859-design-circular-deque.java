class Node{
    Node next;
    Node prev;
    int val;

    Node(int val){
        this.val = val;
    }
}
class MyCircularDeque {
    int capacity;
    int usedCapacity = 0;
    Node head;
    Node tail;

    public MyCircularDeque(int k) {
        this.capacity = k;
        this.head = new Node(-1);
        this.tail = new Node(-1);


        head.next = tail;
        tail.prev = head;

    }
    
    public boolean insertFront(int value) {
        if(usedCapacity == capacity) return false;
        Node node = new Node(value);
        usedCapacity++;

        Node tailPrev = tail.prev;
        tail.prev = node;
        node.next = tail;
        node.prev = tailPrev;
        tailPrev.next = node;

        return true;

    }
    
    public boolean insertLast(int value) {
        if(usedCapacity == capacity) return false;

        Node node = new Node(value);
        usedCapacity++;

        Node headNext = head.next;
        head.next = node;
        node.next = headNext;
        node.prev = head;
        headNext.prev = node;

        return true;
    }
    
    public boolean deleteFront() {
        if(usedCapacity == 0) return false; 
        usedCapacity--;

        tail.prev = tail.prev.prev;
        tail.prev.next = tail;

        return true;
    }
    
    public boolean deleteLast() {
        if(usedCapacity == 0) return false;
        usedCapacity--;

        head.next = head.next.next;
        head.next.prev = head;
        
        return true;
    }
    
    public int getFront() {
        if(usedCapacity == 0) return -1;
        
        return tail.prev.val;
    }
    
    public int getRear() {
        if(usedCapacity == 0) return -1;
        
        return head.next.val;
    }
    
    public boolean isEmpty() {
        if(usedCapacity == 0) return true;
        else return false;
    }
    
    public boolean isFull() {
        if(usedCapacity == capacity) return true;
        else return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */