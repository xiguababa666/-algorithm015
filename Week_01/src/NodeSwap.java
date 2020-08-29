
/**
 * description
 *
 * @author xyx
 * @date 2020/8/27 10:52
 */
public class NodeSwap {





    // 一次遍历
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode pre = head, tail = null;
        ListNode post = pre.next;
        ListNode ret = head.next;

        while (post != null) {
            pre.next = post.next;
            post.next = head;
            if (tail != null)
                tail.next = post;

            tail = pre;
            pre = pre.next;
            if (pre == null) break;
            head = pre;
            post = pre.next;
        }

        return ret;

    }


    // 递归
    public ListNode swapPairs2(ListNode head) {
        // todo
        return null;
    }


    public static void main(String[] args) {

        ListNode l = ListNode.create(new int[] {1,2});
        System.out.println(l);

        System.out.println(new NodeSwap().swapPairs(l));





    }


}
