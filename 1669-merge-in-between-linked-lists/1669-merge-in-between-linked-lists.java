class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prevA = list1;

        for(int i=0;i<a-1;i++){
            prevA = prevA.next;
        }

        ListNode list2End = list2;

        while(list2End.next != null){
            list2End = list2End.next;
        }

        ListNode lastHalf = list1;

        for(int i=0;i<=b;i++){
            lastHalf = lastHalf.next;
        }

        prevA.next = list2;
        list2End.next = lastHalf;
        return list1;
    }
}