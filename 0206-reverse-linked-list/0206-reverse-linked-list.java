
import java.lang.classfile.instruction.ReturnInstruction;
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = head;

        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}