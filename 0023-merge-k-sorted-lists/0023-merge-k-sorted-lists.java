class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return divide(lists, 0, lists.length - 1);
    }

    public ListNode divide(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;

        ListNode List1 = divide(lists, start, mid);
        ListNode List2 = divide(lists, mid + 1, end);

        return merge(List1, List2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);

        ListNode temp = dummyNode;

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

        return dummyNode.next;
    }
}