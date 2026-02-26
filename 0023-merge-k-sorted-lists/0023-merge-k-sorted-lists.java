class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return divideAndConquer(lists, 0,lists.length-1);
    }

    public ListNode divideAndConquer(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;

        ListNode firstHalf = divideAndConquer(lists, start, mid);
        ListNode secondHalf = divideAndConquer(lists, mid + 1, end);

        return conquer(firstHalf, secondHalf);
    }

    public ListNode conquer(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if (l1 != null) {
            temp.next = l1;
        }

        if (l2 != null) {
            temp.next = l2;
        }
        return head.next;
    }
}

/*
145, 134, 26

145, 134 


36
*/