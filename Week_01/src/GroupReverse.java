import java.util.LinkedList;
import java.util.List;

/**
 * description
 *
 * @author xyx
 * @date 2020/8/27 10:52
 */
public class GroupReverse {




    public ListNode reverseKGroup(ListNode head, int k) {



        // 第二版
        if (k < 2 || head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode post = head.next;
        ListNode start = head;
        int i = 0, ik = 0;
        ListNode lastTail = null;
        while(post != null) {
            pre.next = post.next;
            post.next = start;
            start = post;
            if (ik == 0) {
                head = post;
            } else {
                lastTail.next = start;
            }
            post = pre.next;
            i++;

            if (i == k - 1) {
                ik++;
                i = 0;
                lastTail = pre;
                pre = start = post;
                if (post == null) break;
                post = post.next;
            } else if (post == null) {
                pre = start;
                post = pre.next;
                while(post != null) {
                    pre.next = post.next;
                    post.next = start;
                    start = post;
                    post = pre.next;
                }
                if (lastTail == null) {
                    head = start;
                } else {
                    lastTail.next = start;
                }
                break;
            }
        }
        return head;



        // 第一版
        //if (k < 2 || head == null) {
        //    return head;
        //}
        //ListNode p = head;
        //int i = 0, size = 0;
        //List<ListNode> starts = new LinkedList<>();
        //while(p != null) {
        //    i++;
        //    if ((i - 1) % k == 0) {
        //        starts.add(p);
        //        size++;
        //    }
        //    p = p.next;
        //}
        //if (i % k != 0) {
        //    size--;
        //}
        //for (int idx = 0; idx < size; idx++) {
        //    ListNode start = starts.get(idx);
        //    ListNode prev = start;
        //    ListNode post;
        //    for (int j = 0; j < k - 1; j++) {
        //        post = prev.next;
        //        if (post == null) {
        //            break;
        //        }
        //        prev.next = post.next;
        //        post.next = start;
        //        start = post;
        //    }
        //    if (idx != 0) {
        //        starts.get(idx - 1).next = start;
        //    } else {
        //        head = start;
        //    }
        //}
        //return head;
    }


    public static void main(String[] args) {

        //ListNode l = ListNode.create(new int[] {1,2,3,4,5,6,7,8,9,10});
        //System.out.println(l);
        //
        //System.out.println(new GroupReverse().reverseKGroup(l, 4));
        //System.out.println(new GroupReverse().reverse(l, 4));





    }


}
