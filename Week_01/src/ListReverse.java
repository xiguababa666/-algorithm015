public class ListReverse {



    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode curr = prev.next;
        while (prev.next != null) {
            prev.next = curr.next;
            curr.next = head;

            head = curr;
            curr = prev.next;
        }
        return head;


    }


    public static void main(String[] args) {
        ListNode l = ListNode.create(new int[] {1,2,3,4,5});


        System.out.println(new ListReverse().reverseList(l));

    }

}
