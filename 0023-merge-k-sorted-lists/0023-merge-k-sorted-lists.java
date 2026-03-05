class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        return divideAndConquer(lists,0,lists.length-1);
    }

    public ListNode divideAndConquer(ListNode[] lists,int start ,int end){
        if(start == end){
            return lists[start];
        }

        int mid = start + (end - start)/2;

        ListNode l = divideAndConquer(lists, start, mid);
        ListNode r = divideAndConquer(lists, mid+1, end);

        return merge(l,r);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l1 != null){
            curr.next = l1;
        }
        if(l2 != null){
            curr.next = l2;
        }

        return dummyNode.next;
    }
}