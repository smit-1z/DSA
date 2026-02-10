class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode curr = slow.next;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 3: Split the list into two halves
        slow.next = null;

        // Step 4: Merge two halves
        ListNode p1 = head;
        ListNode p2 = prev;

        while(p2 != null){
            ListNode p1Next = p1.next;
            ListNode p2Next = p2.next;

            p1.next = p2;
            p2.next = p1Next;

            p1 = p1Next;
            p2 = p2Next;
        }
    }
}