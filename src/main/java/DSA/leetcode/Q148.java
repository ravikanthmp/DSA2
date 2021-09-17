package DSA.leetcode;

public class Q148 {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }else if (head.next.next == null){
            if (head.next.val < head.val){
                int temp = head.val;;
                head.val = head.next.val;
                head.next.val = temp;
            }
            return head;
        }else {
            ListNode beforeMid = mid(head);
            ListNode mid = beforeMid.next;
            beforeMid.next = null;
            ListNode part1 = sortList(head);
            ListNode part2 = sortList(mid);
            return merge(part1, part2);

        }
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while (h1 != null || h2 != null){
            if (h1 == null){
                curr.next = h2;
                h2 = h2.next;
            }else if (h2 == null){
                curr.next = h1;
                h1 = h1.next;
            }else {
                int cmp = Integer.compare(h1.val, h2.val);
                if (cmp <= 0){
                    curr.next = h1;
                    h1 = h1.next;
                }else {
                    curr.next = h2;
                    h2 = h2.next;
                }
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }

    private ListNode mid(ListNode head) {

        ListNode fast = head;
        ListNode slow = fast;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
