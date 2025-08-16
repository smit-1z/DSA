class Solution {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;

        while(nextNode.next != null){
            node.val = nextNode.val;
            node = node.next;
            nextNode = nextNode.next;
        }
        node.val = nextNode.val;
        node.next = null;

    }
}