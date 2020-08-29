/**
 * description
 *
 * @author xyx
 * @date 2020/8/27 10:54
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode h = next;
        while (h != null) {
            sb.append("->").append(h.val);
            h = h.next;
        }
        return sb.toString();
    }

    public static ListNode create(int[] arr) {

        ListNode head = null;
        ListNode l = null;
        for (int i : arr) {
            if (head == null) {
                head = new ListNode(i);
                l = head;
            } else {
                l.next = new ListNode(i);
                l = l.next;
            }
        }
        return head;
    }


}
