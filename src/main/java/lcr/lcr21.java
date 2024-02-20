package lcr;

/**
 * 2024/2/2
 * lamic
 **/
public class lcr21 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        if(head.next == null && n>0){
            return null;
        }
        ListNode border = new ListNode();
        border.next = head;
        ListNode fast = border;
        ListNode slow = border;
        for(int i = 0;i<n;i++){
            fast = fast.next;
            if(fast == null){
                return head;
            }
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;

    }

    public static void main(String[] args) {
        lcr21 lcr21 = new lcr21();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(lcr21.removeNthFromEnd(head,2));
    }
}
