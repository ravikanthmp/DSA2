package DSA.leetcode;

public class Q142 {
    public ListNode detectCycle(ListNode head) {
        ListNode meetingPoint = meetingPoint(head);
        if(meetingPoint == null){
            return null;
        }else{
            ListNode outsideLoopPtr = head;
            ListNode insideLoopPtr = meetingPoint;
            while(insideLoopPtr != outsideLoopPtr){
                insideLoopPtr = insideLoopPtr.next;
                outsideLoopPtr = outsideLoopPtr.next;
            }
            return insideLoopPtr;
        }
    }


    private ListNode meetingPoint(ListNode head){
        ListNode fast = head;
        ListNode slow = fast;
        while(fast != null && fast.next != null){

            fast = fast.next.next;
            slow= slow.next;

            if(fast == slow){
                return fast;
            }
        }
        return null;
    }

}
