package lcr;

/**
 * 2024/2/2
 * lamic
 **/
public class LCR026 {
    public void reorderList(ListNode head) {
        change(head);

    }


    private void change(ListNode node){
        // 拆一半链表
        ListNode slow = node;
        ListNode fast = node;
        while(fast!=null && fast.next != null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;

        }
        //维持两个链表头
        ListNode head2 = slow.next;
        slow.next = null;
        //后一个链表反转
        ListNode newHead = reverse(head2);
        //按顺序合并
        // ListNode resultHead = new ListNode();
        ListNode cur = node;
        ListNode head = node;
        while(cur!= null && newHead!= null){
            ListNode originNext = cur.next;
            cur.next = newHead;
            newHead = newHead.next;
            cur.next.next = originNext;
            cur = originNext;



        }
        System.out.println(head);

    }



    private ListNode reverse(ListNode head){
        ListNode border = new ListNode();
        border.next = head;
        while(head!= null && head.next!= null){
            ListNode originNext = head.next.next;
            head.next.next = border.next;

            border.next = head.next;
            head.next = originNext;

        }
        return border.next;
    }


    public static void main(String[] args) {
        LCR026 lcr026 = new LCR026();
        //6,5,4,7,9,10
        ListNode head = new ListNode(6);
        ListNode sec = new ListNode(5);
        head.next = sec;
        ListNode thir = new ListNode(4);
        ListNode four = new ListNode(7);
        ListNode five = new ListNode(9);
        ListNode six = new ListNode(10);
        sec.next = thir;
        thir.next = four;
        four.next = five;
        five.next = six;
        lcr026.change(head);
    }
}
