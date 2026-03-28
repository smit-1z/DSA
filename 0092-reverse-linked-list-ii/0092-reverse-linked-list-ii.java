class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevNode = dummy;
        ListNode curr = head;

        for(int i = 0;i<left-1;i++){
            prevNode = curr;
            curr = curr.next;
        }

        ListNode prev = null;

        for(int i=left;i<=right;i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        prevNode.next.next = curr;
        prevNode.next = prev;
        
        return dummy.next;
    }
}