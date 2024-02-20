package lcr;

/**
 * 2024/2/2
 * lamic
 **/
public class LCR027 {
    public boolean isPalindrome(ListNode head) {
        ListNode border = new ListNode();
        border.next = head;
        ListNode fast = border;
        ListNode slow = border;
        while(fast!= null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = reverse(slow.next);
         slow.next = null;
        ListNode l1 = head;
        ListNode l2 = head2;
        while(l1!=null&&l2 != null){
            if(l1.val !=l2.val){
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if((l1 == null&& l2 == null )|| l1.next == null || l2.next == null ){
            return true;
        }
        return false;


    }

    private ListNode reverse(ListNode head){
        ListNode border = new ListNode();
        border.next = head;
        while(head.next!=null){
            ListNode originNext = head.next.next;
            head.next.next = border.next;
            border.next = head.next;
            head.next = originNext;

        }
        return border.next;
    }

    public static void main(String[] args) {
        LCR027 lcr027 = new LCR027();
        //6,5,4,7,9,10
        ListNode head = new ListNode(1);
        ListNode sec = new ListNode(2);
        head.next = sec;
        ListNode thir = new ListNode(2);
        ListNode four = new ListNode(2);
        ListNode five = new ListNode(2);
        ListNode six = new ListNode(1);
        sec.next = thir;
        thir.next = four;
        four.next = five;
        five.next = six;
        System.out.println(lcr027.isPalindrome(head));
    }
}
